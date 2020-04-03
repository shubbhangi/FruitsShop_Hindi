/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

import com.grocery.bean.VendorMaster;
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
public class VendorQuery 
{
    public List<VendorMaster> getVendorDetails(VendorMaster vendorMaster)
    {
        List<VendorMaster> list = new ArrayList<>();
        
        String query = "";
        
        if(vendorMaster.getName() != null)
            query = "FROM VendorMaster WHERE name = '" + vendorMaster.getName() + "'";
        else
            query = "FROM VendorMaster WHERE name <> 'N/A' ORDER BY name ASC";
        
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
    
    public void insertVendor(VendorMaster vendorMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(vendorMaster);
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
    
    public void updateVendor(VendorMaster vendorMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            VendorMaster vm = (VendorMaster)session.load(VendorMaster.class, vendorMaster.getId());
            
            vm.setRegistration(vendorMaster.getRegistration());
            vm.setContact(vendorMaster.getContact());
            vm.setAddress(vendorMaster.getAddress());
            vm.setBalance(vendorMaster.getBalance());
            vm.setGstNumber(vendorMaster.getGstNumber());
            
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
    
    public void updateVendorBalance(VendorMaster vendorMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            VendorMaster vm = (VendorMaster)session.load(VendorMaster.class, vendorMaster.getId());
            
            vm.setBalance(vendorMaster.getBalance());
            
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
    
    public List<VendorMaster> getVendor()
    {
        List<VendorMaster> list = new ArrayList<>();
        
        String query = "FROM VendorMaster";
        
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
