package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.vimukthirajapaksha.shoe_shop_project.dao.ItemRepo;
import software.vimukthirajapaksha.shoe_shop_project.dto.ItemDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.ItemService;
import software.vimukthirajapaksha.shoe_shop_project.util.Mapping;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceIMPL implements ItemService {
    private final ItemRepo repo;
    private final Mapping mapping;

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
//        itemDTO.setItemCode(UUID.randomUUID().toString());
        return mapping.toItemDTO(repo.save(mapping.toItemEntity(itemDTO)));
    }

    @Override
    public void deleteItem(String itemId) {
        repo.delete(repo.getReferenceById(itemId));
    }

    @Override
    public ItemDTO getSelectedItem(String itemId) {
        return mapping.toItemDTO(repo.getReferenceById(itemId));
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return mapping.toItemDTOList(repo.findAll());
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        repo.save(mapping.toItemEntity(itemDTO));
    }
}
