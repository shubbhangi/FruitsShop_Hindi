/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query1;

import com.grocery.bean.ItemMaster;
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
public class ItemQueryNew {

    public List<ItemMaster> checkItem(ItemMaster itemMaster) {
        List<ItemMaster> list = new ArrayList<>(); 
        String query = "FROM ItemMaster WHERE name = '" + itemMaster.getName() + "' "
                +      "AND unitPrice = " + itemMaster.getUnitPrice() + " "
                +      "AND gstPercent = " + itemMaster.getGstPercent() + " "
                +      "AND sellingPrice = " + itemMaster.getSellingPrice() + " "
              //  +      "AND sellingGstPercent = " + itemMaster.getGstPercent() + " "
                +      "AND barCode = '" + itemMaster.getBarCode()+ "'"
                +      "AND gstType = '" + itemMaster.getGstType()+ "'"
                
                +      "AND efgDate = '" + itemMaster.getEfgDate()+ "'"
                +      "AND expDate = '" + itemMaster.getExpDate()+ "'";
        
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

    public void insertItem(ItemMaster itemMaster) {
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

}