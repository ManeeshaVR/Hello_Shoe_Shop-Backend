package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.vimukthirajapaksha.shoe_shop_project.dao.CustomerRepo;
import software.vimukthirajapaksha.shoe_shop_project.dao.ItemRepo;
import software.vimukthirajapaksha.shoe_shop_project.dao.SaleRepo;
import software.vimukthirajapaksha.shoe_shop_project.dto.AdminPanelDTO;
import software.vimukthirajapaksha.shoe_shop_project.entity.ItemEntity;
import software.vimukthirajapaksha.shoe_shop_project.service.AdminPanelService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminPanelServiceIMPL implements AdminPanelService {

    private final SaleRepo saleRepo;
    private final ItemRepo itemRepo;
    private final CustomerRepo customerRepo;

    @Override
    public AdminPanelDTO getPanelData() {
        AdminPanelDTO adminPanelDTO = new AdminPanelDTO();
        adminPanelDTO.setTotalProfit(saleRepo.findTotalProfit());
        adminPanelDTO.setTotalSales(saleRepo.findTotalSales());
        adminPanelDTO.setVerityTypeQuantities(itemRepo.getVerityTypeQuantity());
        adminPanelDTO.setTotalCustomers((int) customerRepo.count());

        List<ItemEntity> itemEntities = itemRepo.findMostSoldItems();
        if (!itemEntities.isEmpty()) {
            ItemEntity itemEntity = itemEntities.get(0);
            adminPanelDTO.setMostSaleItem(itemEntity.getItemDesc());
            adminPanelDTO.setMostSaleItemPic(itemEntity.getItemPic());
        }

        return adminPanelDTO;
    }
}
