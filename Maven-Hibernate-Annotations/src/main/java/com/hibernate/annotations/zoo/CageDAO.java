package com.hibernate.annotations.zoo;

import org.hibernate.Session;

import java.util.ArrayList;

public class CageDAO {

    public void addCage(Cage cage)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cage);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with addCage \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateCage(Cage cage)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(cage);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with updateCage \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteCage(Cage cage)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cage);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with deleteCage \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ArrayList<Cage> getAllCages()
    {
        Session session = null;
        ArrayList cages = new ArrayList<Cage>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            cages = (ArrayList<Cage>)session.createCriteria(Cage.class).list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getAllCage \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  cages;
    }

    public Cage getCageById(int cageId)
    {
        Session session = null;
        Cage cage = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            cage = (Cage)session.get(Cage.class,cageId);
        }
        catch (Exception e)
        {
            System.out.println("Error with getCageById \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cage;
    }

    public Cage getCageByAnimal(Animal animal)
    {
        Session session = null;
        Cage cage = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "select a.cage from Animal a where a.id = :animalID";
            cage = (Cage)session.createQuery(hql)
                    .setParameter("animalID",animal.getId())
                    .getSingleResult();
        }
        catch (Exception e)
        {
            System.out.println("Error with getCageByAnimal \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cage;
    }

    public ArrayList<Cage> getCagesByOverseer(Overseer overseer)
    {
        Session session = null;
        ArrayList cages = new ArrayList<Cage>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "select o.cages from Overseer o where o.id = :overseerID";
            cages = (ArrayList<Cage>)session.createQuery(hql)
                    .setParameter("overseerID",overseer.getId())
                    .list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getCagesByOverseer \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  cages;
    }
}
