/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.ItemAvailabilityPurchase;
import com.grocery.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author GanpatiBappa
 */
public class ItemAvailabilityPurchaseQuery {

    public List<Object[]> getWeightAvailability(ItemAvailabilityPurchase itemAvailabilityPurchase) {
   {
        List<Object[]> list = new ArrayList<>();
        
        String query = "";
        
         query = "FROM ItemAvailabilityPurchase ia JOIN ia.purchaseMaster im WHERE im.name = '" + itemAvailabilityPurchase.getPurchaseMaster().getName()+ "' ";
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
    public List<ItemAvailabilityPurchase> checkItem(ItemAvailabilityPurchase itemAvailabilityPurchase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateItemAvailability(ItemAvailabilityPurchase itemAvailabilityPurchase) {
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            session.beginTransaction();
           // Transaction transaction = session.beginTransaction();
            ItemAvailabilityPurchase ia = (ItemAvailabilityPurchase)session.load(ItemAvailabilityPurchase.class, itemAvailabilityPurchase.getId());
           
			//ItemAvailability ia = (ItemAvailability)session.load(ItemAvailability.class, iAvailability.getId());
            ia.setAvailability(itemAvailabilityPurchase.getAvailability());
            if(itemAvailabilityPurchase.getThreshold() != null)
                ia.setThreshold(itemAvailabilityPurchase.getThreshold());
            
            session.update(ia);
           // transaction.commit();
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
}