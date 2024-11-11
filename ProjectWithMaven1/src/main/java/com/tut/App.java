package com.tut;

import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started!" );
        Configuration cfg=new Configuration();
        cfg.configure ("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        //Creating Student
        Student st=new Student();
        st.setId(112);
        st.setName("Shyam");
        st.setCity("Delhi");
        System.out.println(st);
        
        //Creating Object of Address Class
        Address ad= new Address();
        ad.setStreet("street 1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddeDate(new Date());
        ad.setX(123.34);
       
        //Reading Image..
        FileInputStream fis= new FileInputStream("src/main/java/default.png");
        byte[] data=new byte [fis.available()];
        fis.read(data);
        ad.setImage(data);
        
       Session session=factory.openSession();
       Transaction tx=session.beginTransaction();
       session.save(st);
       session.save(ad);
       tx.commit();
       session.close();
        System.out.println("Done...");
       
    }
}
