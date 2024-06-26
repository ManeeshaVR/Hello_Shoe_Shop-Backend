package software.vimukthirajapaksha.shoe_shop_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class SaleDetailsKey implements Serializable {
    @Column(name = "orderId")
    private String orderId;
    @Column(name = "itemSizeId")
    private String itemSizeId;
}
