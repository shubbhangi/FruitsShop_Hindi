/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.ItemAvailability;
import com.grocery.util.DateUtil;
import com.grocery.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author GanpatiBappa
 */
public class AlertTableQuery {
    
    public List<Object[]> getAvailability(ItemAvailability itemAvailability)
    {
     List<Object[]> list = new ArrayList<>();
        
        String query = "";
        
//        if(itemAvailability.getItemMaster().getName() == null)
//           query = "FROM ItemAvailability ia JOIN ia.itemMaster im ORDER BY im.name ASC";
            
         query = "SELECT im.name, im.barCode, ia.availability , im.unitPrice, im.efgDate, im.expDate "
                     + "FROM item_availability ia JOIN item_master im "
                     + "WHERE im.expDate <= NOW() + INTERVAL 15 DAY AND im.expDate >= NOW()";
        
        
//             query = "SELECT im.name, im.hsnCode, ia.availability , im.unitPrice, im.efgDate, im.expDate "
//                     + "FROM ItemAvailability ia JOIN ia.itemMaster im "
//                     + "WHERE im.expDate <= "+DateUtil.getLastMonthLastDay() +" 23:59:59 AND im.expDate >= " + DateUtil.getLastMonthFirstDay() +" 00:00:00";

//         "select count(id) from Inventory where type=1 and agent.id=:userId and openTime>=:startTime and openTime<=:endTime")
//                .setString("startTime", DateUtil.getLastMonthFirstDay()+" 00:00:00")
//                .setString("endTime", DateUtil.getLastMonthLastDay()+" 23:59:59")
//                .setParameter("userId", user.id)
//                .uniqueResult()    

//        else
//            query = "FROM ItemAvailability ia JOIN ia.itemMaster im WHERE im.name LIKE '%" + itemAvailability.getItemMaster().getName() + "' "
//                  + "OR im.name LIKE '%" + itemAvailability.getItemMaster().getName() + "%' ORDER BY im.name ASC";
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
