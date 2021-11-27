package pe.edu.upc.product.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.upc.product.entities.Diet;

@Repository
public interface DietRepository extends PlanRepository<Diet> {
}
