package pe.edu.upc.sessionservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.sessionservice.entities.AvailableSchedule;
import pe.edu.upc.sessionservice.services.AvailableScheduleService;

import java.util.Optional;

@RestController
@RequestMapping("/available_schedule")
public class AvailableScheduleController {
    @Autowired
    private AvailableScheduleService availableScheduleService;

    @GetMapping(path="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AvailableSchedule> fetchById(@PathVariable("id") Long id){
        try{
            Optional<AvailableSchedule> optionalAvailableSchedule = availableScheduleService.findById(id);
            if (optionalAvailableSchedule.isPresent()) return new ResponseEntity<AvailableSchedule>(optionalAvailableSchedule.get(), HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
