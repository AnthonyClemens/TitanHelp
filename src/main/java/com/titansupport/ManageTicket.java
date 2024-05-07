package com.titansupport;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageTicket {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Integer addTicket(String name, String problemString) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer ticketId = null;
        try {
            tx = session.beginTransaction();
            Ticket ticket = new Ticket();
            ticket.setName(name);
            ticket.setDate(LocalDate.now());
            ticket.setProblemString(problemString);
            ticketId = ticket.getID();
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ticketId;
    }
}