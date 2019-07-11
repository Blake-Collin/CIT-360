package com.HibernateExample;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
  SessionFactory factory = null;
  Session session = null;

  private static Test single_instance = null;

  public static Test getInstance() {
    if (single_instance == null) {
      single_instance = new Test();
    }
    return single_instance;
  }

  public Test() {
    factory = HibernateUtils.getSessionFactory();
  }

  public List<Customer> getCustomers() {
    try {
      session = factory.openSession();
      session.getTransaction().begin();
      String sql = "from com.HibernateExample.Customer";
      List<Customer> clist = (List<Customer>) session.createQuery(sql).getResultList();
      session.getTransaction().commit();
      return clist;
    } catch (Exception e) {
      System.err.println("Error in Test: " + e);
      session.getTransaction().rollback();
      return null;
    } finally {
      session.close();
    }
  }

  public Customer getCustomer(int id) {
    try {
      session = factory.openSession();
      session.getTransaction().begin();
      String sql = "from com.HibernateExample.Customer where id=" + id;
      Customer customer = (Customer) session.createQuery(sql).getSingleResult();
      session.getTransaction().commit();
      return customer;
    } catch (Exception e) {
      System.err.println("Error in Test: " + e);
      session.getTransaction().rollback();
      return null;
    } finally {
      session.close();
    }
  }

  public int getRowCount() {
    try {
      session = factory.openSession();
      session.getTransaction().begin();
      String sql = "from com.HibernateExample.Customer";
      int count = session.createQuery(sql).getResultList().size();
      session.getTransaction().commit();
      return count;
    } catch (Exception e) {
      System.err.println("Error in Test: " + e);
      session.getTransaction().rollback();
      return 0;
    } finally {
      session.close();
    }
  }

  public void addCustomer(int id, String name, String address, String phone) {
    try {
      session = factory.openSession();
      session.getTransaction().begin();

      Customer customer  = new Customer();
      customer.setId(id);
      customer.setName(name);
      customer.setAddress(address);
      customer.setPhone(phone);

      session.saveOrUpdate(customer);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.err.println("Error in Test: " + e);
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
  }

}
