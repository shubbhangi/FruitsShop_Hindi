/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.CustomerPartialPayment;
import com.grocery.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author GanpatiBappa
 */
public class BillDetailsQuery {
    
     public int getBillNumber() {
        
         Session session = HibernateUtil.getSessionFactory().openSession();
         int billNumber = 0;
        
        try
        {
           billNumber = (Integer)session.createQuery("select MAX(Id) from CustomerPartialPayment").list().get(0);       
            //invoiceNumber = (Integer)session.createQuery("select MAX(invoiceNumber) from BillDetails").list().get(0);
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return billNumber;
    }

    public void insertIntoBillDetails(CustomerPartialPayment customerPartialPayment) {
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

    public int getInvoiceNumber() {
      Session session = HibernateUtil.getSessionFactory().openSession();
         int invoiceNumber = 0;
        
        try
        {
            //SELECT MAX(id) FROM sale_master
            invoiceNumber = (Integer)session.createQuery("select MAX(id) from SaleMaster").list().get(0);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return invoiceNumber;
    }  
        
    
}
