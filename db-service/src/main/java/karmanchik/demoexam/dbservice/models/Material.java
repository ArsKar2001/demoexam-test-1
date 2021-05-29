package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Data
@Entity
@Table(name = "MATERIAL")
@EqualsAndHashCode(callSuper = true)
public class Material extends AbstractModel {
    private String title;
    private Integer countInPack;
    private String unit;
    private Double countInStock;
    private Double minCount;
    private String description;
    private BigDecimal cost;
    private String image;

    @ManyToOne
    @JoinColumn(name = "MATERIALTYPEID", referencedColumnName = "ID", nullable = false)
    private MaterialType type;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "material")
    private Collection<MaterialCountHistory> countHistories;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "material")
    private Collection<MaterialSupplier> materialSuppliers;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "material")
    private Collection<ProductMaterial> productMaterials;

}
