package software.vimukthirajapaksha.shoe_shop_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sale_details")
public class SaleDetailsEntity {
    @Id
    private String saleDetailsId;
    @ManyToOne
    @JoinColumn(name = "orderId")
    @JsonBackReference
    private SaleEntity saleEntity;
    @ManyToOne
    @JoinColumn(name = "itemSizeId")
    @JsonBackReference
    private ItemSizeEntity itemSizeEntity;
    private Integer qty;
    private Double unitPrice;
}
