package software.vimukthirajapaksha.shoe_shop_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItem {
    private String itemCode;
    private Integer size;
    private Double unitPrice;
    private Integer itemQty;
}
