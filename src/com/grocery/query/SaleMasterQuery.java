   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;


import com.grocery.bean.SaleMaster;
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
            SaleMaster sm = new SaleMaster();
            sm.setCustomerDetails(saleMaster.getCustomerDetails());
            sm.setBillAmount(saleMaster.getBillAmount());
            sm.setGstAmount(saleMaster.getGstAmount());
            sm.setDiscount(saleMaster.getDiscount());
            sm.setFinalBillAmount(saleMaster.getFinalBillAmount());
            sm.setStatus(saleMaster.getStatus());
            sm.setRemark(saleMaster.getRemark());
            sm.setReference(saleMaster.getReference());
            sm.setBarCodeFlag(saleMaster.getBarCodeFlag());
            
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
    
    public List<Object[]> getSale1(SaleMaster saleMaster)
   // public List<Object[]> getSale(SaleMaster saleMaster, String flag)
    {       
        java.sql.Date sqlFromDate = new java.sql.Date(saleMaster.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(saleMaster.getTo().getTime());
   
        String query =  "";
        
        //if(flag == "GST")
//          query =  "SELECT date, billAmount, finalBillAmount, discount FROM SaleMaster \n" +
//                   "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND status = '1' AND remark = 'GST') \n" +
//                   "ORDER BY date ASC";
          query =  "SELECT date, billAmount, finalBillAmount, discount FROM SaleMaster \n" +
                   "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND status = '1') \n" +
                   "ORDER BY date ASC";
        
 /*       else if(flag == "IGST")
          query =  "SELECT date, billAmount, finalBillAmount, discount FROM SaleMaster \n" +
                   "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND status = '1' AND remark = 'IGST') \n" +
                   "ORDER BY date ASC";
        
        else
            query = "SELECT date, billAmount, finalBillAmount, discount FROM SaleMaster \n" +
                    "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND status = '1' AND remark = 'NON-GST') \n" +
                    "ORDER BY date ASC";
         */
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
    
    public List<Object[]> getSaleByWarehouseId(SaleMaster saleMaster)
    {
        //String query = "FROM SaleMaster sm JOIN sm.customerDetails cm WHERE cm.id = " + customerDetails.getCustomerDetails().getId();
        String query = "FROM SaleMaster sm JOIN sm.customerDetails cm WHERE cm.id = " + saleMaster.getCustomerDetails().getId();
        
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
        String query = "FROM SaleDetails sd JOIN sd.saleMaster sm JOIN sd.itemMaster JOIN sm.customerDetails "
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
            query = "FROM SaleMaster sm JOIN sm.customerDetails WHERE sm.id = " + saleMaster.getId();
        else
            if(saleMaster.getCustomerDetails()!= null)
                query = "FROM SaleMaster sm JOIN sm.customerDetails WHERE sm.customerDetails = " + saleMaster.getCustomerDetails().getId();
            else
            {
                java.sql.Date fromDate = new java.sql.Date(saleMaster.getDate().getTime());
                java.sql.Date toDate = new java.sql.Date(saleMaster.getTo().getTime());

                query = "FROM SaleMaster sm JOIN sm.customerDetails WHERE sm.date BETWEEN '" + fromDate + "' AND '" + toDate + "'";
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
                +      "JOIN sm.customerDetails WHERE sm.id LIKE '" + saleMaster.getId() + "%'";
        
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
