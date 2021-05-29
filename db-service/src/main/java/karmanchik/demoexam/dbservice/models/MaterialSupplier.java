package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MATERIALSUPPLIER")
public class MaterialSupplier {
    @EmbeddedId
    private MaterialSupplierPK pk;

    @MapsId("materialId")
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "MATERIALID", referencedColumnName = "ID", nullable = false)
    private Material material;

    @MapsId("supplierId")
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "SUPPLIERID", referencedColumnName = "ID", nullable = false)
    private Supplier supplier;
}
