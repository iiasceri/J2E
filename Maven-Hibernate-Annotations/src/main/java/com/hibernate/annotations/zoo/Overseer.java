package com.hibernate.annotations.zoo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "overseer")
public class Overseer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "overseer_id")
    private int id;

    @Column(name = "overseer_name")
    private String name;

    @Column(name = "overseer_experience")
    private int experience;

    @ManyToMany(mappedBy = "overseer") //////////////////////////////////////???
    private Set<Cage> cages;

    public Overseer() {
        this.name = null;
        this.experience = 0;
        this.cages = new HashSet<Cage>();
    }

    @Override
    public String toString() {
        return "Overseer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public Set<Cage> getCage() {
        return cages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setCage(Set<Cage> cages) {
        this.cages = cages;
    }
}
