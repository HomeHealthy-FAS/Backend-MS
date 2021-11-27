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
import pe.edu.upc.socialservice.entity.Complaint;
import pe.edu.upc.socialservice.service.ComplaintService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // -------------------Retrieve All Complaints--------------------------------------------

    @GetMapping
    public ResponseEntity<List<Complaint>> listAllComplaints() {
        List<Complaint> complaints =  new ArrayList<>();
        complaints = complaintService.getAllComplaints();
        if ( null == complaints ) {
            log.error("Complaints not found.");
            return  ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(complaints);
    }

    // -------------------Retrieve Single Complaint------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Complaint> getComplaint(@PathVariable("id") long id) {
        log.info("Fetching Complaint with id {}", id);
        Complaint complaint = complaintService.getComplaintById(id);
        if (  null == complaint) {
            log.error("Complaint with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(complaint);
    }

    // -------------------Create a Complaint-------------------------------------------

    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@Valid @RequestBody Complaint complaint, Long customerId, Long reasonId, BindingResult result) {
        log.info("Complaint Score : {}", complaint);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Complaint complaintDb = complaintService.createComplaint (customerId, reasonId, complaint);

        return  ResponseEntity.status( HttpStatus.CREATED).body(complaintDb);
    }

    // ------------------- Update a Complaint ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateComplaint(@PathVariable("id") Long id, Long customerId, Long reasonId, @RequestBody Complaint complaint) {
        log.info("Updating Complaint with id {}", id);

        Complaint currentComplaint = complaintService.getComplaintById(id);

        if ( null == currentComplaint ) {
            log.error("Unable to update. Complaint with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        complaint.setId(id);
        currentComplaint = complaintService.updateComplaint(customerId, reasonId, id, complaint);
        return  ResponseEntity.ok(currentComplaint);
    }

    // ------------------- Delete a Complaint-----------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Complaint> deleteComplaint(@PathVariable("id") Long id) {
        log.info("Fetching & Deleting Complaint with id {}", id);

        Complaint complaint = complaintService.getComplaintById(id);
        if ( null == complaint ) {
            log.error("Unable to delete. Complaint with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        complaint = complaintService.deleteComplaint(id);
        return  ResponseEntity.ok(complaint);
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
