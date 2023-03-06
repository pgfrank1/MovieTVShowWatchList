package persistence;

import pgfrank.entity.User;
import pgfrank.persistence.UserDao;
import util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void getByUserId() {
        assertEquals("Patrick", userDao.getUserById(1).getFirstName());
    }
    @Test
    void testInsertUser() {
        user = new User("testUsername", "testPassword", "/testPhotoLocationUnitTest", "Unit", "Testing");
        int id = userDao.insertUser(user);
        assertNotEquals(0, id);
        User insertedUser = userDao.getUserById(id);
        assertEquals("Unit", insertedUser.getFirstName());
        assertEquals("Testing", insertedUser.getLastName());
    }

    @Test
    void updateSuccess() {
        user = userDao.getUserById(1);
        user.setFirstName("Update");
        user.setLastName("Test");
        userDao.saveOrUpdateUser(user);

        User userToCheck = userDao.getUserById(1);
        assertEquals(user.getFirstName(), userToCheck.getFirstName());
        assertEquals(user.getLastName(), userToCheck.getLastName());
    }

    //TODO: Error occurred validating the Criteria, IllegalArgumentException
    @Test
    void getAllUsers() {
        List<User> users = userDao.getAllUsers();

    }

    //TODO: not currently working. Cascading is very strange
    @Test
    void deleteSuccess() {
        userDao.deleteUser(userDao.getUserById(1));
        assertNull(userDao.getUserById(1));
    }
}
