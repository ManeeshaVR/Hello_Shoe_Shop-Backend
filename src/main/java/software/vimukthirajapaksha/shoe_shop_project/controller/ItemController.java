package software.vimukthirajapaksha.shoe_shop_project.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.vimukthirajapaksha.shoe_shop_project.dto.ItemDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;

    @GetMapping("/check")
    public String checkTest(){
        logger.info("Item Checked");
        return "Item Check Test";
    }

    @GetMapping
    public List<ItemDTO> getAllItems() {
        logger.info("Fetching all items");
        return itemService.getAllItem();
    }

    @PostMapping
    public ItemDTO saveItem(@RequestBody ItemDTO item) {
        logger.info("Saving item: {}", item);
        return itemService.saveItem(item);
    }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable String id) {
        logger.info("Fetching item with ID: {}", id);
        return itemService.getSelectedItem(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable String id, @RequestBody ItemDTO itemDTO) {
        logger.info("Updating item with ID: {}", id);
        itemService.updateItem(id, itemDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String id) {
        logger.info("Deleting item with ID: {}", id);
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}
