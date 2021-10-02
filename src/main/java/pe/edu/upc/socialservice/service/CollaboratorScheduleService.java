package pe.edu.upc.socialservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.CollaboratorSchedule;

@Service
public interface CollaboratorScheduleService {
    Page<CollaboratorSchedule> getAllCollaboratorSchedulesByCollaboratorId(Long collaboratorId, Pageable pageable);

    CollaboratorSchedule getCollaboratorScheduleByIdAndCollaboratorId(Long collaboratorId, Long id);

    CollaboratorSchedule createCollaboratorSchedule( Long collaboratorId, CollaboratorSchedule collaboratorSchedule);

    // CollaboratorSchedule updateCollaboratorSchedule(Long collaboratorId, Long id, Session sessionDetails);

    ResponseEntity<?> deleteCollaboratorSchedule(Long collaboratorId, Long id);
}
