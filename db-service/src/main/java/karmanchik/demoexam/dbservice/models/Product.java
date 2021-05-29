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
@Table(name = "PRODUCT")
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractModel {
    private String title;
    private String articleNumber;
    private String description;
    private String image;
    private Integer productionPersonCount;
    private Integer productionWorkshopNumber;
    private BigDecimal minCostForAgent;

    @ManyToOne
    @JoinColumn(name = "PRODUCTTYPEID", referencedColumnName = "ID")
    private ProductType type;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "product")
    private Collection<ProductCostHistory> costHistory;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "product")
    private Collection<ProductMaterial> productMaterials;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "product")
    private Collection<ProductSale> sales;

}
