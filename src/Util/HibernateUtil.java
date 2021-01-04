package Util;

import Model.Courses;
import Model.Registration;
import Model.Students;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
        private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().loadProperties("application.properties").build();
        Metadata mData = new MetadataSources(reg)
                .addAnnotatedClass(Students.class)
                .addAnnotatedClass(Courses.class)
                .addAnnotatedClass(Registration.class)
                .getMetadataBuilder().build();
        return mData.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
