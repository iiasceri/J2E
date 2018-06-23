package com.hibernate.annotations.zoo;

import org.hibernate.Session;

import java.util.ArrayList;

public class OverseerDAO {
    public void addOverseer(Overseer overseer)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(overseer);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with addOverseer \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateOverseer(Overseer overseer)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(overseer);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with updateOverseer \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteOverseer(Overseer overseer)
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(overseer);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Error with deleteOverseer \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ArrayList<Overseer> getAllOverseers()
    {
        Session session = null;
        ArrayList overseers = new ArrayList<Overseer>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            overseers = (ArrayList<Overseer>)session.createCriteria(Overseer.class).list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getAllProfessors \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return  overseers;
    }

    public Overseer getOverseerById(int overseerId)
    {
        Session session = null;
        Overseer overseer = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            overseer = (Overseer) session.get(Overseer.class,overseerId);
        }
        catch (Exception e)
        {
            System.out.println("Error with getOverseerById \n"+e);
        }
        finally
        {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return overseer;
    }

    public ArrayList<Overseer> getOverseersByCage(Cage cage)
    {
        Session session = null;
        ArrayList<Overseer> overseers = new ArrayList<Overseer>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "select c.overseers from Cage c where c.id = :cageID";
            overseers = ( ArrayList<Overseer>)session.createQuery(hql)
                    .setParameter("cageID",cage.getId())
                    .list();
        }
        catch (Exception e)
        {
            System.out.println("Error with getOverseersByCage \n"+e);
        }
        finally
        {

        }
        return overseers;
    }
}
