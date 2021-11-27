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
import pe.edu.upc.socialservice.entity.Score;
import pe.edu.upc.socialservice.service.ScoreService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    // -------------------Retrieve All Scores--------------------------------------------

    @GetMapping
    public ResponseEntity<List<Score>> listAllScores() {
        List<Score> scores =  new ArrayList<>();
        scores = scoreService.getAllScore();
        if ( null == scores ) {
            log.error("Scores not found.");
            return  ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(scores);
    }

    // -------------------Retrieve Single Score------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Score> getScore(@PathVariable("id") long id) {
        log.info("Fetching Score with id {}", id);
        Score score = scoreService.getScoreById(id);
        if (  null == score) {
            log.error("Score with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(score);
    }

    // -------------------Create a Score-------------------------------------------

    @PostMapping
    public ResponseEntity<Score> createScore(@Valid @RequestBody Score score, BindingResult result) {
        log.info("Creating Score : {}", score);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        Score scoreDb = scoreService.createScore (score);

        return  ResponseEntity.status( HttpStatus.CREATED).body(scoreDb);
    }

    // ------------------- Update a Score ------------------------------------------------

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateScore(@PathVariable("id") Long id, @RequestBody Score score) {
        log.info("Updating Score with id {}", id);

        Score currentScore = scoreService.getScoreById(id);

        if ( null == currentScore ) {
            log.error("Unable to update. Score with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        score.setId(id);
        currentScore = scoreService.updateScore(id, score);
        return  ResponseEntity.ok(currentScore);
    }

    // ------------------- Delete a Score-----------------------------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Score> deleteScore(@PathVariable("id") Long id) {
        log.info("Fetching & Deleting Score with id {}", id);

        Score score = scoreService.getScoreById(id);
        if ( null == score ) {
            log.error("Unable to delete. Score with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        score = scoreService.deleteScore(id);
        return  ResponseEntity.ok(score);
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
