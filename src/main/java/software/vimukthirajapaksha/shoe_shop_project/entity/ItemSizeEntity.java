package software.vimukthirajapaksha.shoe_shop_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item_size")
public class ItemSizeEntity {
    @Id
    private String itemSizeId;
    private Integer qty;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "itemCode", nullable = false)
    private ItemEntity itemEntity;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "sizeId", nullable = false)
    private SizeEntity sizeEntity;
    @OneToMany(mappedBy = "itemSizeEntity")
    @JsonManagedReference
    private List<SaleDetailsEntity> saleDetailsEntities;
}
