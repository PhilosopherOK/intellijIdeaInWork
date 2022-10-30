package org.example.less49_50_homework;


import org.example.models.less50_homework_oneperone.Principal;
import org.example.models.less50_homework_oneperone.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Homework_50less {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        //2) С помощью Hibernate получите любого директора, а затем получите его
        //школу.
        //3) Получите любую школу, а затем получите ее директора.
        //4) Создайте нового директора и новую школу и свяжите эти сущности.
        //5) Смените директора у существующей школы.
        //6) Попробуйте добавить вторую школу для существующего директора и
        //изучите возникающую ошибку.

        try{
            session.beginTransaction();
            //2 with hibernate take any principal and after this take his school
//            Principal principal = session.get(Principal.class, 1);
//            System.out.println(principal.getInSchool());

            //3 take any school and take his principal
//            School school = session.get(School.class,1);
//            System.out.println(school.getPrincipal_in_school());

            //4 create new principal and new school and synhronize them
//            Principal principal = new Principal("Tommy", 26);
//            principal.setInSchool( new School(365));
//                    session.save(principal);

            //5 change principal in school
//            School school = session.get(School.class,1);
//            school.setPrincipal_in_school(new Principal("Tommy2", 36));
//            session.save(school);
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
