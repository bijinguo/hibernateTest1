package com.bi;

import com.bi.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class PERTest {

    SessionFactory sessionFactory;
    @Before
    public void init(){


        Configuration configuration = new Configuration();
         sessionFactory = configuration.configure().buildSessionFactory();



    }
    @Test
    public void testGet(){

        Session session = sessionFactory.openSession();

//        Transaction transaction = session.beginTransaction();
//        Person p=new Person();
//        p.setAddress("上海");
//        p.setAge(34);
//        p.setName("jack");
//        session.createQuery("delete person where id=1");
        Person person = session.get(Person.class, 2);
        System.out.println(person.toString());

//        transaction.commit();


        session.close();

    }

    @Test
    public void testFind(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person p=new Person();
        session.delete(p);
        transaction.commit();
        session.close();



    }
    @Test
    public void addEntity(){

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
                Person p=new Person();
        p.setAddress("广州");
        p.setAge(36);
        p.setName("jerry");

        session.saveOrUpdate(p);
        transaction.commit();
        session.close();
    }



}
