package pe.edu.upc.socialservice.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Collaborator;

import java.util.List;

@Service
public interface CollaboratorService {
    public List<Collaborator> findAllCollaborators();

    public Collaborator getCollaborator(Long id);

    public Collaborator createCollaborator(Collaborator collaborator);
    public Collaborator updateCollaborator(Collaborator collaborator);
    public Collaborator deleteCollaborator(Collaborator collaborator);
}
