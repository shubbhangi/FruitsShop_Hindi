/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.CustomerDetails;
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
public class WarehoseDetailsQuery123 

{
    public List<CustomerDetails> getCustomerDetails(CustomerDetails warehouseDetails)
    {
        List<CustomerDetails> list = new ArrayList<>();
        
        String query = "";
        
        if(warehouseDetails.getId() != null)
            query = "FROM CustomerDetails WHERE id = " + warehouseDetails.getId();
        else
            if(warehouseDetails.getName()== null)
                query = "FROM CustomerDetails WHERE name <> 'N/A' ORDER BY name ASC";
            else
                if(warehouseDetails.getName()!= null)
                    query = "FROM CustomerDetails WHERE name = '" + warehouseDetails.getName()+ "'";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            session.beginTransaction();
            Query q = session.createQuery(query);
            list = q.list();
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            session.close();
        }
        return list;
    }
    
    
    
    
    
    
    public List<CustomerDetails> getCustomerDetails1(CustomerDetails warehouseDetails)
    {
        List<CustomerDetails> list = new ArrayList<>();
        
        String query = "";
        
        if(warehouseDetails.getName() != null)
            query = "FROM CustomerDetails WHERE name = '" + warehouseDetails.getName()+ "'";
        else
            query = "FROM CustomerDetails WHERE name <> 'N/A' ORDER BY name ASC";
        
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
    
    public void insertWarehouse(CustomerDetails warehouseDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(warehouseDetails);
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
    
    public void updateWarehouse(CustomerDetails warehouseDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            CustomerDetails vm = (CustomerDetails)session.load(CustomerDetails.class, warehouseDetails.getId());
            
           // vm.setRegistration(warehouseDetails.getRegistration());
            vm.setContact(warehouseDetails.getContact());
            vm.setAddress(warehouseDetails.getAddress());
            vm.setBalance(warehouseDetails.getBalance());
           // vm.setTdsNumber(warehouseDetails.getTdsNumber());
            
            session.update(vm);
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
    
    public void updateWarehouseBalance(CustomerDetails warehouseDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            CustomerDetails vm = (CustomerDetails)session.load(CustomerDetails.class, warehouseDetails.getId());
            
            vm.setBalance(warehouseDetails.getBalance());
            
            session.update(vm);
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
    
    public List<CustomerDetails> getWarehouse()
    {
        List<CustomerDetails> list = new ArrayList<>();
        
        String query = "FROM CustomerDetails";
        
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

    public List<CustomerDetails> searchCustomer(CustomerDetails warehouseDetails) 
       {
        List<CustomerDetails> list = new ArrayList<>();
        
        String query = "";
        
        if(warehouseDetails.getName() == null)
            query = "FROM CustomerDetails ORDER BY name ASC";
        else
            query = "FROM CustomerDetails WHERE name LIKE '%" + warehouseDetails.getName()+ "' "
                  + "OR name LIKE '%" + warehouseDetails.getName() + "%' or contact LIKE '%" + warehouseDetails.getName()+ "' "
                  + "OR contact LIKE '%" + warehouseDetails.getName() + "%' ORDER BY name ASC";

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
    
    public List<CustomerDetails> checkWarehouse(CustomerDetails warehouseDetails) {
        List<CustomerDetails> list = new ArrayList<>();

        String query = "FROM CustomerDetails WHERE name = '" + warehouseDetails.getName() + "'"
                + "AND contact = " + warehouseDetails.getContact() + " "
                + "AND address = " + warehouseDetails.getAddress() + "'";
               // + "AND tds_number = " + warehouseDetails.getTdsNumber() + "'";
        
     /*   String query = "FROM CustomerDetails WHERE name = '" + warehouseDetails.getName() + "'"
                + "AND contact = " + warehouseDetails.getContact() + " "
                + "AND address = " + warehouseDetails.getAddress() + " "
                + "AND city = " + warehouseDetails.getCity() + " "
                + "AND state = " + warehouseDetails.getState() + " "
                + "AND pincode = " + warehouseDetails.getPinCode() + " "
                + "AND tds_number = " + warehouseDetails.getTdsNumber() + "'";
             */
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery(query);
            list = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
    
     public List<CustomerDetails> list() {
        List<CustomerDetails> venList = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            venList = session.createQuery("from CustomerDetails").list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return venList;
    }
 public static void deleteFromCustomerDetails(CustomerDetails warehouseDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            CustomerDetails vm = (CustomerDetails) session.load(CustomerDetails.class, warehouseDetails.getId());

           // em.setStatus(warehouseDetails.getStatus());
            // em.setStatus(employeeMaster.getStatus());
            session.delete(vm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
