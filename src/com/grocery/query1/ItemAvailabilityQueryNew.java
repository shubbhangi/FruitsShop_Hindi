/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query1;

import com.grocery.bean.ItemAvailability;
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
public class ItemAvailabilityQueryNew {

    public List<ItemAvailability> checkItem(ItemAvailability itemAvailability) {
    
        List<ItemAvailability> list = new ArrayList<>();
        
        String query = "FROM ItemAvailability WHERE itemMaster = " + itemAvailability.getItemMaster().getId();
        
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

    public void insertIntoItemAvailability(ItemAvailability itemAvailability) {
     Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(itemAvailability);
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

    public void updateItemAvailability(ItemAvailability itemAvailability) {
      
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            ItemAvailability ia = (ItemAvailability)session.load(ItemAvailability.class, itemAvailability.getId());
            ia.setAvailability(itemAvailability.getAvailability());
            if(itemAvailability.getThreshold() != null)
                ia.setThreshold(itemAvailability.getThreshold());
            
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
}
