package software.vimukthirajapaksha.shoe_shop_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import software.vimukthirajapaksha.shoe_shop_project.entity.SaleDetailsEntity;

import java.util.List;

public interface SaleDetailsRepo extends JpaRepository<SaleDetailsEntity, String> {
    @Query("SELECT sd FROM SaleDetailsEntity sd WHERE sd.saleEntity.orderId = :orderId")
    List<SaleDetailsEntity> findSaleDetailsByOrderId(@Param("orderId") String orderId);
}
