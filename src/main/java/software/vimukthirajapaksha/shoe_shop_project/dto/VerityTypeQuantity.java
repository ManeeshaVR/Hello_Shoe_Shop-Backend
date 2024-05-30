package software.vimukthirajapaksha.shoe_shop_project.dto;

import lombok.Getter;
import lombok.Setter;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.VerityType;

@Getter
@Setter

public class VerityTypeQuantity {
    private VerityType verityType;
    private Integer quantity;

    public VerityTypeQuantity(VerityType verityType, double quantity) {
        this.verityType = verityType;
        this.quantity = (int) quantity;
    }
}
