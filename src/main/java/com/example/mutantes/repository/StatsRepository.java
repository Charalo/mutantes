package com.example.mutantes.repository;

import com.example.mutantes.entity.StatsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends CrudRepository<StatsEntity,Long> {
    long countByIsMutantIsFalse();
    long countByIsMutantIsTrue();
}
