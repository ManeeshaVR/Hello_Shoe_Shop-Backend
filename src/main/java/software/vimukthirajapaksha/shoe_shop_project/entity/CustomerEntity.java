package software.vimukthirajapaksha.shoe_shop_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Gender;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Level;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date joinedDate;
    private Date dob;
    private String address;
    private String contact;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SaleEntity> saleEntities;
}
