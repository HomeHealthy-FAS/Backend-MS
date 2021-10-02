package pe.edu.pe.planningservice.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.pe.planningservice.entities.Plan;
import pe.edu.pe.planningservice.entities.Routine;

@Repository
public interface RoutineRepository extends PlanRepository<Routine> {
}
