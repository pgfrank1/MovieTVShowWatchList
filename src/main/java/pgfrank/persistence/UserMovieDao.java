package pgfrank.persistence;

import pgfrank.entity.User;
import pgfrank.entity.UserMovie;
import org.apache.logging.log4j.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserMovieDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public UserMovie getById(int id) {
        Session session = sessionFactory.openSession();
        UserMovie userMovie = session.get(UserMovie.class, id);
        session.close();
        return userMovie;
    }

    public UserMovie getByUserId(User user) {
        Session session = sessionFactory.openSession();
        UserMovie userMovie = session.get(UserMovie.class, user);
        session.close();
        return userMovie;
    }

    public void saveOrUpdate(UserMovie userMovie) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(userMovie);
        transaction.commit();
        session.close();
    }


}
