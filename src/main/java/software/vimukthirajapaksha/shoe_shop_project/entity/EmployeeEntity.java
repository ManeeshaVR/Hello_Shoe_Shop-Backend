package software.vimukthirajapaksha.shoe_shop_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Branch;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Gender;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Role;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
@Entity
public class EmployeeEntity implements SuperEntity{
    @Id
    private String employeeId;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String civilState;
    private String designation;
    private Date dob;
    private Date joinedDate;
    private String address;
    private String contact;
    @Column(unique = true)
    private String email;
    private String guardian;
    private String emergencyContact;
    @Enumerated(EnumType.STRING)
    private Branch branch;
    @Enumerated(EnumType.STRING)
    private Role accessRole;
}
