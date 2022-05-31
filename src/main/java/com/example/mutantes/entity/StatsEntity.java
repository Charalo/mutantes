package com.example.mutantes.entity;

import javax.persistence.*;

@Entity
@Table(name = "stats")
public class StatsEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "isMutant")
    private boolean isMutant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsMutant() {
        return isMutant;
    }

    public void setIsMutant(boolean countMutant) {
        this.isMutant = countMutant;
    }

    public StatsEntity(boolean isMutant) {
        this.isMutant = isMutant;
    }
}
