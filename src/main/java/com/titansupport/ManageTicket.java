package com.titansupport;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class ManageTicket {

    private static SessionFactory sessionFactory;

    // Constructor to initialize the session factory
    public ManageTicket(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static void addTicket(Ticket ticket) { //Take in a ticket object
        Transaction transaction = null; //Initialize the transaction
        try (Session session = sessionFactory.openSession()) { //Try to launch a Hibernate session
            System.out.println("Beginning a session"); //Inform the host that a session is starting
            transaction = session.beginTransaction(); //Being the transaction
            System.out.println("Adding the ticket"); //Inform the host that a ticket is being added
            session.persist(ticket); //Persist the ticket
            System.out.println("Ticket persisted"); //Inform the host that a ticket is being persisted
            transaction.commit(); //Commit the ticket to the database
            System.out.println("Committed..."); //Inform the host that a ticket has been committed
        } catch (Exception e) { //If there is an Exception
            if (transaction != null) { //If the transaction is invalid
                transaction.rollback(); //Reset the transaction
            }
            System.err.println("There has been an error in adding a ticket."); //Inform the host that a ticket could not be added
            e.printStackTrace(); //Print the Exception to the console

        }
    }
}