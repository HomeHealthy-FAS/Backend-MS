package pe.edu.upc.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.product.entities.Plan;

@Repository
public interface PlanRepository<T extends Plan> extends JpaRepository<T,Long> {
}
