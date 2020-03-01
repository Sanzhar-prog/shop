package kg.easy.shop.services.impl;

import kg.easy.shop.dao.*;
import kg.easy.shop.mappers.ClassMapper;
import kg.easy.shop.models.dto.*;
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

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public UserStatus saveUserStatus(UserStatusDto userStatusDto) {
        UserStatus userStatus = ClassMapper.INSTANCE.userStatusDtoToUserStatus(userStatusDto);
        return userStatusRepository.save(userStatus);
    }

    @Override
    public List<UserStatusDto> getUserStatusList() {
        List<UserStatus> userStatuses = userStatusRepository.findAll();
        List<UserStatusDto> userStatusDtos = ClassMapper.INSTANCE.userStatusesToUserStatusDtos(userStatuses);
        return userStatusDtos;
    }

    // Метод для сохранения пользователя и телефона пользователя
    @Override
    public User saveUser(UserDto userDto) {
        User user = ClassMapper.INSTANCE.userDtoToUser(userDto);

        user = userRepository.save(user);

        List<UserPhone> phones = userPhoneRepository.saveAll(user.getPhones());

        User finalUser = user;
        phones.stream().forEach(x->x.setUser(finalUser));

        user.setPhones(userPhoneRepository.saveAll(phones));
        return user;
    }

    @Override
    public List<UserDto> getUserList() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = ClassMapper.INSTANCE.usersToUserDtos(users);
        return userDtos;
    }

    // Метод для сохранения Посавщика и номера телефона Поставщика
    @Override
    public Supplier saveSupplier(SupplierDto supplierDto) {
        Supplier supplier = ClassMapper.INSTANCE.supplierDtoToSupplier(supplierDto);
        supplier = supplierRepository.save(supplier);

        List<SupplierPhone> phones = supplierPhoneRepository.saveAll(supplier.getPhones());

        Supplier finalSupplier = supplier;
        phones.stream().forEach(x -> x.setSupplier(finalSupplier));

        supplier.setPhones(supplierPhoneRepository.saveAll(phones));

        return supplier;
    }

    @Override
    public List<SupplierDto> getSupplierList() {

        List<Supplier> suppliers = supplierRepository.findAll();
        suppliers.stream().forEach(x -> x.setPhones(supplierPhoneRepository.findAllBySupplier(x)));

        List<SupplierDto> supplierDtos = ClassMapper.INSTANCE.suppliersToSupplierDtos(suppliers);
        List<SupplierPhone> supplierPhones = supplierPhoneRepository.findAll();
        List<SupplierPhoneDto> supplierPhoneDtos = ClassMapper.INSTANCE.supplierPhonesToSupplierPhoneDtoes(supplierPhones);
        supplierDtos.stream().forEach(x->x.setPhones(supplierPhoneDtos));//??? Добавление списка телефонов ДТО Поставщиков
        return supplierDtos;
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = ClassMapper.INSTANCE.customerDtoToCustomer(customerDto);
        customer = customerRepository.save(customer);

        List<CustomerPhone> phones = customerPhoneRepository.saveAll(customer.getPhones());

        Customer finalCustomer = customer;
        phones.stream().forEach(x -> x.setCustomer(finalCustomer));

        customer.setPhones(customerPhoneRepository.saveAll(phones));
        return customer;
    }

    @Override
    public List<CustomerDto> getCustomerList() {

        List<Customer> customers = customerRepository.findAll();
        customers.stream().forEach(x -> x.setPhones(customerPhoneRepository.findAllByCustomer(x)));

        List<CustomerDto> customerDtos = ClassMapper.INSTANCE.customerToCustomerDtos(customers);
        List<CustomerPhone> customerPhones = customerPhoneRepository.findAll();
        List<CustomerPhoneDto> customerPhoneDtos = ClassMapper.INSTANCE.customerPhonesToCustomerPhoneDtos(customerPhones);
        customerDtos.stream().forEach(x->x.setPhones(customerPhoneDtos));
        return customerDtos;
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
    public Product saveProduct(ProductDto productDto) {

        Product product = ClassMapper.INSTANCE.productDtoToProduct(productDto);

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

    @Override
    public Income saveIncome(IncomeDto incomeDto) {
        Income income = ClassMapper.INSTANCE.incomeDtoToIncome(incomeDto);
        return incomeRepository.save(income);
    }

    @Override
    public List<Income> getIncomeList() {
        return incomeRepository.findAll();
    }


}
