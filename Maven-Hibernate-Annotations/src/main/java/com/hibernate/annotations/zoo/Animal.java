package com.hibernate.annotations.zoo;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private int id;

    @Column(name = "animal_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "animal_cage")
    private Cage cage;

    public Animal() {
        this.name = null;
        this.cage = null;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cage getCage() { return cage; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCage(Cage cage) { this.cage = cage; }
}
