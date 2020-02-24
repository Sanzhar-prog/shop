package kg.easy.shop.services.impl;

import kg.easy.shop.dao.*;
import kg.easy.shop.models.entities.*;
import kg.easy.shop.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    LocalDate date = LocalDate.of(2999, 12, 31);
    Date maxDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierPhoneRepository supplierPhoneRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerPhoneRepository customerPhoneRepository;

    @Autowired
    private UserPhoneRepository userPhoneRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public UserStatus saveUserStatus(UserStatus userStatus) {
        return userStatusRepository.save(userStatus);
    }

    @Override
    public List<UserStatus> getUserStatusList() {
        return userStatusRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        supplier = supplierRepository.save(supplier);

        List<SupplierPhone> phones = supplierPhoneRepository.saveAll(supplier.getPhones());

        Supplier finalSupplier = supplier;
        phones.stream().forEach(x -> x.setSupplier(finalSupplier));

        supplier.setPhones(supplierPhoneRepository.saveAll(phones));

        return supplier;
    }

    @Override
    public List<Supplier> getSupplierList() {

        List<Supplier> suppliers = supplierRepository.findAll();
        suppliers.stream().forEach(x -> x.setPhones(supplierPhoneRepository.findAllBySupplier(x)));

        return suppliers;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer = customerRepository.save(customer);

        List<CustomerPhone> phones = customerPhoneRepository.saveAll(customer.getPhones());

        Customer finalCustomer = customer;
        phones.stream().forEach(x -> x.setCustomer(finalCustomer));

        customer.setPhones(customerPhoneRepository.saveAll(phones));
        return customer;
    }

    @Override
    public List<Customer> getCustomerList() {

        List<Customer> customers = customerRepository.findAll();
        customers.stream().forEach(x -> x.setPhones(customerPhoneRepository.findAllByCustomer(x)));

        return customers;
    }

    @Override
    public List<UserPhone> getUserPhoneList(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            return userPhoneRepository.findAllByUser(user);
        }

        return null;
    }

    @Override
    public Product saveProduct(Product product) {


        Price newPrice = product.getPrice();
        newPrice.setStartDate(new Date());
        newPrice.setEndDate(maxDate);
        List<Price> prices = new ArrayList<>();

        if (product.getId() == null) {
            product = productRepository.save(product);
            newPrice.setProduct(product);
            newPrice = priceRepository.save(newPrice);
            product.setPrice(newPrice);
        } else {
            product = productRepository.save(product);
            Price currentPrice = priceRepository.findByProductAndEndDate(product, maxDate);

            if (currentPrice.getPrice() != newPrice.getPrice()) {
                newPrice.setProduct(product);
                currentPrice.setEndDate(new Date());

                prices.add(currentPrice);
                prices.add(newPrice);

                prices = priceRepository.saveAll(prices);

                newPrice = prices.stream()
                        .filter(x-> x.getEndDate().equals(maxDate))
                        .findFirst()
                        .get();

                product.setPrice(newPrice);
            } else {
                product.setPrice(currentPrice);
            }

        }

        return product;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> products = productRepository.findAll();

        products.stream()
                .forEach(x -> x.setPrice(priceRepository.findByProductAndEndDate(x, maxDate)));


        return products;
    }

    @Override
    public Price savePrice(Price price) {
        return null;
    }

    @Override
    public List<Price> getPriceList() {
        return null;
    }


}
