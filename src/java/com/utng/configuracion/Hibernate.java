package com.utng.configuracion;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author marib
 */
public class Hibernate {

    public static SessionFactory sesion = null;

    static {
        try {
            sesion = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSesion() {
        System.out.println(sesion);
        return sesion;
    }
    
//    public static void main(String[] args) {
//        getSesion();
//    }
}
