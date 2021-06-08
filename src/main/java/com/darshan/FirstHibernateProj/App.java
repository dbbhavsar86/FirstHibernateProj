package com.darshan.FirstHibernateProj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
      
    	AlienName an = new AlienName();
    	
//    	an.setFname("Darshan");
//    	an.setMname("Bhupeshkumar");
//    	an.setLname("Bhavsar");
//    	Alien a1 = new Alien();
//    	a1.setAid(101);
//    	a1.setAname(an);
//    	a1.setColor("green");
    	
    	Alien a2= null;
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	//ServiceRegistry sr = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(con.getProperties());
    	
    	SessionFactory sf = con.buildSessionFactory();
    	Session session1 = sf.openSession();
    	
    	session1.beginTransaction();
    	
    	//session1.save(a1);
    	a2 = (Alien)session1.get(Alien.class,101);
    	System.out.println(a2);
    	
    	a2 = (Alien)session1.get(Alien.class,102);
    	System.out.println(a2);
    	
    	
    	
    	session1.getTransaction().commit();
    	session1.close();
    	
    	Session session2 = sf.openSession();
    	
    	session2.beginTransaction();
    	
    	
    	a2 = (Alien)session2.get(Alien.class,102);
    	System.out.println(a2);
    	
    	session2.getTransaction().commit();
    	session2.close();
    }
}
