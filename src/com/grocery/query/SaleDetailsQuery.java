/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;


import com.grocery.bean.SaleDetails;
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
public class SaleDetailsQuery 
{
    public List<Object[]> getSale(SaleDetails saleDetails)
    {
        String query = "FROM SaleDetails s JOIN s.itemMaster WHERE s.saleMaster = " + saleDetails.getSaleMaster().getId();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = new ArrayList<>();
        
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
    
    public List<SaleDetails> checkItem(SaleDetails saleDetails)
    {
        String query = "FROM SaleDetails WHERE saleMaster = " + saleDetails.getSaleMaster().getId() + " "
                +      "AND itemMaster = " + saleDetails.getItemMaster().getId();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SaleDetails> list = new ArrayList<>();
        
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
    
    public void updateSaleDetails(SaleDetails saleDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            SaleDetails sd = (SaleDetails)session.load(SaleDetails.class, saleDetails.getId());
            sd.setQuantity(saleDetails.getQuantity());
            sd.setTotal(saleDetails.getTotal());
            
            session.update(sd);
            session.flush();
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
    
    public void insertIntoSaleDetails(SaleDetails saleDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(saleDetails);
            session.flush();
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
    
    public void deleteSaleDetails(SaleDetails saleDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            SaleDetails sd = (SaleDetails)session.load(SaleDetails.class, saleDetails.getId());
            session.delete(sd);
            session.flush();
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
    
    public void updateGst(SaleDetails saleDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            SaleDetails sd = (SaleDetails)session.load(SaleDetails.class, saleDetails.getId());
            sd.setGstPercent(saleDetails.getGstPercent());
            sd.setTotal(saleDetails.getTotal());
            sd.setSellingPrice(saleDetails.getSellingPrice());
            
            session.update(sd);
            session.flush();
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
    
    public List<Object[]> getSaleDetails(SaleDetails saleDetails)
    {
        String query = "FROM SaleMaster sm JOIN sm.saleDetailses sd JOIN sd.itemMaster im JOIN sm.customerMaster WHERE sm.id = " + saleDetails.getSaleMaster().getId();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list = new ArrayList<>();
        
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
