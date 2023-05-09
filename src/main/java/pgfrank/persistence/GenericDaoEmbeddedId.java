package pgfrank.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDaoEmbeddedId<T,E> extends GenericDao {

    public GenericDaoEmbeddedId(Class<T> type, Class<E> embeddedId) {
        super(type);
    }
    public <E> T getTypeByEmbeddedId(E embeddedId) {
        Session session = getSession();
        T entity = (T) session.find(super.getType(), embeddedId);
        getLogger().info("Getting "+ super.getType() + " from database via ID: " + embeddedId);
        session.close();
        return entity;
    }
    public <E> T addTypeByEmbeddedId(E embeddedId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        T entity = (T) session.save(super.getType().getName(), embeddedId);
        getLogger().info("Adding "+ super.getType() + " to database via ID: " + embeddedId);
        transaction.commit();
        session.close();
        return entity;
    }
    public void deleteTypeByEmbeddedID(E embeddedId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(super.getType().getName(), embeddedId);
        getLogger().info("Adding "+ super.getType() + " to database via ID: " + embeddedId);
        transaction.commit();
        session.close();

    }
}
