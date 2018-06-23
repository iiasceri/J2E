package com.hibernate.annotations.zoo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cage")
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cage_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "cage_type")
    private CageType cageType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "check",
                joinColumns = @JoinColumn(name = "cage"),
                inverseJoinColumns = @JoinColumn(name = "overseer"))
    private Set<Overseer> overseers;

    @OneToMany(mappedBy = "particular_cage", cascade = CascadeType.ALL)///////////////????
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
