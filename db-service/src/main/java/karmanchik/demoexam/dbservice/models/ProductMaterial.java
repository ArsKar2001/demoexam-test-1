package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCTMATERIAL")
public class ProductMaterial {

    @EmbeddedId
    private ProductMaterialPK pk;

    private Double count;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID", nullable = false)
    private Product product;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "MATERIALID", referencedColumnName = "ID", nullable = false)
    private Material material;
}
