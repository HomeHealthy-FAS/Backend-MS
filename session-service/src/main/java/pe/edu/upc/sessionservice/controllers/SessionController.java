package pe.edu.upc.sessionservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.sessionservice.entities.Session;
import pe.edu.upc.sessionservice.services.SessionService;

import java.util.Optional;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping(path="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Session> fetchById(@PathVariable("id") Long id){
        try{
            Optional<Session> optionalSession = sessionService.findById(id);
            if (optionalSession.isPresent()) return new ResponseEntity<Session>(optionalSession.get(), HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

