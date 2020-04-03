/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.Counter;
import com.grocery.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class CounterQuery 
{
    public List<Counter> getCounterDetails(Counter counter)
    {
        List<Counter> list = new ArrayList<>();
        
        String query = "";
        
        if(counter.getName() != null)
            query = "FROM Counter WHERE name = '" + counter.getName() + "' AND status <> '0'";
        else
            query = "FROM Counter WHERE status <> '0'";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            session.beginTransaction();
            Query q = session.createQuery(query);
            list = q.list();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        
        return list;
    }
    
    public void insertCounter(Counter counter)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(counter);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
    
    public List<Counter> checkCounter(Counter counter)
    {      
           String query = "FROM Counter WHERE id <> " + counter.getId() + " AND name = '" + counter.getName() + "' AND status <> '0'";
           
           Session session = HibernateUtil.getSessionFactory().openSession();
           List<Counter> list = new ArrayList<>();
           
            try
            {
                session.beginTransaction();
                Query q = session.createQuery(query);
                list = q.list();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                session.close();
            }

            return list;
    }
    
    public void updateCounter(Counter counter)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            Counter c = (Counter)session.load(Counter.class, counter.getId());
            c.setName(counter.getName());
            c.setStatus(counter.getStatus());
            session.update(c);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }
}
