/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.PurchaseReturnDetails;
import com.grocery.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class PurchaseReturnDetailsQuery 
{
    public void insertIntoPurchaseReturnDetails(PurchaseReturnDetails purchaseReturnDetails)
    {
       Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(purchaseReturnDetails);
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
