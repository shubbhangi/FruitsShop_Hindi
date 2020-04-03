/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;


import com.grocery.bean.VendorBillMaster;
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
public class VendorBillMasterQuery 
{
     public void insertIntoVendorBillMaster(VendorBillMaster vendorBillMaster)
     {
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             session.save(vendorBillMaster);
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
     
     public void updateVendorBillMaster(VendorBillMaster vendorBillMaster)
     {
         Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             VendorBillMaster vbm = (VendorBillMaster)session.load(VendorBillMaster.class, vendorBillMaster.getId());
             
             if(vendorBillMaster.getRemark() != null)
                vbm.setRemark(vendorBillMaster.getRemark());
             if(vendorBillMaster.getBillAmount() != null)
                 vbm.setBillAmount(vendorBillMaster.getBillAmount());
             if(vendorBillMaster.getFinalBillAmount() != null)
                 vbm.setFinalBillAmount(vendorBillMaster.getFinalBillAmount());
             
             session.update(vbm);
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
     
    public List<Object[]> getPendingPayments()
    {
        String query = "FROM VendorBillMaster vbm JOIN vbm.vendorMaster WHERE vbm.status = '0'";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = new ArrayList<Object[]>();
        
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
    
    public List<Object[]> getTotalPurchase(VendorBillMaster vendorBillMaster, boolean flag)
    {       
        java.sql.Date sqlFromDate = new java.sql.Date(vendorBillMaster.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(vendorBillMaster.getTo().getTime());
        
        String query =  "";
        
        if(flag)
            query =  "SELECT date, SUM(billAmount), SUM(discount), SUM(finalBillAmount) FROM VendorBillMaster \n" +
                     "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND remark = 'GST Taken') \n" +
                     "GROUP BY date ORDER BY date ASC";
        else
            query =  "SELECT date, SUM(billAmount), SUM(discount), SUM(finalBillAmount) FROM VendorBillMaster \n" +
                     "WHERE ((date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') AND remark = 'GST Not Taken') \n" +
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
    
    public List<Object[]> getPurchaseById(VendorBillMaster vendorBillMaster)
    {       
        java.sql.Date sqlFromDate = new java.sql.Date(vendorBillMaster.getDate().getTime());
        java.sql.Date sqlToDate = new java.sql.Date(vendorBillMaster.getTo().getTime());
   
        String query =  "FROM VendorBillMaster vbm JOIN vbm.vendorMaster vm " +
                        "WHERE (vbm.date BETWEEN '" + sqlFromDate +"' AND '"+ sqlToDate + "') \n" +
                        "ORDER BY vbm.date ASC";
        
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
    
    public List<Object[]> getPurchaseByVendorId(VendorBillMaster vendorBillMaster)
    {
        String query = "FROM VendorBillMaster vbm JOIN vbm.vendorMaster vm WHERE vm.id = " + vendorBillMaster.getVendorMaster().getId();
        
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
    
    public List<Object[]> getPurchaseByBillId(VendorBillMaster vendorBillMaster)
    {
        String query = "FROM StockDetails sd JOIN sd.vendorBillMaster vbm JOIN sd.itemMaster im JOIN vbm.vendorMaster "
                +      "WHERE vbm.id = " + vendorBillMaster.getId();
        
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
    
    public List<Object[]> getPurchase(VendorBillMaster vendorBillMaster)
    {
        String query = "";
        
        List<Object[]> list = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        if(vendorBillMaster.getId() != null)
            query = "FROM VendorBillMaster vbm JOIN vbm.vendorMaster WHERE vbm.id = " + vendorBillMaster.getId();
        else
            if(vendorBillMaster.getChallan() != null)
                query = "FROM VendorBillMaster vbm JOIN vbm.vendorMaster WHERE vbm.challan LIKE '%" + vendorBillMaster.getChallan() + "' OR vbm.challan LIKE '%" + vendorBillMaster.getChallan() + "%'";
            else
                if(vendorBillMaster.getVendorMaster() != null)
                    query = "FROM VendorBillMaster vbm JOIN vbm.vendorMaster WHERE vbm.vendorMaster = " + vendorBillMaster.getVendorMaster().getId();
                else
                {
                    java.sql.Date fromDate = new java.sql.Date(vendorBillMaster.getDate().getTime());
                    java.sql.Date toDate = new java.sql.Date(vendorBillMaster.getTo().getTime());
                    
                    query = "FROM VendorBillMaster vbm JOIN vbm.vendorMaster WHERE vbm.date BETWEEN '" + fromDate + "' AND '" + toDate + "'";
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
}
