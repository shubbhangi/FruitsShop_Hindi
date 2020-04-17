   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;


import com.grocery.bean.SaleMaster;
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
public class SaleMasterQuery 
{
    public List<SaleMaster> getSaleDetails(SaleMaster saleMaster)
    {
       String query = "FROM SaleMaster WHERE counter = " + saleMaster.getCounter().getId() + " AND status = '0'";
           
       Session session = HibernateUtil.getSessionFactory().openSession();
       List<SaleMaster> list = new ArrayList<>();

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
    
    public void insertIntoSaleMaster(SaleMaster saleMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(saleMaster);
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
    public void updateSaleMaster(SaleMaster saleMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            SaleMaster sm = (SaleMaster)session.load(SaleMaster.class, saleMaster.getId());
            sm.setCustomerMaster(saleMaster.getCustomerMaster());
            sm.setBillAmount(saleMaster.getBillAmount());
            sm.setDiscount(saleMaster.getDiscount());
            sm.setFinalBillAmount(saleMaster.getFinalBillAmount());
            sm.setStatus(saleMaster.getStatus());
            sm.setRemark(saleMaster.getRemark());
            sm.setReference(saleMaster.getReference());
            
            session.update(sm);
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
    
 /*   public List<BigDecimal> getAmountReceived(SaleMaster saleMaster)
    {       
        java.sql.Date sqlDate = new java.sql.Date(saleMaster.getDate().getTime());
        
        String query = "SELECT SUM(paidAmount) FROM SaleMaster WHERE date = '" + sqlDate + "' AND paymentMode = '" + saleMaster.getPaymentMode() + "'";
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
    } */
    
    public List<Object[]> getItems(SaleMaster saleMaster)
    {       
        java.sql.Date sqlFromDate = new java.sql.Date(saleMaster.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(saleMaster.getTo().getTime());
   
        String query =  "SELECT sd.endProduct, SUM(sd.quantity), SUM(sd.total), sd.unitPrice, sm.date FROM SaleDetails sd \n" +
                        "JOIN sd.saleMaster sm JOIN sd.endProduct ep WHERE sm.date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "' \n" +
                        "GROUP BY ep.id, sm.date ORDER BY sm.date, ep.name ASC";
        
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
            
        }
        finally 
        {
            session.close();
        }
        return list;
    }
    
    public List<Object[]> getSale(SaleMaster saleMaster, boolean flag)
    {       
        java.sql.Date sqlFromDate = new java.sql.Date(saleMaster.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(saleMaster.getTo().getTime());
   
        String query =  "";
        
        if(flag)
          query =  "SELECT date, SUM(billAmount), SUM(finalBillAmount), SUM(discount) FROM SaleMaster \n" +
                   "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND status = '1' AND remark = 'GST Taken') \n" +
                   "GROUP BY date ORDER BY date ASC";
        else
            query = "SELECT date, SUM(billAmount), SUM(finalBillAmount), SUM(discount) FROM SaleMaster \n" +
                    "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND status = '1' AND remark = 'GST Not Taken') \n" +
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
            
        }
        finally 
        {
            session.close();
        }
        return list;
    }
    
    public List<Object[]> getIndividualSale(SaleMaster saleMaster)
    {       
        java.sql.Date sqlFromDate = new java.sql.Date(saleMaster.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(saleMaster.getTo().getTime());
   
        String query =  "SELECT date, billAmount, paidAmount, discount, id FROM SaleMaster \n" +
                        "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND status = '1') \n" +
                        "ORDER BY date ASC";
        
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
            
        }
        finally 
        {
            session.close();
        }
        return list;
    }
    
    public List<Object[]> getSaleByCustomerId(SaleMaster saleMaster)
    {
        String query = "FROM SaleMaster sm JOIN sm.customerMaster cm WHERE cm.id = " + saleMaster.getCustomerMaster().getId();
        
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
            
        }
        finally 
        {
            session.close();
        }
        return list;
    }
    
    public List<Object[]> getSaleByBillId(SaleMaster saleMaster)
    {
        String query = "FROM SaleDetails sd JOIN sd.saleMaster sm JOIN sd.itemMaster JOIN sm.customerMaster "
                +      "WHERE sm.id = " + saleMaster.getId();
        
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
            
        }
        finally 
        {
            session.close();
        }
        return list;
    }
    
    public List<Object[]> getSale(SaleMaster saleMaster)
    {
        String query = "";
        
        List<Object[]> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        if(saleMaster.getId() != null)
            query = "FROM SaleMaster sm JOIN sm.customerMaster WHERE sm.id = " + saleMaster.getId();
        else
            if(saleMaster.getCustomerMaster() != null)
                query = "FROM SaleMaster sm JOIN sm.customerMaster WHERE sm.customerMaster = " + saleMaster.getCustomerMaster().getId();
            else
            {
                java.sql.Date fromDate = new java.sql.Date(saleMaster.getDate().getTime());
                java.sql.Date toDate = new java.sql.Date(saleMaster.getTo().getTime());

                query = "FROM SaleMaster sm JOIN sm.customerMaster WHERE sm.date BETWEEN '" + fromDate + "' AND '" + toDate + "'";
            }
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
    
    public void updateBillAmount(SaleMaster saleMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            SaleMaster sm = (SaleMaster)session.load(SaleMaster.class, saleMaster.getId());
            
            sm.setBillAmount(saleMaster.getBillAmount());
            sm.setFinalBillAmount(saleMaster.getFinalBillAmount());
            
            session.update(sm);
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
    
    public List<Object[]> getSaleOnId(SaleMaster saleMaster)
    {
        String query = "FROM SaleDetails sd JOIN sd.saleMaster sm JOIN sd.itemMaster im "
                +      "JOIN sm.customerMaster WHERE sm.id LIKE '" + saleMaster.getId() + "%'";
        
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
            
        }
        finally 
        {
            session.close();
        }
        return list;
    }
}
