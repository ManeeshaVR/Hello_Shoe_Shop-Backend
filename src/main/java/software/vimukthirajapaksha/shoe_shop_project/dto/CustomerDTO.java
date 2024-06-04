package software.vimukthirajapaksha.shoe_shop_project.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Gender;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.Level;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    @Null
    private String customerId;
    @NotBlank(message = "Customer name cannot be blank")
    private String name;
    @NotNull(message = "Gender cannot be null")
    private Gender gender;
    @Null
    @PastOrPresent(message = "Join date must be in the past or present")
    private Date joinedDate;
    @Past(message = "Date of birth should be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private Date dob;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @NotBlank(message = "Contact No cannot be blank")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid contact number format")
    private String contact;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @Null
    private Double totalPoints;
    @Null
    private Timestamp lastSaleDate;
    @Null
    private Level level;
}

