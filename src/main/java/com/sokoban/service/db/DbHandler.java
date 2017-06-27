package com.sokoban.service.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DbHandler {

    private SessionFactory factory;

    public DbHandler() {
        Configuration configuration = new Configuration();
        configuration.configure();
        factory = configuration.buildSessionFactory();
    }

    public void addSolution(SokobanSolution sol) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(sol);
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public String getSolution(String levelName) {
        Session session = null;

        try {
            session = factory.openSession();

            SokobanSolution sol = session.get(SokobanSolution.class, levelName);
            if (sol != null) {
                return sol.getSolution();
            }
        }
        catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            if (session != null)
                session.close();
        }
        return null;
    }


}
