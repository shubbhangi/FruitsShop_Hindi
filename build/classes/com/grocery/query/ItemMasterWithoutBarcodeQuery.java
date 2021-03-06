/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.ItemMasterWithoutBarcode;
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
public class ItemMasterWithoutBarcodeQuery {

    public List<ItemMasterWithoutBarcode> checkItem(ItemMasterWithoutBarcode itemMasterWithoutBarcode) {

        List<ItemMasterWithoutBarcode> list = new ArrayList<>();
        
         String query = "FROM ItemMasterWithoutBarcode WHERE name = " + itemMasterWithoutBarcode.getName(); 
         
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
    
    public void insertItem(ItemMasterWithoutBarcode itemMasterWithoutBarcode)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(itemMasterWithoutBarcode);
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
    
