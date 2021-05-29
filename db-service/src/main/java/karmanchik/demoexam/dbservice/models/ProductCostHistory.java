package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "PRODUCTCOSTHISTORY")
@EqualsAndHashCode(callSuper = true)
public class ProductCostHistory extends AbstractModel {
    private LocalDate changeDate;
    private BigDecimal costValue;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID", nullable = false)
    private Product product;

}
