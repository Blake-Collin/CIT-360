package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ebay.eBayRecord;

public class HibernateHandler {

  private SessionFactory factory = null;
  private Session session = null;
  private static HibernateHandler single_instance = null;

  public static HibernateHandler getInstance() {
    if (single_instance == null) {
      single_instance = new HibernateHandler();
    }
    return single_instance;
  }

  public HibernateHandler() {
    factory = HibernateUtils.getSessionFactory();
  }

  public eBayRecord getRecord(String searchPhrase) {
    try {
      session = factory.openSession();
      session.getTransaction().begin();
      String sql = "from ebay.eBayRecord where id=" + searchPhrase;
      eBayRecord record = (eBayRecord) session.createQuery(sql).getSingleResult();
      session.getTransaction().commit();
      return record;
    } catch (Exception e) {
      System.err.println("Error in Test: " + e);
      session.getTransaction().rollback();
      return null;
    } finally {
      session.close();
    }
  }

  public boolean containsRecord(String searchPhrase) {
//    session = factory.openSession();
//    Query query = session.createQuery("from ebay.eBayRecord where id=" + searchPhrase);
//    return (query.uniqueResult() != null);

    return false;
  }

  public void addRecord(eBayRecord ebayRecord) {
    try {
      session = factory.openSession();
      session.getTransaction().begin();

      session.save(ebayRecord);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.err.println("Error in Test: " + e);
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
  }

  public void updateRecord(eBayRecord ebayRecord) {
    try {
      session = factory.openSession();
      session.getTransaction().begin();

      session.update(ebayRecord);
      session.getTransaction().commit();
    } catch (Exception e) {
      System.err.println("Error in Test: " + e);
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
  }
}
