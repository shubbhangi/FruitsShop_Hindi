/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.PurchaseReturn;
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
public class PurchaseReturnQuery
{
    public void insertIntoPurchaseReturnDetails(PurchaseReturn purchaseReturn)
    {
       Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(purchaseReturn);
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
    
    public List<Object[]> getPurchaseReturn(PurchaseReturn purchaseReturn)
    {
        java.sql.Date sqlFromDate = new java.sql.Date(purchaseReturn.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(purchaseReturn.getTo().getTime());
        
        String query =  "SELECT date, SUM(amount) FROM PurchaseReturn \n" +
                        "WHERE(date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') \n" +
                        "GROUP BY date ORDER BY date ASC";
        
        List<Object[]> list = new ArrayList<>();
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
}
