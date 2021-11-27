package pe.edu.upc.product.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.product.entities.Diet;
import pe.edu.upc.product.services.DietService;
//import sun.security.timestamp.HttpTimestamper;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diets")
public class DietController {
    @Autowired
    private DietService dietService;

    @GetMapping(path="/",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Diet> getDiets(){
        try{
            return dietService.findAll();
        }catch (Exception e){
            return null;
        }

    }

    @GetMapping(path="/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Diet> fetchById(@PathVariable("id") Long id){
           try{

               Optional<Diet> optionalDiet = dietService.findById(id);
               if(optionalDiet.isPresent()){
                   return new ResponseEntity<Diet>(optionalDiet.get(), HttpStatus.OK);
               }else{
                   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
               }
           }catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }
}
