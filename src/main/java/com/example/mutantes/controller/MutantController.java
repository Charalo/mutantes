package com.example.mutantes.controller;

import com.example.mutantes.entity.StatsEntity;
import com.example.mutantes.exception.MutantException;
import com.example.mutantes.pojo.Dna;
import com.example.mutantes.pojo.Stats;
import com.example.mutantes.service.MutantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class MutantController {
    private static final Logger logger = LoggerFactory.getLogger(MutantController.class);

    public MutantController(MutantService mutantService){
        this.mutantService=mutantService;
    }

    private final MutantService mutantService;

    @PostMapping({"mutant/"})
    public ResponseEntity mutant(@RequestBody Dna dna){
        try {
            if(mutantService.isMutant(dna.getDna())){
                return new ResponseEntity(HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.FORBIDDEN);
            }
        } catch (MutantException e) {
            logger.error(e.getMessage());
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping({"stats"})
    public ResponseEntity<Stats> stats(){
        return ResponseEntity.ok(mutantService.stats());
    }
}
