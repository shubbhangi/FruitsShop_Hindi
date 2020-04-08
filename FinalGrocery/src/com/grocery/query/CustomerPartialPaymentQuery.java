/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.CustomerPartialPayment;
import com.grocery.util.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class CustomerPartialPaymentQuery 
{
    public void insertIntoCustomerPartialPayment(CustomerPartialPayment customerPartialPayment)
     {
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             session.save(customerPartialPayment);
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
    
    public void updateCustomerPartialPayment(CustomerPartialPayment customerPartialPayment)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            CustomerPartialPayment cpp = (CustomerPartialPayment)session.load(CustomerPartialPayment.class, customerPartialPayment.getId());
            cpp.setChequeClearanceDate(customerPartialPayment.getChequeClearanceDate());
            cpp.setStatus(customerPartialPayment.getStatus());
            session.update(cpp);
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
    
    public List<Object[]> getDetails(CustomerPartialPayment customerPartialPayment)
    {
        List<Object[]> list = new ArrayList<>();
        
        java.sql.Date sqlDate = new java.sql.Date(customerPartialPayment.getChequeDate().getTime());
        
        String query = "FROM CustomerPartialPayment cpp JOIN cpp.customerMaster cm "
                +      "WHERE cpp.chequeDate <= '" + sqlDate + "' AND cpp.status = '0'";
        
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
    
    public List<Object[]> getCustomerPaymentHistory(CustomerPartialPayment customerPartialPayment)
    {
        List<Object[]> list = new ArrayList<>();
        
        String query = "FROM CustomerPartialPayment cpp JOIN cpp.customerMaster cm "
                +      "WHERE cpp.customerMaster = " + customerPartialPayment.getCustomerMaster().getId();
        
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
    
    public List<BigDecimal> getTotal(CustomerPartialPayment customerPartialPayment)
    {   
        java.sql.Date sqlFromDate = new java.sql.Date(customerPartialPayment.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(customerPartialPayment.getTo().getTime());
        
        String query = "SELECT SUM(paidAmount) FROM CustomerPartialPayment "
                +      "WHERE ((date BETWEEN '" + sqlFromDate + "' AND '" + sqlToDate +"') AND paymentMode = '" + customerPartialPayment.getPaymentMode() + "')";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<BigDecimal> list = new ArrayList<>();
        
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
}
