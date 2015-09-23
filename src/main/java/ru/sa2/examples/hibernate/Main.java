package ru.sa2.examples.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Alexander Smirnov (AlVyaSmirnov) on 21.09.2015.
 * email: asmirnov@vrn.beeline.ru
 */

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(new Person("one", "two"));
        session.getTransaction().commit();

        List<Person> persons = session.createCriteria(Person.class).list();

        System.out.println(persons.size());

        Person p = session.get(Person.class, 4);

        System.out.println(p);
        System.out.println(session.get(Person.class, 8));

        session.close();
        sessionFactory.close();


        System.out.println("Success!");

    }
}
