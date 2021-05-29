package karmanchik.demoexam.dbservice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

@Data
@Entity
@Table(name = "SUPPLIER")
@EqualsAndHashCode(callSuper = true)
public class Supplier extends AbstractModel {
    private String title;
    private String inn;
    private LocalDate startDate;
    private Integer qualityRating;
    private String supplierType;

    @OneToMany(mappedBy = "supplier")
    private Collection<MaterialSupplier> materialSuppliers;
}
