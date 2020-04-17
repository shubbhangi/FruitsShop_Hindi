 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.VendorPartialPayment;
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
public class VendorPartialPaymentQuery 
{
    public void insertIntoVendorPartialPayment(VendorPartialPayment vendorPartialPayment)
     {
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             session.save(vendorPartialPayment);
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
    
    public void updateVendorPartialPayment(VendorPartialPayment vendorPartialPayment)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            VendorPartialPayment vd = (VendorPartialPayment)session.load(VendorPartialPayment.class, vendorPartialPayment.getId());
            vd.setChequeClearanceDate(vendorPartialPayment.getChequeClearanceDate());
            vd.setStatus(vendorPartialPayment.getStatus());
            session.update(vd);
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
    
    public List<Object[]> getDetails(VendorPartialPayment vendorPartialPayment)
    {
        List<Object[]> list = new ArrayList<>();
        
        java.sql.Date sqlDate = new java.sql.Date(vendorPartialPayment.getChequeDate().getTime());
        
        String query = "FROM VendorPartialPayment vpp JOIN vpp.vendorMaster vm "
                +      "WHERE vpp.chequeDate <= '" + sqlDate + "' AND vpp.status = '0'";
        
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
    
  /*  public List<BigDecimal> getSum(VendorPartialPayment vendorPartialPayment)
    {        
        String query = "SELECT SUM(paidAmount) FROM VendorPartialPayment WHERE vendorBillMaster = " + vendorPartialPayment.getVendorBillMaster().getId() + " "
                +      "AND status = '1'";
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
            e.printStackTrace();
        }
        finally 
        {
            session.close();
        }
        return list;
    }   */
    
    public List<Object[]> getVendorPaymentHistory(VendorPartialPayment vendorPartialPayment)
    {
        List<Object[]> list = new ArrayList<>();
        
        String query = "FROM VendorPartialPayment vpp JOIN vpp.vendorMaster vm "
                +      "WHERE vpp.vendorMaster = " + vendorPartialPayment.getVendorMaster().getId();
        
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