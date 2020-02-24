package kg.easy.shop.services.common;

import kg.easy.shop.models.entities.Product;

public interface ProductService {

    Product saveProduct(Product product);

    Product getProductById(Long id);
}
