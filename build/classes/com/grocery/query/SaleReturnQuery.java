/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.SaleReturn;
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
public class SaleReturnQuery 
{
    public void insertIntoSaleReturnDetails(SaleReturn saleReturn)
    {
       Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(saleReturn);
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
    
    public List<Object[]> getSaleReturn(SaleReturn saleReturn)
    {
        java.sql.Date sqlFromDate = new java.sql.Date(saleReturn.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(saleReturn.getTo().getTime());
        
        String query =  "SELECT date, amount FROM SaleReturn \n" +
                        "WHERE(date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') \n" +
                        " ORDER BY id ASC";
        
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
