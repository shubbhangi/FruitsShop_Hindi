/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.CustomerMaster;
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
public class CustomerMasterQuery 
{
    public List<CustomerMaster> getCustomerDetails(CustomerMaster customerMaster)
    {
        List<CustomerMaster> list = new ArrayList<>();
        
        String query = "";
        
        if(customerMaster.getId() != null)
            query = "FROM CustomerMaster WHERE id = " + customerMaster.getId();
        else
            if(customerMaster.getName() == null)
                query = "FROM CustomerMaster WHERE name <> 'N/A' ORDER BY name ASC";
            else
                if(customerMaster.getName() != null)
                    query = "FROM CustomerMaster WHERE name = '" + customerMaster.getName() + "'";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            session.beginTransaction();
            Query q = session.createQuery(query);
            list = q.list();
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            session.close();
        }
        return list;
    }
    
    public void updateCustomerBalance(CustomerMaster customerMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            CustomerMaster cm = (CustomerMaster)session.load(CustomerMaster.class, customerMaster.getId());
            
            cm.setBalance(customerMaster.getBalance());
            
            session.update(cm);
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
    
    public List<CustomerMaster> getCustomer(CustomerMaster customerMaster)
    {
        List<CustomerMaster> list = new ArrayList<>();
        
        String query = "";

        if(customerMaster.getName() == null)
            query = "FROM CustomerMaster WHERE name <> 'N/A'";
        else
            query = "FROM CustomerMaster WHERE name = '" + customerMaster.getName() + "'";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            session.beginTransaction();
            Query q = session.createQuery(query);
            list = q.list();
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            session.close();
        }
        return list;
    }
    
    public void insertIntoCustomerMaster(CustomerMaster customerMaster)
    {
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             session.save(customerMaster);
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
    
    public void updateCustomerMaster(CustomerMaster customerMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            CustomerMaster cm = (CustomerMaster)session.load(CustomerMaster.class, customerMaster.getId());
            
            cm.setContact(customerMaster.getContact());
            cm.setAddress(customerMaster.getAddress());
            if(customerMaster.getGstNumber() != null)
                cm.setGstNumber(customerMaster.getGstNumber());
            session.update(cm);
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
