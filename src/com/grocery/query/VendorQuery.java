/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.query;

//import com.grocery.bean.VendorMaster;
import com.grocery.bean.VendorBillMaster;
import com.grocery.bean.VendorMaster;
import com.grocery.bean.VendorPartialPayment;
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
            session.saveOrUpdate(vendorMaster);
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

    public List<VendorMaster> searchVendor(VendorMaster vendorMaster) 
       {
        List<VendorMaster> list = new ArrayList<>();
        
        String query = "";
        
        if(vendorMaster.getName() == null)
            query = "FROM VendorMaster ORDER BY name ASC";
        else
            query = "FROM VendorMaster WHERE name LIKE '%" + vendorMaster.getName()+ "' "
                  + "OR name LIKE '%" + vendorMaster.getName() + "%' or contact LIKE '%" + vendorMaster.getName()+ "' "
                  + "OR contact LIKE '%" + vendorMaster.getName() + "%' ORDER BY name ASC";

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
    
    public List<VendorMaster> checkVendor(VendorMaster vendorMaster) {
        List<VendorMaster> list = new ArrayList<>();

        String query = "FROM VendorMaster WHERE name = '" + vendorMaster.getName() + "'"
                + "AND contact = " + vendorMaster.getContact() + " "
                + "AND address = " + vendorMaster.getAddress() + " "
                + "AND gstNumber = " + vendorMaster.getGstNumber() + "'";
        
     /*   String query = "FROM VendorMaster WHERE name = '" + vendorMaster.getName() + "'"
                + "AND contact = " + vendorMaster.getContact() + " "
                + "AND address = " + vendorMaster.getAddress() + " "
                + "AND city = " + vendorMaster.getCity() + " "
                + "AND state = " + vendorMaster.getState() + " "
                + "AND pincode = " + vendorMaster.getPinCode() + " "
                + "AND gstNumber = " + vendorMaster.getGstNumber() + "'";
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
    
     public List<VendorMaster> list() {
        List<VendorMaster> venList = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            venList = session.createQuery("from VendorMaster").list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return venList;
    }
 public static void deleteFromVendorMaster(VendorMaster vendorMaster) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            VendorMaster vm = (VendorMaster) session.load(VendorMaster.class, vendorMaster.getId());

           // em.setStatus(vendorMaster.getStatus());
            // em.setStatus(employeeMaster.getStatus());
            session.delete(vm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
 public VendorMaster getVendorBillDetailsByVendorIdAndDateAndBillAmount(int vendorId, String date, String totalAmount) {

        List<VendorMaster> list = new ArrayList<VendorMaster>();
        List<VendorMaster> itr = new ArrayList<VendorMaster>();
        String query = "from VendorMaster WHERE id = '" + vendorId + "'";
                

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            list= (List<VendorMaster>)session.createQuery(query).list();
            
         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }

    }

  public VendorMaster getVendorByName(String name) {
        List<VendorMaster> vendorList = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            vendorList = session.createQuery("from VendorMaster where name = '" + name + "'").list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return vendorList.get(0);
    }


     public void insertVendorBillDetails(VendorPartialPayment vendorPartialPayment) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(vendorPartialPayment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public VendorMaster getVendorBiVendorMasterllDetailsByVendorIdAndDateAndBillAmount(Integer id, String date, String totalamount1) {
     List<VendorMaster> list = new ArrayList<VendorMaster>();
        List<VendorMaster> itr = new ArrayList<VendorMaster>();
        String query = "from VendorMaster WHERE id = '" + id + "'";
                

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            list= (List<VendorMaster>)session.createQuery(query).list();
            
         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }

    }

    public void insertVendor(VendorPartialPayment vendorPartialPayment) {
      Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(vendorPartialPayment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void savePaymentDetails(VendorPartialPayment vendorPartialPayment) {
       Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(vendorPartialPayment);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
}

    public void insertVendorBillDetails(VendorBillMaster vendorMaster) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(vendorMaster);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void insertVendorMaster(VendorMaster vendorMaster) {
      Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vendorMaster);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }  
    
    }

    public void insertVendorMaster(VendorBillMaster vendorBillMaster) {
      Session session = HibernateUtil.getSessionFactory().openSession();
         
         try
         {
             Transaction transaction = session.beginTransaction();
             session.save(vendorBillMaster);
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