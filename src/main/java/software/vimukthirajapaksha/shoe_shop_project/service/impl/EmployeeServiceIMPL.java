package software.vimukthirajapaksha.shoe_shop_project.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.vimukthirajapaksha.shoe_shop_project.dao.EmployeeRepo;
import software.vimukthirajapaksha.shoe_shop_project.dto.EmployeeDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.EmployeeService;
import software.vimukthirajapaksha.shoe_shop_project.util.Mapping;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeRepo repo;
    private final Mapping mapping;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
//        employeeDTO.setEmployeeCode(UUID.randomUUID().toString());
        return mapping.toEmployeeDTO(repo.save(mapping.toEmployeeEntity(employeeDTO)));
    }

    @Override
    public void deleteEmployee(String employeeId) {
        repo.delete(repo.getReferenceById(employeeId));
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String employeeId) {
        return mapping.toEmployeeDTO(repo.getReferenceById(employeeId));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return mapping.toEmployeeDTOList(repo.findAll());
    }

    @Override
    public void updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        repo.save(mapping.toEmployeeEntity(employeeDTO));
    }
}
