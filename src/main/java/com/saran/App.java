package com.saran;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
        
        SessionFactory sf=meta.getSessionFactoryBuilder().build();
        Session session=sf.openSession();
        
        Transaction t=session.beginTransaction();
        Product p1=new Product();
        p1.setPrdId(3);p1.setPrdName("Chairs");p1.setPrdPrice(200);
       // session.save(p1);
        Product p2=new Product();
        p2.setPrdId(4);p2.setPrdName("Pillows");p2.setPrdPrice(30);
        session.save(p1);session.save(p2);
        t.commit();
        sf.close();session.close();
        System.out.println("Done");
        
    }
}
