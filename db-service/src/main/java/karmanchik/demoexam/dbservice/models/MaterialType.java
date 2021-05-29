package karmanchik.demoexam.dbservice.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "MATERIALTYPE")
@EqualsAndHashCode(callSuper = true)
public class MaterialType extends AbstractModel {
    private String title;
    private Double defectedPercent;

    @OneToMany(mappedBy = "type")
    private Collection<Material> materials;
}
