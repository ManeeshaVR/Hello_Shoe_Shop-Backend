package software.vimukthirajapaksha.shoe_shop_project.service;

import software.vimukthirajapaksha.shoe_shop_project.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    void saveSupplier(SupplierDTO supplierDTO);
    void deleteSupplier(String supplierId);
    SupplierDTO getSelectedSupplier(String supplierId);
    List<SupplierDTO> getAllSuppliers();
    void updateSupplier(String supplierId,SupplierDTO supplierDTO);
}
