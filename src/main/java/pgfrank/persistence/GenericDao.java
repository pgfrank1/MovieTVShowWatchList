package pgfrank.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    public <T> T getTypeById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        logger.info("Getting User from database via ID: " + id);
        session.close();
        return entity;
    }

    public List<T> getByPropertyValue(String propertyValue, Object value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyValue), value));

        return session.createQuery(query).getResultList();
    }

    public int insertType(T entity) {
        int id;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    public void saveOrUpdateType(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    public void deleteType(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        //DON'T REMOVE, YOU NEED THIS
        Root<T> root = query.from(type);
        //
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }
    Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    public Logger getLogger() {
        return logger;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }
}
