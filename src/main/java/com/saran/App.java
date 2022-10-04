package com.saran;
//First Level Cache
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
        Session session=sf.openSession();//creating a new session
        Session session1=sf.openSession();//creating a new session
        
        /*Transaction t=session.beginTransaction();
        Product p1=new Product();
        p1.setPrdId(1);p1.setPrdName("IPhone");p1.setPrdPrice(2000);
        session.save(p1);
        Product p2=new Product();
        p2.setPrdId(2);p2.setPrdName("Andriod");p2.setPrdPrice(30);
        session.save(p2);
        
        t.commit();
        */
        //First Level Cache
        Product p=(Product)session.load(Product.class, 1);
        System.out.println(p);
        
        Product p1=(Product)session.load(Product.class, 1);
        System.out.println(p1);
              System.out.println("Done");
              
        
    }
}
