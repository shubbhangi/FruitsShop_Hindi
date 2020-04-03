/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;


import com.grocery.bean.ItemAvailability;
import com.grocery.bean.ItemMaster;
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
public class ItemAvailabilityQuery 
{
    public List<ItemAvailability> checkItem(ItemAvailability iAvailability)
    {
        List<ItemAvailability> list = new ArrayList<>();
        
        String query = "FROM ItemAvailability WHERE itemMaster = " + iAvailability.getItemMaster().getId();
        
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
    
    public void insertIntoItemAvailability(ItemAvailability iAvailability)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(iAvailability);
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
    
    public void updateItemAvailability(ItemAvailability iAvailability)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            ItemAvailability ia = (ItemAvailability)session.load(ItemAvailability.class, iAvailability.getId());
            ia.setAvailability(iAvailability.getAvailability());
            if(iAvailability.getThreshold() != null)
                ia.setThreshold(iAvailability.getThreshold());
            
            session.update(ia);
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
    
 /*   public List<Object[]> getAvailability(ItemAvailability itemAvailability)
    {
        List<Object[]> list = new ArrayList<>();
        
        String query = "";
        
        if(itemAvailability.getItemMaster().getName() == null)
            query = "FROM ItemAvailability ia JOIN ia.itemMaster im ORDER BY im.name ASC";
        else
            query = "FROM ItemAvailability ia JOIN ia.itemMaster im WHERE im.name LIKE '%" + itemAvailability.getItemMaster().getName() + "' "
                  + "OR im.name LIKE '%" + itemAvailability.getItemMaster().getName() + "%' ORDER BY im.name ASC";
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
    } */
    
     public List<Object[]> getAvailability(ItemAvailability itemAvailability)
    {
        List<Object[]> list = new ArrayList<>();
        
        String query = "";
        
        if(itemAvailability.getItemMaster().getBarCode()== null)
       // if(itemAvailability.getItemMaster().getName() == null)
          // query = "FROM ItemAvailability ia JOIN ia.itemMaster im ORDER BY im.name ASC";
           query = "FROM ItemAvailability ia JOIN ia.itemMaster im ORDER BY im.barCode ASC";

        
        else
//            query = "FROM ItemAvailability ia JOIN ia.itemMaster im WHERE im.name LIKE '%" + itemAvailability.getItemMaster().getName() + "' "
//                  + "OR im.name LIKE '%" + itemAvailability.getItemMaster().getName() + "%' ORDER BY im.name ASC";
            query = "FROM ItemAvailability ia JOIN ia.itemMaster im WHERE im.barCode = '" + itemAvailability.getItemMaster().getBarCode()+ "' ";
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

    public List<ItemAvailability> checkItem(ItemMaster item) {
     
        List<ItemAvailability> list = new ArrayList<>();
        
        String query = "select * FROM item_availability WHERE itemId = " + item.getId();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            session.beginTransaction();
            Query q = session.createSQLQuery(query);
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
