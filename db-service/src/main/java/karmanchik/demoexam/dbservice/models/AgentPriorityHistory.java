package karmanchik.demoexam.dbservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "AGENTPRIORITYHISTORY")
@EqualsAndHashCode(callSuper = true)
public class AgentPriorityHistory extends AbstractModel {
    private LocalDate changeDate;
    private Integer priorityValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "AGENTID", referencedColumnName = "ID", nullable = false)
    private Agent agent;

    @Override
    public String toString() {
        return "AgentPriorityHistory{" +
                "id=" + id +
                ", changeDate=" + changeDate +
                ", priorityValue=" + priorityValue +
                '}';
    }
}
