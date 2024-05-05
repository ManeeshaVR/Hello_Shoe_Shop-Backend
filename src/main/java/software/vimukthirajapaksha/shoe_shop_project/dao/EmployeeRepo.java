package software.vimukthirajapaksha.shoe_shop_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.vimukthirajapaksha.shoe_shop_project.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,String> {
}
