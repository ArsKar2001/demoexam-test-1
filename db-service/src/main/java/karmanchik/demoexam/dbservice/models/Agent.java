package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.Year;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "AGENT")
@EqualsAndHashCode(callSuper = false)
public class Agent extends AbstractModel {
    private String title;
    private String address;
    private String inn;
    private String kpp;
    private String directorName;
    private String phone;
    private String email;
    private String logo;
    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "AGENTTYPEID", referencedColumnName = "ID", nullable = false)
    private AgentType type;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<AgentPriorityHistory> priorityHistories;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<ProductSale> sales;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<Shop> shops;

    public Integer getAverage() {
        int lastYear = sales.stream()
                .mapToInt(sale -> sale.getSaleDate().getYear())
                .distinct()
                .max()
                .orElse(0);
        return (int) sales.stream()
                .filter(productSale -> productSale.getSaleDate().getYear() == lastYear)
                .mapToInt(sale -> sales.stream()
                        .filter(s -> s.getSaleDate().getYear() == lastYear)
                        .mapToInt(ProductSale::getProductCount).sum() * sale.getProduct().getProductionPersonCount())
                .average()
                .orElse(0);
    }

    public Integer getPercent() {
        int sumCost = sales.stream()
                .mapToInt(sale -> sale.getProduct().getMinCostForAgent().intValue() * sale.getProductCount())
                .sum();
        return
                sumCost > 10_000 ?
                        sumCost > 50_000 ?
                                sumCost > 150_000 ?
                                        sumCost > 500_000 ? 25 :
                                                20 :
                                        10 :
                                5 :
                        0;
    }


}
