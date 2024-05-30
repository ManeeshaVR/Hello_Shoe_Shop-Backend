package software.vimukthirajapaksha.shoe_shop_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import software.vimukthirajapaksha.shoe_shop_project.entity.RefundEntity;

public interface RefundRepo extends JpaRepository<RefundEntity, String> {
}