package com.hibernate.hbm.zoo;

import java.util.HashSet;
import java.util.Set;

public class Cage {
    private int id;
    private CageType cageType;
    private Set<Overseer> overseers;
    private Set<Animal> animals;

    public Cage() {
        this.cageType = null;
        this.overseers = new HashSet<Overseer>();
        this.animals = new HashSet<Animal>();
    }

    @Override
    public String toString() {
        return "Cage{" +
                "id=" + id +
                ", cageType=" + cageType +
                '}';
    }

    public int getId() {
        return id;
    }

    public CageType getCageType() {
        return cageType;
    }

    public Set<Overseer> getOverseer() {
        return overseers;
    }

    public Set<Animal> getAnimal() {
        return animals;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCageType(CageType cageType) {
        this.cageType = cageType;
    }

    public void setOverseer(Set<Overseer> overseers) {
        this.overseers = overseers;
    }

    public void setAnimal(Set<Animal> animals) {
        this.animals = animals;
    }
}
