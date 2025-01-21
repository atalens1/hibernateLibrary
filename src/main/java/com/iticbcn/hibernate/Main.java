package com.iticbcn.hibernate;

import org.hibernate.SessionFactory;

import com.iticbcn.hibernate.model.autor;
import com.iticbcn.hibernate.model.llibres;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Main 
{
    public static void main( String[] args )
    {

        Session session = null;

        try {

            SessionFactory sesion = HibernateUtil.getSessionFactory();

            session = sesion.openSession();

            session.beginTransaction();

            /*Inserció d'un autor i dos llibres */
            
            autor aut1 = new autor("Juan Gomez-Jurado","ESP");

            llibres l1 = new llibres("El paciente",2,aut1);

            llibres l2 = new llibres("Amanda Black 1 - Una herencia peligrosa",3,aut1);

            session.persist(l1);

            session.persist(l2);  
            
            session.getTransaction().commit();

        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            System.err.println("Error en Hibernate: " + e.getMessage());
        } catch (Exception e) {
            if (session.getTransaction()  != null) session.getTransaction().rollback();
            System.err.println("Error inesperado: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }

        try {

            SessionFactory sesion = HibernateUtil.getSessionFactory();

            session = sesion.openSession();

            session.beginTransaction();

            /*Inserció d'un autor i un llibre sense especificar l'autor. Genera excepció not null */

            autor aut2 = new autor("Mary clark Higgings","ENG");

            llibres l3 = new llibres();

            l3.setTitle("Mistery Go");

            session.persist(l3);
            
            session.getTransaction().commit();

        } catch (HibernateException e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            System.err.println("Error en Hibernate: " + e.getMessage());
        } catch (Exception e) {
            if (session.getTransaction()  != null) session.getTransaction().rollback();
            System.err.println("Error inesperado: " + e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        
    }
}