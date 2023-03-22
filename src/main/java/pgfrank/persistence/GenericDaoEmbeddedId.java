package pgfrank.persistence;

import org.hibernate.Session;

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
}
