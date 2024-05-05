package software.vimukthirajapaksha.shoe_shop_project.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.vimukthirajapaksha.shoe_shop_project.dto.EmployeeDTO;
import software.vimukthirajapaksha.shoe_shop_project.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    @GetMapping("/check")
    public String checkTest(){
        logger.info("Employee Checked");
        return "Employee Check Test";
    }

    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employee) {
        logger.info("Saving employee: {}", employee);
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable String id) {
        logger.info("Fetching employee with ID: {}", id);
        return employeeService.getSelectedEmployee(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO) {
        logger.info("Updating employee with ID: {}", id);
        employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        logger.info("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
