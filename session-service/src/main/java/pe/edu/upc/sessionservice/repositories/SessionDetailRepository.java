package pe.edu.upc.sessionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.sessionservice.entities.SessionDetail;

@Repository
public interface SessionDetailRepository extends JpaRepository<SessionDetail,Long> {
}
