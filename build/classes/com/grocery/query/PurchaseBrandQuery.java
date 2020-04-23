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

/**
 *
 * @author GanpatiBappa
 */
public class PurchaseBrandQuery {

    public List<PurchaseMaster> getPurchaseBrandDetails(PurchaseMaster purchaseMaster) {
      {
     
        List<PurchaseMaster> list = new ArrayList<>();
        
        String query = "";

        if(purchaseMaster.getName() != null)
            query = "FROM PurchaseMaster WHERE brand = '" + purchaseMaster.getBrand()+ "'";
        else
            query = "FROM PurchaseMaster WHERE brand <> 'N/A' ORDER BY brand ASC";
        
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
    public List<PurchaseMaster> getItemDetails2(PurchaseMaster purchaseMaster) 
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
