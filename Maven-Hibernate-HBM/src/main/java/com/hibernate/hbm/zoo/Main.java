package com.hibernate.hbm.zoo;

public class Main {

    public static void printAllCages()
    {
        for(Cage c:Factory.getInstance().getCageDAO().getAllCages())
        {
            System.out.println(c);
        }
    }

    public static void printAllOverseers()
    {
        for (Overseer o:Factory.getInstance().getOverseerDAO().getAllOverseers())
        {
            System.out.println(o);
        }
    }

    public static void printAllAnimals()
    {
        for (Animal a:Factory.getInstance().getAnimalDAO().getAllAnimals())
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        CageDAO CageDAO = Factory.getInstance().getCageDAO();
        OverseerDAO overseerDAO = Factory.getInstance().getOverseerDAO();
        AnimalDAO animalDAO = Factory.getInstance().getAnimalDAO();

        //CRUD - Cage

        System.out.println("Adding Cage...");
        Cage cageAdd = new Cage();
        cageAdd.setCageType(CageType.Small);
        CageDAO.addCage(cageAdd);

        Main.printAllCages();

        System.out.println("Updating Cage...");
        Cage cageUpdate = CageDAO.getCageById(3);
        CageDAO.updateCage(cageUpdate);
        Main.printAllCages();

        System.out.println("Deleting cage...");
        CageDAO.deleteCage(CageDAO.getCageById(3));
        Main.printAllCages();

        System.out.println("Showing Cage by overseer...");
        for(Cage c : CageDAO.getCagesByOverseer(overseerDAO.getOverseerById(2)))
        {
            System.out.println(c);
        }

        Main.printAllCages();


        //CRUD - Overseer


        Overseer overseerAdd = new Overseer();
        overseerAdd.setName("Jack Sparrow");
        overseerAdd.setExperience(19);
        overseerDAO.addOverseer(overseerAdd);
        Main.printAllOverseers();

        Overseer overseerUpdate = overseerDAO.getOverseerById(1);
        overseerUpdate.setName("Tarzan");
        overseerDAO.updateOverseer(overseerUpdate);
        Main.printAllOverseers();

        overseerDAO.deleteOverseer(overseerDAO.getOverseerById(4));
        Main.printAllOverseers();

        for(Overseer o : overseerDAO.getOverseersByCage(CageDAO.getCageById(1)))
        {
            System.out.println(o);
        }

        Main.printAllOverseers();


        ///CRUD - Animal

        Animal animalAdd = new Animal();
        animalAdd.setName("Tom");
        animalAdd.setCage(CageDAO.getCageById(2));
        animalDAO.addAnimal(animalAdd);
        Main.printAllAnimals();

        Animal animalUpdate = animalDAO.getAnimalById(4);
        animalUpdate.setName("Bobby");
        animalDAO.updateAnimal(animalUpdate);
        Main.printAllAnimals();

        animalDAO.deleteAnimal(animalDAO.getAnimalById(3));
        Main.printAllAnimals();

        for(Animal a: animalDAO.getAnimalsByCage(CageDAO.getCageById(2)))
        {
            System.out.println(a);
        }

        Main.printAllAnimals();
    }
}
