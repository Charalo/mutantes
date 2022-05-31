package com.example.mutantes.service;

import com.example.mutantes.pojo.Stats;
import com.example.mutantes.exception.MutantException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MutantServiceTest {
    @Autowired
    MutantService mutantService;

    @Test
    void isMutantDiagonal() throws MutantException {
        String[] diagonal = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(mutantService.isMutant(diagonal));
    }
    @Test
    void isMutantReverseDiagonal() throws MutantException {
        String[] reverseDiagonal = new String[]{"123A56","ZZAZZZ","XAXXXX","AYYYYY","CCCCTA","TCACTG"};
        assertTrue(mutantService.isMutant(reverseDiagonal));
    }
    @Test
    void isMutantHorizontal() throws MutantException {
        String[] horizontal = new String[]{"AAAAGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(mutantService.isMutant(horizontal));
    }
    @Test
    void isMutantVertical() throws MutantException {
        String[] vertical = new String[]{"CTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(mutantService.isMutant(vertical));
    }

    @Test
    void isNotMutant() throws MutantException {
        String[] notMutant = new String[]{"XX1XXX", "YY1YYY", "BB2BBB", "AA3AAA", "WW4WWW", "QQ5QQQ"};
        assertFalse(mutantService.isMutant(notMutant));
    }

    @Test
    void emptyArray() {
        String[] notMutant = new String[]{};
        MutantException mutantException = assertThrows(MutantException.class, () -> {
            mutantService.isMutant(notMutant);
        });
        assertTrue(mutantException.getMessage().contains("El arreglo esta vacio"));
    }

    @Test
    void notMatriz() {
        String[] notMatriz = new String[]{"XXXAXX", "XXXAXX", "XXXAXX"};
        MutantException mutantException = assertThrows(MutantException.class, () -> {
            mutantService.isMutant(notMatriz);
        });
        assertTrue(mutantException.getMessage().contains("El arreglo no es NxN"));
    }

    @Test
    void nullMatriz() {
        String[] nullMatriz = null;
        MutantException mutantException = assertThrows(MutantException.class, () -> {
            mutantService.isMutant(nullMatriz);
        });
        assertTrue(mutantException.getMessage().contains("El arreglo no puede ser null"));
    }

    @Test
    void stats() throws MutantException {
        String[] diagonal = new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        mutantService.isMutant(diagonal);
        mutantService.isMutant(diagonal);
        mutantService.isMutant(diagonal);
        Stats statsEntity =mutantService.stats();
        assertEquals(1,statsEntity.getCountHuman());
        assertEquals(4,statsEntity.getCountMuntant());
        assertEquals(0.8,statsEntity.getRatio());
    }
}