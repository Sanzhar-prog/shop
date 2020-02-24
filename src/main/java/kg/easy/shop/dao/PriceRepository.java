package kg.easy.shop.dao;

import kg.easy.shop.models.entities.Price;
import kg.easy.shop.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    Price findByProductAndEndDate(Product product, Date date);
}
