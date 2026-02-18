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

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();

        User user1 = session2.get(User.class, user.getId());
        User user2 = session2.get(User.class, user.getId());

        System.out.println(user1 == user2);

        session2.getTransaction().commit();
        session2.close();
    }
}