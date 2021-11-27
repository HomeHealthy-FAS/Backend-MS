package pe.edu.upc.sessionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.sessionservice.entities.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
