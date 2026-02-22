package com.example;

import com.example.entity.User;
import com.example.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User("John");
        session.persist(user);

        session.getTransaction().commit();
        session.close();

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();

        List<User> list1 = session1.createQuery("from User", User.class)
                .setCacheable(true)
                .list();
        session1.getTransaction().commit();
        session1.close();

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();

        List<User> list2 = session2.createQuery("from User", User.class)
                .setCacheable(true)
                .list();
        session2.getTransaction().commit();
        session2.close();
    }
}