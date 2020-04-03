/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.StockDetails;
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
public class StockDetailsQuery 
{
    public void insertIntoStockDetails(StockDetails stockDetails)
    {
       Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(stockDetails);
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
    
    public List<Object[]> getPurchaseDetails(StockDetails stockDetails)
    {
        String query = "FROM StockDetails sd JOIN sd.vendorBillMaster vbm JOIN sd.itemMaster im "
                +      "JOIN vbm.vendorMaster WHERE vbm.id = " + stockDetails.getVendorBillMaster().getId();
        
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
    
    public List<Object[]> getPurchase(StockDetails stockDetails)
    {
        String query = "FROM StockDetails sd JOIN sd.vendorBillMaster vbm JOIN sd.itemMaster im "
                +      "JOIN vbm.vendorMaster JOIN im.itemAvailabilities WHERE vbm.id = " + stockDetails.getVendorBillMaster().getId();
        
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
    
    public void updateStockDetails(StockDetails stockDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            StockDetails sd = (StockDetails)session.load(StockDetails.class, stockDetails.getId());
            
            sd.setQuantity(stockDetails.getQuantity());
            sd.setGstAmount(stockDetails.getGstAmount());
            sd.setFinalTotal(stockDetails.getFinalTotal());
            
            session.update(sd);
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
