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
import pe.edu.upc.socialservice.entity.Reason;
import pe.edu.upc.socialservice.service.ReasonService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/reasons")
public class ReasonController {

    @Autowired
    private ReasonService reasonService;

    // -------------------Retrieve All Reasons--------------------------------------------

    @GetMapping
    public ResponseEntity<List<Reason>> listAllReasons() {
        List<Reason> reasons =  new ArrayList<>();
        reasons = reasonService.getAllReasons();
        if ( null == reasons ) {
            log.error("Reasons not found.");
            return  ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(reasons);
    }

    // -------------------Retrieve Single Reason------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reason> getReason(@PathVariable("id") long id) {
        log.info("Fetching Reason with id {}", id);
        Reason reason = reasonService.getReasonById(id);
        if (  null == reason) {
            log.error("Reason with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(reason);
    }

    // -------------------Create a Reason-------------------------------------------

    @PostMapping
    public ResponseEntity<Reason> createReason(@Valid @RequestBody Reason reason, BindingResult result) {
        log.info("Creating Customer : {}", reason);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Reason reasonDb = reasonService.createReason(reason);

        return  ResponseEntity.status( HttpStatus.CREATED).body(reasonDb);
    }

    // ------------------- Update Reason ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateReason(@PathVariable("id") Long id, @RequestBody Reason reason) {
        log.info("Updating Reason with id {}", id);

        Reason currentReason = reasonService.getReasonById(id);

        if ( null == currentReason ) {
            log.error("Unable to update. Reason with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        reason.setId(id);
        currentReason = reasonService.updateReason(id, reason);
        return  ResponseEntity.ok(currentReason);
    }

    // ------------------- Delete a Customer-----------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Reason> deleteReason(@PathVariable("id") Long id) {
        log.info("Fetching & Deleting Reason with id {}", id);

        Reason reason = reasonService.getReasonById(id);
        if ( null == reason ) {
            log.error("Unable to delete. Reason with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        reason = reasonService.deleteReason(id);
        return  ResponseEntity.ok(reason);
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
