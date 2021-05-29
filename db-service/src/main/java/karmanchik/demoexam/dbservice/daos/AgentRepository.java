package karmanchik.demoexam.dbservice.daos;

import karmanchik.demoexam.dbservice.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
