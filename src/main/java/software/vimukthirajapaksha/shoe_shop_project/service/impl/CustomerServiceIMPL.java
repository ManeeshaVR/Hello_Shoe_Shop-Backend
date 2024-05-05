package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.vimukthirajapaksha.shoe_shop_project.dao.CustomerRepo;
import software.vimukthirajapaksha.shoe_shop_project.dto.CustomerDTO;
import software.vimukthirajapaksha.shoe_shop_project.entity.CustomerEntity;
import software.vimukthirajapaksha.shoe_shop_project.service.CustomerService;
import software.vimukthirajapaksha.shoe_shop_project.util.Mapping;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepo repo;
    private final Mapping mapping;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
//        customerDTO.setCustomerCode(UUID.randomUUID().toString());
        return mapping.toCustomerDTO(repo.save(mapping.toCustomer(customerDTO)));
    }

    @Override
    public void deleteCustomer(String customerId) {
        repo.delete(repo.getReferenceById(customerId));
    }

    @Override
    public CustomerDTO getSelectedCustomer(String customerId) {
        return mapping.toCustomerDTO(repo.getReferenceById(customerId));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.toCustomerDTOList(repo.findAll());
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        CustomerEntity customer = repo.getReferenceById(customerId);
        customer.setName(customerDTO.getName());
        customer.setGender(customerDTO.getGender());
        customer.setJoinDate(customerDTO.getJoinDate());
        customer.setLevel(customerDTO.getLevel());
        customer.setTotalPoints(customerDTO.getTotalPoints());
        customer.setDob(customerDTO.getDob());
        customer.setAddressNo(customerDTO.getAddressNo());
        customer.setLane(customerDTO.getLane());
        customer.setMainCity(customerDTO.getMainCity());
        customer.setMainState(customerDTO.getMainState());
        customer.setPostalCode(customerDTO.getPostalCode());
        customer.setContactNumber(customerDTO.getContactNumber());

        customer.setEmail(customerDTO.getEmail());
        customer.setRecentPurchaseDate(customerDTO.getRecentPurchaseDate());
        repo.save(customer);
    }
}