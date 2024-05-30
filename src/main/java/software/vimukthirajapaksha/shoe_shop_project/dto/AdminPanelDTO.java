package software.vimukthirajapaksha.shoe_shop_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminPanelDTO {
    private Double totalSales;
    private Double totalProfit;
    private Integer totalCustomers;
    private String mostSaleItem;
    private String mostSaleItemPic;
    private List<VerityTypeQuantity> verityTypeQuantities;
}