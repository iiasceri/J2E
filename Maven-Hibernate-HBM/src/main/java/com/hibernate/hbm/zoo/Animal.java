package com.hibernate.hbm.zoo;

public class Animal {
    private int id;
    private String name;
    private Cage cage;

    public Animal() {
        name = null;
        cage = null;
    }

    @Override
    public String toString() {
        return "Student{" +
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