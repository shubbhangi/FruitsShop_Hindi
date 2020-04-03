/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.StoreDetails;
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
public class StoreDetailsQuery {
    
    
    public List<StoreDetails> getStoreDetails()
    {
        List<StoreDetails> list = new ArrayList<>();
        
        String query = "FROM StoreDetails";
        
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
    
    public void updateStoreDetails(StoreDetails storeDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            StoreDetails sd = (StoreDetails)session.load(StoreDetails.class, storeDetails.getId());
            
            sd.setName(storeDetails.getName());
            sd.setAddress(storeDetails.getAddress());
            sd.setCity(storeDetails.getCity());
            sd.setState(storeDetails.getState());
            sd.setPincode(storeDetails.getPincode());
            sd.setPhone(storeDetails.getPhone());
            sd.setGstNumber(storeDetails.getGstNumber());
            sd.setEmail(storeDetails.getEmail());
            sd.setWebsite(storeDetails.getWebsite());
            
            if(storeDetails.getPhoto() != null)
                sd.setPhoto(storeDetails.getPhoto());
            
            session.update(sd);
            transaction.commit();
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            session.close();
        }
        
    }
}
