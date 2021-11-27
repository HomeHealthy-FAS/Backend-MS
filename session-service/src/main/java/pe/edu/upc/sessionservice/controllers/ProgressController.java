package pe.edu.upc.sessionservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.sessionservice.entities.Progress;
import pe.edu.upc.sessionservice.services.ProgressService;

import java.util.Optional;

@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @GetMapping(path="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Progress> fetchById(@PathVariable("id") Long id){
        try{
            Optional<Progress> optionalProgress = progressService.findById(id);
            if (optionalProgress.isPresent()) return new ResponseEntity<Progress>(optionalProgress.get(), HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
