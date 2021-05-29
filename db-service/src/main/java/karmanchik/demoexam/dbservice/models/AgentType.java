package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "AGENTTYPE")
@EqualsAndHashCode(callSuper = true)
public class AgentType extends AbstractModel {
    private String title;
    private String image;

    @JsonManagedReference
    @OneToMany(mappedBy = "type")
    private List<Agent> agents;

    @Override
    public String toString() {
        return "AgentType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
