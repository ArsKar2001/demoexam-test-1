package karmanchik.demoexam.dbservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractModel {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    protected Integer id;
}
