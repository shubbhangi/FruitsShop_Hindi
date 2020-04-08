/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;


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
public class ItemQuery 
{
    public List<ItemMaster> getItemDetails(ItemMaster itemMaster)
    {
        List<ItemMaster> list = new ArrayList<>();
        
        String query = "";
        
        if(itemMaster.getName() != null)
            query = "FROM ItemMaster WHERE name = '" + itemMaster.getName() + "'";
        else
            query = "FROM ItemMaster WHERE name <> 'N/A' ORDER BY name ASC";
        
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
    
    public List<ItemMaster> checkItem(ItemMaster itemMaster)
    {
        List<ItemMaster> list = new ArrayList<>();
        
        String query = "FROM ItemMaster WHERE name = '" + itemMaster.getName() + "' "
                +      "AND unitPrice = " + itemMaster.getUnitPrice() + " "
                +      "AND gstPercent = " + itemMaster.getGstPercent() + " "
                +      "AND sellingPrice = " + itemMaster.getSellingPrice() + " "
                +      "AND sellingGstPercent = " + itemMaster.getGstPercent() + " "
                +      "AND hsnCode = '" + itemMaster.getHsnCode() + "'";
        
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
    
    public void insertItem(ItemMaster itemMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(itemMaster);
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
        
        String query = "SELECT DISTINCT name FROM ItemMaster WHERE name <> 'N/A' ORDER BY name ASC";
        
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

    public void updateItemMaster(ItemMaster itemMaster) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            ItemMaster im = (ItemMaster)session.load(ItemMaster.class, itemMaster.getId());
            im.setSellingGstPercent(itemMaster.getSellingGstPercent());
            im.setSellingPrice(itemMaster.getSellingPrice());
            im.setFinalSellingPrice(itemMaster.getFinalSellingPrice());
            im.setName(itemMaster.getName());
            im.setHsnCode(itemMaster.getHsnCode());
            
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
    
    public List<ItemMaster> getItemById(ItemMaster itemMaster)
    {
        List<ItemMaster> list = new ArrayList<>();
        
        String query = "FROM ItemMaster WHERE id = " + itemMaster.getId();
        
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
