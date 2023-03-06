package persistence;

import pgfrank.entity.User;
import pgfrank.persistence.UserDao;
import util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    private User user;
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");
        userDao = new UserDao();
    }
    @Test
    void getById() {
        assertEquals("Patrick", userDao.getById(1).getFirstName());
    }

    @Test
    void insert() {
        user = new User("testUsername", "testPassword", "/testPhotoLocationUnitTest", "Unit", "Testing");
        int id = userDao.insert(user);
        assertNotEquals(0, id);
        User insertedUser = userDao.getById(id);
        assertEquals("Unit", insertedUser.getFirstName());
        assertEquals("Testing", insertedUser.getLastName());
    }

    @Test
    void updateSuccess() {
        user = userDao.getById(1);
        user.setFirstName("Update");
        user.setLastName("Test");
        userDao.saveOrUpdate(user);

        User userToCheck = userDao.getById(1);
        assertEquals(user.getFirstName(), userToCheck.getFirstName());
        assertEquals(user.getLastName(), userToCheck.getLastName());
    }

    @Test
    void deleteSuccess() {
        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }
}
