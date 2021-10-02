package pe.edu.upc.socialservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.socialservice.entity.Collaborator;
import pe.edu.upc.socialservice.repository.CollaboratorRepository;
import pe.edu.upc.socialservice.service.CollaboratorService;

import java.util.List;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public List<Collaborator> findAllCollaborators() {
        return collaboratorRepository.findAll();
    }

    @Override
    public Collaborator getCollaborator(Long id) {
        return collaboratorRepository.findById(id).orElse(null);
    }

    @Override
    public Collaborator createCollaborator(Collaborator collaborator) {
        Collaborator collaboratorDb = collaboratorRepository.findById(collaborator.getId()).orElse(null);
        if (collaboratorDb != null){
            return collaboratorDb;
        }
        collaborator.setStatus("CREATED");
        collaboratorDb = collaboratorRepository.save(collaborator);
        return collaboratorDb;
    }

    @Override
    public Collaborator updateCollaborator(Collaborator collaborator) {
        Collaborator collaboratorDb = collaboratorRepository.findById(collaborator.getId()).orElse(null);
        if (collaboratorDb == null){
            return  null;
        }
        collaboratorDb.setEmail(collaborator.getEmail());
        collaboratorDb.setUsername(collaborator.getUsername());
        collaboratorDb.setPassword(collaborator.getPassword());
        collaboratorDb.setName(collaborator.getName());
        collaboratorDb.setLastname(collaborator.getLastname());
        collaboratorDb.setAddress(collaborator.getAddress());
        collaboratorDb.setBirthday(collaborator.getBirthday());
        collaboratorDb.setPhone(collaborator.getPhone());
        collaboratorDb.setStatus(collaborator.getStatus());

        return  collaboratorRepository.save(collaboratorDb);
    }

    @Override
    public Collaborator deleteCollaborator(Collaborator collaborator) {
        Collaborator collaboratorDb = collaboratorRepository.findById(collaborator.getId()).orElse(null);
        if (collaboratorDb ==null){
            return  null;
        }
        collaborator.setStatus("DELETED");
        return collaboratorRepository.save(collaborator);
    }
}
