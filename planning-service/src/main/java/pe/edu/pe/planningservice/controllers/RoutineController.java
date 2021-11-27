package pe.edu.pe.planningservice.controllers;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import pe.edu.pe.planningservice.entities.Routine;
import pe.edu.pe.planningservice.services.DietService;
import pe.edu.pe.planningservice.services.RoutineService;
import sun.security.timestamp.HttpTimestamper;

import java.security.interfaces.RSAKey;
import java.util.List;
import java.util.Optional;
import java.util.zip.DeflaterInputStream;

@RestController
@RequestMapping("/routines")
public class RoutineController {
    @Autowired
    private RoutineService routineService;

    @GetMapping(path="/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Routine> getRoutines(){
        try{
            return routineService.findAll();
        }catch (Exception e){
            return null;
        }

    }

    @GetMapping(path="/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Routine> fetchById(@PathVariable("id") Long id) {
        try {

            Optional<Routine> optionalRoutine = routineService.findById(id);
            if (optionalRoutine.isPresent()) {
                return new ResponseEntity<Routine>(optionalRoutine.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
