package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MATERIALCOUNTHISTORY")
@EqualsAndHashCode(callSuper = true)
public class MaterialCountHistory extends AbstractModel {
    private LocalDate changeDate;
    private Integer countValue;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "MATERIALID", referencedColumnName = "ID", nullable = false)
    private Material material;
}
