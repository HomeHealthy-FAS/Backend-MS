package pe.edu.upc.socialservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.socialservice.entity.Reason;
import java.util.Optional;

@Repository
public interface ReasonRepository extends JpaRepository<Reason, Long> {
    Optional<Reason> findReasonByDescription(String description);
}
