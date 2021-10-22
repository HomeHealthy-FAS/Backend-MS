package pe.edu.upc.socialservice.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.CollaboratorSchedule;

import java.util.List;

@Service
public interface CollaboratorScheduleService {
    List<CollaboratorSchedule> getAllCollaboratorSchedulesByCollaboratorId(Long collaboratorId, Pageable pageable);

    CollaboratorSchedule getCollaboratorScheduleByIdAndCollaboratorId(Long collaboratorId, Long id);

    CollaboratorSchedule createCollaboratorSchedule( Long collaboratorId, CollaboratorSchedule collaboratorSchedule);

    // CollaboratorSchedule updateCollaboratorSchedule(Long collaboratorId, Long id, Session sessionDetails);

    CollaboratorSchedule deleteCollaboratorSchedule(Long collaboratorId, Long id);
}
