package software.vimukthirajapaksha.shoe_shop_project.service;

import software.vimukthirajapaksha.shoe_shop_project.dto.RefundDTO;
import software.vimukthirajapaksha.shoe_shop_project.dto.SaleDTO;
import software.vimukthirajapaksha.shoe_shop_project.dto.SaleDetailsDTO;

import java.util.List;

public interface SaleService {
    void saveSale(SaleDTO saleDTO);
    List<SaleDTO> getAllSales();
    List<SaleDetailsDTO> getSelectedSale(String id);
    void saveRefund(RefundDTO refundDTO);

}
