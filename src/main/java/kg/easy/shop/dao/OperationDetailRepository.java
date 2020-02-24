package kg.easy.shop.dao;

import kg.easy.shop.models.entities.Operation;
import kg.easy.shop.models.entities.OperationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationDetailRepository extends JpaRepository<OperationDetail, Long> {

    List<OperationDetail> findAllByOperation(Operation operation);
}
