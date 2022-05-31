package com.example.mutantes.service;

import com.example.mutantes.pojo.Stats;
import com.example.mutantes.entity.StatsEntity;
import com.example.mutantes.exception.MutantException;
import com.example.mutantes.repository.StatsRepository;
import org.springframework.stereotype.Service;

@Service
public class MutantService {
    private final StatsRepository statsRepository;

    public MutantService(StatsRepository statsRepository){
        this.statsRepository=statsRepository;
    }

    public boolean isMutant(String[] dna) throws MutantException {
        boolean isMutant;
        if (dna == null  ) {
            throw new MutantException("El arreglo no puede ser null");
        }
        char mat[][] = convertToBiArray(dna);
        isMutant= isMutant(mat);
        statsRepository.save(new StatsEntity(isMutant));
        return isMutant;
    }

    private char[][] convertToBiArray(String[] dna) throws MutantException {
        if (dna.length == 0  ) {
            throw new MutantException("El arreglo esta vacio");
        }
        char mat[][] = new char[dna.length][dna.length];
        for (int i = 0; i < dna.length; i++) {
            if (dna[i].length() != dna.length) {
                throw new MutantException("El arreglo no es NxN");
            }
            for (int j = 0; j < dna[i].length(); j++) {
                mat[i][j] = dna[i].charAt(j);
            }
        }
        return mat;
    }


    public Stats stats() {
        return new Stats(statsRepository.countByIsMutantIsTrue(),statsRepository.countByIsMutantIsFalse());
    }

    private boolean isMutant(char[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++) {
                char c = matrix[i][j];
                if(checkHorizontal(matrix, i, j, c)){
                    return true;
                }
                if(checkVertical(matrix, i, j, c)){
                    return true;
                }
                if(checkDiagonalF(matrix, i, j, c)){
                    return true;
                }
                if(checkDiagonalB(matrix, i, j, c)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal(char[][] matrix, int i, int j, char c){
        int count = 0;
        for(int x = j; x < matrix.length; x++){
            if(matrix[i][x] == c){
                count++;
                if(count == 4){
                    return true;
                }
            } else  {
                return false;
            }
        }
        return false;
    }
    private boolean checkVertical(char[][] matrix, int i, int j, char c){
        int count = 0;
        for(int y = i; y < matrix.length; y++){
            if(matrix[y][j] == c){
                count++;
                if(count == 4){
                    return true;
                }
            } else  {
                return false;
            }
        }
        return false;
    }
    private boolean checkDiagonalF(char[][] matrix, int i, int j, char c){
        int count = 0;
        for(int p = i; p < matrix.length; p++){
            if(matrix[p][p] == c){
                count++;
                if(count == 4){
                    return true;
                }
            } else  {
                return false;
            }
        }
        return false;
    }
    private boolean checkDiagonalB(char[][] matrix, int i, int j, char c){
        int count = 0;
        for(int p = i; p < matrix.length; p++){
            if(matrix[p][matrix.length-1-p] == c){
                count++;
                if(count == 4){
                    return true;
                }
            } else  {
                return false;
            }
        }
        return false;
    }
}
