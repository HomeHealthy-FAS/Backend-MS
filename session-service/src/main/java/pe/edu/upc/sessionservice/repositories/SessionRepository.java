package pe.edu.upc.sessionservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.sessionservice.entities.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
}
