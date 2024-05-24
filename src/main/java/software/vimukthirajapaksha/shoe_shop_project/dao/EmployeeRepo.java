package software.vimukthirajapaksha.shoe_shop_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.vimukthirajapaksha.shoe_shop_project.entity.EmployeeEntity;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {
    Optional<EmployeeEntity> findByEmail(String email);
}
