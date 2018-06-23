package com.hibernate.annotations.zoo;

public class Factory {
    private static CageDAO cageDAO = null;
    private static OverseerDAO overseerDAO = null;
    private static AnimalDAO animalDAO = null;
    private static Factory instance = null;


    public static Factory getInstance()
    {
        if(instance == null)
        {
            instance = new Factory();
        }
        return instance;
    }

    public CageDAO getCageDAO()
    {
        if(cageDAO == null)
        {
            cageDAO = new CageDAO();
        }
        return cageDAO;
    }

    public OverseerDAO getOverseerDAO()
    {
        if(overseerDAO == null)
        {
            overseerDAO = new OverseerDAO();
        }
        return overseerDAO;
    }

    public AnimalDAO getAnimalDAO()
    {
        if(animalDAO == null)
        {
            animalDAO = new AnimalDAO();
        }
        return animalDAO;
    }
}
