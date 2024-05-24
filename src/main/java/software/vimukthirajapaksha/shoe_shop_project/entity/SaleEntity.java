package software.vimukthirajapaksha.shoe_shop_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.PaymentMethod;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class SaleEntity {
    @Id
    private String orderId;
    private Timestamp date;
    private Double total;
    private Double addedPoints;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customerId", nullable = false)
    private CustomerEntity customer;
    @OneToMany(mappedBy = "saleEntity")
    @JsonManagedReference
    private List<SaleDetailsEntity> saleDetailsEntities;
}
