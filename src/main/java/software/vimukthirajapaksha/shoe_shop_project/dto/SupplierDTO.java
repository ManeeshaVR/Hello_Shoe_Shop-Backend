package software.vimukthirajapaksha.shoe_shop_project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Category;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO {
    private String supplierId;
    private String supplierName;
    private Category supplierCategory;
    private String address;
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact1;
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact2;
    @Email(message = "Invalid email format")
    private String email;
}

