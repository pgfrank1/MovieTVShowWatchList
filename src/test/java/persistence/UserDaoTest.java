package persistence;

import pgfrank.entity.user.User;
import pgfrank.persistence.GenericDao;
import util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    User user;
    List<User> users;
    GenericDao<User> dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("SetupDatabaseTest.sql");
        dao = new GenericDao<>(User.class);
        users = dao.getAll();
    }
    @Test
    void getByUserId() {
        User user1 = dao.getTypeById(1);
        assertEquals("Patrick", user1.getFirstName());
    }
    @Test
    void getByColumnValue() {
        String firstName = "";
        for (User getUser : dao.getAll()) {
            if (getUser.getFirstName().equals("Patrick")) {
                firstName = getUser.getFirstName();
            }
        }
        assertEquals("Patrick", firstName);
    }
    @Test
    void testInsertUser() {
        user = new User("testUserName", "/testPhotoLocation", "Test", "User");
        int id = dao.insertType(user).getId();
        assertNotEquals(0, id);
        User insertedUser = dao.getTypeById(id);
        assertEquals("Test", insertedUser.getFirstName());
        assertEquals("User", insertedUser.getLastName());
    }

    @Test
    void updateSuccess() {
        user = dao.getTypeById(1);
        user.setFirstName("Update");
        user.setLastName("Test");
        dao.saveOrUpdateType(user);

        User userToCheck = dao.getTypeById(1);
        assertEquals(user.getFirstName(), userToCheck.getFirstName());
        assertEquals(user.getLastName(), userToCheck.getLastName());
    }

    @Test
    void getAllUsers() {
        assertEquals(2, users.size());
    }

    @Test
    void deleteSuccess() {
        dao.deleteType(dao.getTypeById(1));
        List<User> users = dao.getAll();
        assertEquals(users.size(), 1);
    }
}
