package software.vimukthirajapaksha.shoe_shop_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "refund")
public class RefundEntity {
    @Id
    private String refundId;
    private Timestamp date;
    private Double amount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private SaleEntity saleEntity;
}
