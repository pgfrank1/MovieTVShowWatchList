package pgfrank.persistence;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import pgfrank.entity.User;
import pgfrank.entity.UserMovie;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;

public class UserMovieDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public UserMovie getById(int id) {
        Session session = sessionFactory.openSession();
        UserMovie userMovie = session.get(UserMovie.class, id);
        session.close();
        return userMovie;
    }

/*    public List<UserMovie> getByUserId(User user) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserMovie> q = builder.createQuery(UserMovie.class);
        Root<UserMovie> c = q.from(UserMovie.class);
        q.select(c);
        ParameterExpression<User> p = builder.parameter(User.class);
        return q.where(builder.gt(c.get("user"), p));
    }*/

    public void saveOrUpdate(UserMovie userMovie) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userMovie);
        transaction.commit();
        session.close();
    }


}
