package software.vimukthirajapaksha.shoe_shop_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements SuperEntity{

    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;

    @OneToOne
    private EmployeeEntity employee;

    public String getUsername() {
        return email;
    }
}
