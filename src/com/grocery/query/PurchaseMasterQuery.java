/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.ItemMaster;
import com.grocery.bean.PurchaseMaster;
import com.grocery.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author GanpatiBappa
 */
    public class PurchaseMasterQuery {
        
    public static List<PurchaseMaster> getItemByNameAndBrand(String itemName) {
         List<PurchaseMaster> list = new ArrayList<>();
        
        String query = "";
        
        if(itemName != null)
           
       
            query = "from PurchaseMaster  where name = '"+itemName+"' group by name";
        
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
    
    public List<PurchaseMaster> getItemDetails(PurchaseMaster purchaseMaster)
    {
        List<PurchaseMaster> list = new ArrayList<>();
        
        String query = "";
        
        if(purchaseMaster.getName() != null)
            query = "FROM PurchaseMaster WHERE name = '" + purchaseMaster.getName() + "'";
        else
            query = "FROM PurchaseMaster WHERE name <> 'N/A' ORDER BY name ASC";
        
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
    
        public List<PurchaseMaster> getBrandDetails1(PurchaseMaster itemMaster)
    {
     
        List<PurchaseMaster> list = new ArrayList<>();
        
        String query = "";

        if(itemMaster.getName()!= null)
            query = "FROM PurchaseMaster WHERE name = '" + itemMaster.getName()+ "'";
        else
            query = "FROM PurchaseMaster ORDER BY name ASC";
        
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

    
    public List<PurchaseMaster> checkItem(PurchaseMaster purchaseMaster)
    {
        List<PurchaseMaster> list = new ArrayList<>();
        
        String query = "FROM PurchaseMaster WHERE name = '" + purchaseMaster.getName() + "' "
                +      "AND brand ='" + purchaseMaster.getBrand()+ "'";
                
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
    
    public void insertItem(PurchaseMaster purchaseMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(purchaseMaster);
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
    
    public List<String> getDistinctItem()
    {
        List<String> list = new ArrayList<>();
        
        String query = "SELECT DISTINCT name FROM PurchaseMaster WHERE name <> 'N/A' ORDER BY name ASC";
        
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

    public void updatePurchaseMaster(PurchaseMaster purchaseMaster) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            
             String query = "FROM PurchaseMaster WHERE name = '" + purchaseMaster.getName() + "' "
                +      "AND brandName = '" + purchaseMaster.getBrand()+ "' "
                +      "AND weight = '" + purchaseMaster.getWeight()+ "' "
                +      "AND unit = '" + purchaseMaster.getUnit()+ "' "
                +      "AND quantity = '" + purchaseMaster.getQuantity()+ "' "
                +      "AND total = '" + purchaseMaster.getTotal()+ "' "
                +      "AND gstType = '" + purchaseMaster.getGstType()+ "'"
                +      "AND gst_percent ='" + purchaseMaster.getGstPercent() + "'"
                +      "AND actual_amount = '" + purchaseMaster.getActualAmount()+ "' "
                +      "AND gst_amount = '" + purchaseMaster.getGstAmount()+ "' "
                +      "AND unitPrice = '" + purchaseMaster.getUnitPrice()+ "' ";

            Transaction transaction = session.beginTransaction();
            PurchaseMaster im = (PurchaseMaster)session.load(PurchaseMaster.class, purchaseMaster.getId());
            im.setName(purchaseMaster.getName());
            im.setBrand(purchaseMaster.getBrand());
            im.setWeight(purchaseMaster.getWeight());
            im.setUnit(purchaseMaster.getUnit());
            
            session.update(im);
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

    public List<PurchaseMaster> getItemById(PurchaseMaster purchaseMaster)
    {
        List<PurchaseMaster> list = new ArrayList<>();
        
        String query = "FROM PurchaseMaster WHERE id = " + purchaseMaster.getId();
        
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

    public List<PurchaseMaster> getItemDetails1(PurchaseMaster purchaseMaster)
    {
     
        List<PurchaseMaster> list = new ArrayList<>();
        
        String query = "";

        if(purchaseMaster.getName() != null)
            query = "FROM PurchaseMaster WHERE name = '" + purchaseMaster.getName() + "'";
        else
            query = "FROM PurchaseMaster WHERE name <> 'N/A' ORDER BY name ASC";
        
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
