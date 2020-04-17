/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.BeginningCash;
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
public class BeginningCashQuery 
{
    public List<BigDecimal> getBeginningCash()
    {        
        String query = "SELECT SUM(amount) FROM BeginningCash";
        List<BigDecimal> list = new ArrayList<>();
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
    
    public void insertIntoBeginningCash(BeginningCash beginningCash)
     {
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             session.save(beginningCash);
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
    
    public List<BeginningCash> checkEntry(BeginningCash beginningCash)
    {        
        
        java.sql.Date sqlDate = new java.sql.Date(beginningCash.getDate().getTime());
        String query = "FROM BeginningCash WHERE date = '" + sqlDate + "'";
        List<BeginningCash> list = new ArrayList<>();
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
}
