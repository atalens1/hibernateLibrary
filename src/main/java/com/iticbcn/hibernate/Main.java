package com.iticbcn.hibernate;

import org.hibernate.SessionFactory;

import com.iticbcn.hibernate.model.Autor;
import com.iticbcn.hibernate.model.LLibres;

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

            /*Inserció d'un Autor i dos LLibres */
            
            Autor aut1 = new Autor("Juan Gomez-Jurado","ESP");

            LLibres l1 = new LLibres("El paciente",2,aut1);

            LLibres l2 = new LLibres("Amanda Black 1 - Una herencia peligrosa",3,aut1);

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

            /*Inserció d'un Autor i un llibre sense especificar l'Autor. Genera excepció not null */

            Autor aut2 = new Autor("Mary clark Higgings","ENG");

            LLibres l3 = new LLibres();

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