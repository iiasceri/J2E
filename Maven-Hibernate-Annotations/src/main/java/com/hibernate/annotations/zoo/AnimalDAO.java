package com.hibernate.annotations.zoo;

import org.hibernate.Session;

import java.util.ArrayList;

public class AnimalDAO {


        public void addAnimal(Animal animal)
        {
            Session session = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(animal);
                session.getTransaction().commit();
            }
            catch (Exception e)
            {
                System.out.println("Error with addAnimal");
            }
            finally
            {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        public void updateAnimal(Animal animal)
        {
            Session session = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.merge(animal);
                session.getTransaction().commit();
            }
            catch (Exception e)
            {
                System.out.println("Error with updateAnimal \n"+e);
            }
            finally
            {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        public void deleteAnimal(Animal animal)
        {
            Session session = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(animal);
                session.getTransaction().commit();
            }
            catch (Exception e)
            {
                System.out.println("Error with deleteAnimal \n"+e);
            }
            finally
            {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        public ArrayList<Animal> getAllAnimals()
        {
            Session session = null;
            ArrayList animals = new ArrayList<Animal>();
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                animals = (ArrayList<Animal>)session.createCriteria(Animal.class).list();
            }
            catch (Exception e)
            {
                System.out.println("Error with getAllAnimals \n"+e);
            }
            finally
            {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return  animals;
        }

        public Animal getAnimalById(int animalId)
        {
            Session session = null;
            Animal animal = null;
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                animal = (Animal)session.get(Animal.class,animalId);
            }
            catch (Exception e)
            {
                System.out.println("Error with getAnimalById \n"+e);
            }
            finally
            {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return animal;
        }

        public ArrayList<Animal> getAnimalsByCage(Cage cage)
        {
            Session session = null;
            ArrayList animals = new ArrayList<Animal>();
            try
            {
                session = HibernateUtil.getSessionFactory().openSession();
                String hql ="select c.animals from Cage c where c.id = :cageID";
                animals = (ArrayList<Animal>)session.createQuery(hql)
                        .setParameter("cageID",cage.getId())
                        .list();
            }
            catch (Exception e)
            {
                System.out.println("Error with getAnimalsByCage \n"+e);
            }
            finally
            {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return animals;
        }
    }


