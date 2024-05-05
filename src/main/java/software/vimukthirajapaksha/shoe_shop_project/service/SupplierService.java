package software.vimukthirajapaksha.shoe_shop_project.service;

import software.vimukthirajapaksha.shoe_shop_project.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO saveSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(String supplierCode);
    SupplierDTO getSelectedSupplier(String supplierCode);
    List<SupplierDTO> getAllSupplier();
    void updateSupplier(String supplierCode,SupplierDTO supplierDTO);
}
