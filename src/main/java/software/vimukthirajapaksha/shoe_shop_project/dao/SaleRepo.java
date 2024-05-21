package software.vimukthirajapaksha.shoe_shop_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import software.vimukthirajapaksha.shoe_shop_project.entity.SaleEntity;

public interface SaleRepo extends JpaRepository<SaleEntity, String> {
}
