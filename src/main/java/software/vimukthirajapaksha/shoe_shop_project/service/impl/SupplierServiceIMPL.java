package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.vimukthirajapaksha.shoe_shop_project.dao.SupplierRepo;
import software.vimukthirajapaksha.shoe_shop_project.dto.SupplierDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.SupplierService;
import software.vimukthirajapaksha.shoe_shop_project.util.Mapping;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceIMPL implements SupplierService {

    private final SupplierRepo repo;
    private final Mapping mapping;

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
//        supplierDTO.setSupplierCode(UUID.randomUUID().toString());
        return mapping.toSupplierDTO(repo.save(mapping.toSupplierEntity(supplierDTO)));
    }

    @Override
    public void deleteSupplier(String supplierCode) {
        repo.delete(repo.getReferenceById(supplierCode));
    }

    @Override
    public SupplierDTO getSelectedSupplier(String supplierCode) {
        return mapping.toSupplierDTO(repo.getReferenceById(supplierCode));
    }

    @Override
    public List<SupplierDTO> getAllSupplier() {
        return mapping.toSupplierDTOList(repo.findAll());
    }

    @Override
    public void updateSupplier(String supplierCode, SupplierDTO supplierDTO) {
        repo.save(mapping.toSupplierEntity(supplierDTO));
    }
}