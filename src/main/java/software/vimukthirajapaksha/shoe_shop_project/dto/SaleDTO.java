package software.vimukthirajapaksha.shoe_shop_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.vimukthirajapaksha.shoe_shop_project.entity.enums.PaymentMethod;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleDTO {
    private String orderId;
    private String customerId;
    private Double totalPrice;
    private Timestamp purchaseDate;
    private PaymentMethod paymentMethod;
    private Double addedPoints;
    private String userId;
    private List<OrderItem> orderItems;
}