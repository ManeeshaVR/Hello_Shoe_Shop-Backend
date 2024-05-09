package software.vimukthirajapaksha.shoe_shop_project.service;

import software.vimukthirajapaksha.shoe_shop_project.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO saveItem(ItemDTO itemDTO);
    void deleteItem(String itemId);
    ItemDTO getSelectedItem(String itemId);
    List<ItemDTO> getAllItem();
    void updateItem(String itemId,ItemDTO itemDTO);
}
