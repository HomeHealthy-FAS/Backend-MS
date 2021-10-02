package pe.edu.upc.socialservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.socialservice.entity.Collaborator;
import pe.edu.upc.socialservice.service.CollaboratorService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/collaborators")
public class CollaboratorController {

    @Autowired
    private CollaboratorService collaboratorService;

    // -------------------Retrieve All Collaborators--------------------------------------------

    @GetMapping
    public ResponseEntity<List<Collaborator>> listAllCollaborators() {
        List<Collaborator> collaborators =  new ArrayList<>();
        collaborators = collaboratorService.findAllCollaborators();
        if ( null == collaborators ) {
            log.error("Collaborators not found.");
            return  ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(collaborators);
    }

    // -------------------Retrieve Single Collaborator------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Collaborator> getCollaborator(@PathVariable("id") Long id) {
        log.info("Fetching Collaborator with id {}", id);
        Collaborator collaborator = collaboratorService.getCollaborator(id);
        if (  null == collaborator) {
            log.error("Collaborator with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(collaborator);
    }

    // -------------------Create a Collaborator-------------------------------------------

    @PostMapping
    public ResponseEntity<Collaborator> createCollaborator(@Valid @RequestBody Collaborator collaborator, BindingResult result) {
        log.info("Creating Collaborator : {}", collaborator);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Collaborator collaboratorDb = collaboratorService.createCollaborator(collaborator);

        return  ResponseEntity.status( HttpStatus.CREATED).body(collaboratorDb);
    }

    // ------------------- Update a Collaborator ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCollaborator(@PathVariable("id") Long id, @RequestBody Collaborator collaborator) {
        log.info("Updating Collaborator with id {}", id);

        Collaborator currentCollaborator = collaboratorService.getCollaborator(id);

        if ( null == currentCollaborator ) {
            log.error("Unable to update. Collaborator with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        collaborator.setId(id);
        currentCollaborator = collaboratorService.updateCollaborator(collaborator);
        return  ResponseEntity.ok(currentCollaborator);
    }

    // ------------------- Delete a Collaborator-----------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Collaborator> deleteCollaborator(@PathVariable("id") Long id) {
        log.info("Fetching & Deleting Collaborator with id {}", id);

        Collaborator collaborator = collaboratorService.getCollaborator(id);
        if ( null == collaborator ) {
            log.error("Unable to delete. Collaborator with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        collaborator = collaboratorService.deleteCollaborator(collaborator);
        return  ResponseEntity.ok(collaborator);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
