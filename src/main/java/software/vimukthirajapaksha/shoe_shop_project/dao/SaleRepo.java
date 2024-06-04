package software.vimukthirajapaksha.shoe_shop_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import software.vimukthirajapaksha.shoe_shop_project.entity.SaleEntity;

public interface SaleRepo extends JpaRepository<SaleEntity, String> {
    @Query("SELECT MAX(s.orderId) FROM SaleEntity s WHERE s.orderId LIKE 'ORD-%'")
    String findLastOrderId();

    @Query("SELECT SUM(s.total) FROM SaleEntity s")
    Double findTotalSales();

    @Query("SELECT SUM((sd.unitPrice - sd.itemSizeEntity.itemEntity.buyingPrice) * sd.qty) " +
            "FROM SaleDetailsEntity sd")
    Double findTotalProfit();
}
