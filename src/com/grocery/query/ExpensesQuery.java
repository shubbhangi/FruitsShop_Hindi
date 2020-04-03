/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.Expenses;
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
public class ExpensesQuery 
{
    public List<BigDecimal> getExpenses()
    {        
        String query = "SELECT SUM(amount) FROM Expenses";
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
    
    public void insertIntoExpenses(Expenses expenses)
     {
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             session.save(expenses);
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
