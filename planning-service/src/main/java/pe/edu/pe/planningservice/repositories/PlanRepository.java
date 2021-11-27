package pe.edu.pe.planningservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.planningservice.entities.Plan;

@Repository
public interface PlanRepository<T extends Plan> extends JpaRepository<T,Long> {
}
