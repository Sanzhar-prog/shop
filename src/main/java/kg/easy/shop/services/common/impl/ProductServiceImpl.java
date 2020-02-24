package kg.easy.shop.services.common.impl;

import kg.easy.shop.dao.ProductRepository;
import kg.easy.shop.models.entities.Product;
import kg.easy.shop.services.common.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            throw new RuntimeException("Такого товара нет");
        }

        return product;
    }
}
