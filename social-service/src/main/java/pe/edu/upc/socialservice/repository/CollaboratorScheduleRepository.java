package pe.edu.upc.socialservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.socialservice.entity.CollaboratorSchedule;
import java.util.Optional;

@Repository
public interface CollaboratorScheduleRepository extends JpaRepository<CollaboratorSchedule, Long> {
    Page<CollaboratorSchedule> findByCollaboratorId(Long collaboratorId, Pageable pageable);
    Optional<CollaboratorSchedule> findByIdAndCollaboratorId(Long id, Long collaboratorId);
}
