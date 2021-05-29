package karmanchik.demoexam.dbservice.models;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductMaterialPK implements Serializable {
    private Integer productId;
    private Integer materialId;
}
