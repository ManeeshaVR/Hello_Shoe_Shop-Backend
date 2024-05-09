package software.vimukthirajapaksha.shoe_shop_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "size")
public class SizeEntity {

    @Id
    private String sizeId;
    @Column(unique = true)
    private Integer size;

    @OneToMany(mappedBy = "sizeEntity")
    @JsonManagedReference
    private List<ItemSizeEntity> itemSizeEntities;

}
