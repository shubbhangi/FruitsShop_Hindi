/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.util;

import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.grocery.view.Customer;

/**
 *
 * @author GanpatiBappa
 */
public class SearchDataList {
 
    public void setSearchDetails(JComboBox component, String table, String column) {
       try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            String conn_query = "select " + column + " from " + table+" group by "+column ;
            List list = session.createSQLQuery(conn_query).list();
            ListIterator itr = list.listIterator();
            while (itr.hasNext()) {
                component.addItem(itr.next());
            }
            component.setVisible(true);

            session.close();
            //res.close();
        } catch (HibernateException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSearchDetails(JComboBox<String> gst) {
         for (int i=0; i<=30; i++) {
                gst.addItem(String.valueOf(i));
            }
            gst.setVisible(true);
    }
     
    
      public void setSearchCompany(JComboBox component, String table, String column,String company) {
       try {
            Session session = HibernateUtil.getSessionFactory().openSession();
           // String conn_query = "select " + column + " from " + table +" group by "+column ;
            String conn_query = "select " + column + " from " + table +" where company='"+company+"' group by "+column ;
            List list = session.createSQLQuery(conn_query).list();
            ListIterator itr = list.listIterator();
            while (itr.hasNext()) {
                component.addItem(itr.next());
            }
            component.setVisible(true);

            session.close();
            //res.close();
        } catch (HibernateException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
      
      
    
}
