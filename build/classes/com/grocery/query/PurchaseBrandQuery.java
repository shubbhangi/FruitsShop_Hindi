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

/**
 *
 * @author GanpatiBappa
 */
public class PurchaseBrandQuery {

    public List<ItemMaster> getPurchaseBrandDetails(ItemMaster itemMaster) {
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
    
   }
}
