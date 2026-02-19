package com.example;

import com.example.entity.User;
import com.example.util.HibernateUtil;
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

        User user1 = session1.get(User.class, user.getId());
        session1.getTransaction().commit();
        session1.close();

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();

        User user2 = session2.get(User.class, user.getId());
        session2.getTransaction().commit();
        session2.close();

        System.out.println("User1 Id = " + user1.getId() + " User2 Id = " + user2.getId());
    }
}