package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "PRODUCTSALE")
public class ProductSale extends AbstractModel {
    private LocalDate saleDate;
    private Integer productCount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "AGENTID", referencedColumnName = "ID", nullable = false)
    private Agent agent;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID", nullable = false)
    private Product product;

    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", productCount=" + productCount +
                '}';
    }
}
