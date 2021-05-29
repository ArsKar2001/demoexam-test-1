package karmanchik.demoexam.dbservice.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Embeddable
public class MaterialSupplierPK implements Serializable {
    private Integer materialId;
    private Integer supplierId;
}
