/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;


import com.grocery.bean.EmployeeMaster;
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
public class EmployeeQuery 
{
    public List<EmployeeMaster> getEmployeeDetails(EmployeeMaster employeeMaster)
    {
        List<EmployeeMaster> list = new ArrayList<>();
        
        String query = "";
        
        if(employeeMaster.getName() != null)
            query = "FROM EmployeeMaster WHERE name = '" + employeeMaster.getName() + "' AND status <> '0'";
        else
            query = "FROM EmployeeMaster WHERE status <> '0' ORDER BY name ASC";
        
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
    
    public void insertEmployee(EmployeeMaster employeeMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(employeeMaster);
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
    
    public List<EmployeeMaster> checkEmployeeMaster(EmployeeMaster employeeMaster)
    {      
           String query = "FROM EmployeeMaster WHERE id <> " + employeeMaster.getId() + " AND name = '" + employeeMaster.getName() + "' AND status <> '0'";
           
           Session session = HibernateUtil.getSessionFactory().openSession();
           List<EmployeeMaster> list = new ArrayList<>();
           
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
    
    public void updateEmployee(EmployeeMaster employeeMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            EmployeeMaster em = (EmployeeMaster)session.load(EmployeeMaster.class, employeeMaster.getId());
            em.setName(employeeMaster.getName());
            em.setStatus(employeeMaster.getStatus());
            em.setContact(employeeMaster.getContact());
            em.setSalary(employeeMaster.getSalary());
            em.setAddress(employeeMaster.getAddress());
            
            session.update(em);
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
    
    public List<EmployeeMaster> getCredentials(EmployeeMaster employeeMaster)
    {
        List<EmployeeMaster> list = new ArrayList<>();
        
        String query = "";
        if(employeeMaster.getPassword() != null)
            query = "FROM EmployeeMaster WHERE username = '" + employeeMaster.getUsername() + "' AND password = '" + employeeMaster.getPassword() + "' AND status <> '0'";
        else
            query = "FROM EmployeeMaster WHERE username = '" + employeeMaster.getUsername() + "' AND status <> '0'";
        
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
    
    public void updatePassword(EmployeeMaster employeeMaster)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            Transaction transaction = session.beginTransaction();
            
            EmployeeMaster em = (EmployeeMaster)session.load(EmployeeMaster.class, employeeMaster.getId());
            em.setPassword(employeeMaster.getPassword());
            
            session.update(em);
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
