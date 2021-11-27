package pe.edu.upc.sessionservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.sessionservice.entities.SessionDetail;
import pe.edu.upc.sessionservice.services.SessionDetailService;

import java.util.Optional;

@RestController
@RequestMapping("/session_detail")
public class SessionDetailController {
    @Autowired
    private SessionDetailService sessionDetailService;

    @GetMapping(path="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessionDetail> fetchById(@PathVariable("id") Long id){
        try{
            Optional<SessionDetail> optionalSessionDetail = sessionDetailService.findById(id);
            if (optionalSessionDetail.isPresent()) return new ResponseEntity<SessionDetail>(optionalSessionDetail.get(), HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

