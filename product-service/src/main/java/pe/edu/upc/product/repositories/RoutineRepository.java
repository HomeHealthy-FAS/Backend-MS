package pe.edu.upc.product.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.upc.product.entities.Routine;

@Repository
public interface RoutineRepository extends PlanRepository<Routine> {
}
