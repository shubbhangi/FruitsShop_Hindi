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
 * @author GanpatiBappa
 */
public class CustomerDetailsQuery {
    
  public List<CustomerDetails> getCustomerDetails(CustomerDetails customerDetails) {
   // public List<CustomerDetails> getCustomerDetails(CustomerDetails customerDetails)
    {
        List<CustomerDetails> list = new ArrayList<>();
        
        String query = "";
        
        if(customerDetails.getName()!= null)
            query = "FROM CustomerDetails WHERE name = '" + customerDetails.getName()+ "'";
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
  }
    public void insertVendor(CustomerDetails customerDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(customerDetails);
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
    
    public void updateCustomer(CustomerDetails customerDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            CustomerDetails vm = (CustomerDetails)session.load(CustomerDetails.class, customerDetails.getId());
            
           // vm.setRegistration(customerDetails.getRegistration());
            vm.setContact(customerDetails.getContact());
            vm.setAddress(customerDetails.getAddress());
            vm.setBalance(customerDetails.getBalance());
            
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
    
    public void updateCustomerBalance(CustomerDetails customerDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            CustomerDetails vm = (CustomerDetails)session.load(CustomerDetails.class, customerDetails.getId());
            
            vm.setBalance(customerDetails.getBalance());
            
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
    
    public List<CustomerDetails> getVendor()
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

    public List<CustomerDetails> searchVendor(CustomerDetails customerDetails) 
       {
        List<CustomerDetails> list = new ArrayList<>();
        
        String query = "";
        
        if(customerDetails.getName()== null)
            query = "FROM CustomerDetails ORDER BY name ASC";
        else
            query = "FROM CustomerDetails WHERE name LIKE '%" + customerDetails.getName()+ "' "
                  + "OR name LIKE '%" + customerDetails.getName()+ "%' or contact LIKE '%" + customerDetails.getName()+ "' "
                  + "OR contact LIKE '%" + customerDetails.getName()+ "%' ORDER BY name ASC";

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
    
    public List<CustomerDetails> checkVendor(CustomerDetails customerDetails) {
        List<CustomerDetails> list = new ArrayList<>();

        String query = "FROM CustomerDetails WHERE name = '" + customerDetails.getName()+ "'"
                + "AND contact = " + customerDetails.getContact() + " "
                + "AND address = " + customerDetails.getAddress() + "'";
               
        
     /*   String query = "FROM CustomerDetails WHERE name = '" + customerDetails.getName() + "'"
                + "AND contact = " + customerDetails.getContact() + " "
                + "AND address = " + customerDetails.getAddress() + " "
                + "AND city = " + customerDetails.getCity() + " "
                + "AND state = " + customerDetails.getState() + " "
                + "AND pincode = " + customerDetails.getPinCode() + " "
                + "AND gstNumber = " + customerDetails.getGstNumber() + "'";
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
      public void insertCustomer(CustomerDetails customerDetails)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(customerDetails);
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
 public static void deleteFromCustomerDetails(CustomerDetails customerDetails) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            CustomerDetails vm = (CustomerDetails) session.load(CustomerDetails.class, customerDetails.getId());

           // em.setStatus(customerDetails.getStatus());
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