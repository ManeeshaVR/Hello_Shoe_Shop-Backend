package software.vimukthirajapaksha.shoe_shop_project.service;

import software.vimukthirajapaksha.shoe_shop_project.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    void saveInventory(InventoryDTO inventoryDTO);
    List<InventoryDTO> getAllInventories();
    InventoryDTO getSelectedInventory(String id);
    void deleteInventory(String id);
    void updateInventory(String id, InventoryDTO inventoryDTO);
}
