package software.vimukthirajapaksha.shoe_shop_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Gender;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.OccasionType;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.VerityType;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryDTO {
    private String itemCode;
    private String itemDesc;
    private String itemPic;
    private Gender gender;
    private OccasionType occasionType;
    private VerityType verityType;
    private List<ItemSizeDTO> itemSizeDTOS;
    private String supplierId;
    private String supplierName;
    private Double sellingPrice;
    private Double buyingPrice;
    private Double profit;
    private Double profitMargin;
    private String status;
}
