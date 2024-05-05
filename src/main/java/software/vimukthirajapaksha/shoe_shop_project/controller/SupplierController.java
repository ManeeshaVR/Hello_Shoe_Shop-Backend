package software.vimukthirajapaksha.shoe_shop_project.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.vimukthirajapaksha.shoe_shop_project.dto.SupplierDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    private final SupplierService supplierService;

    @GetMapping("/check")
    public String checkTest(){
        logger.info("Supplier Checked");
        return "Supplier Check Test";
    }

    @PostMapping
    public SupplierDTO saveSupplier(@RequestBody SupplierDTO supplierDTO) {
        logger.info("Saving supplier: {}", supplierDTO);
        return supplierService.saveSupplier(supplierDTO);
    }

    @GetMapping
    public List<SupplierDTO> getAllSupplier() {
        logger.info("Fetching all suppliers");
        return supplierService.getAllSupplier();
    }

    @GetMapping("/{id}")
    public SupplierDTO getSupplierById(@PathVariable String id) {
        logger.info("Fetching supplier with ID: {}", id);
        return supplierService.getSelectedSupplier(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable String id, @RequestBody SupplierDTO supplierDTO) {
        logger.info("Updating supplier with ID: {}", id);
        supplierService.updateSupplier(id, supplierDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable String id) {
        logger.info("Deleting supplier with ID: {}", id);
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok().build();
    }
}
