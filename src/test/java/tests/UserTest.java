package tests;

import org.example.model.BaseResponse;
import org.example.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class UserTest extends BaseTest {
    @Test(priority = 1)
    public void createUserTest() {
        User newUser = new User(1, "Bob", "Bob1", "Bob2", "Bob@bob.bob", "BobBOB123", "+7999563821", 0);
        BaseResponse model = USER_API.createUser(newUser);
        Assert.assertEquals(model.getCode(), "200");
    }
    @Test(priority = 2)
    public void getUserByUserNameTest() {
        User model = USER_API.getUserByUserName("Bob");
        Assert.assertEquals(model.getUsername(), "Bob");
    }
    @Test (priority = 3)
    public void updateUserTest() {
        User newUser = new User(1, "Bob", "Bob1", "Bob2", "Bob@bob.bob", "123", "+7999563821", 0);
        BaseResponse model = USER_API.updateUser(newUser);
        Assert.assertEquals(model.getCode(), "200");
    }
    @Test (priority = 4)
    public void deleteUserTest() {
        BaseResponse model = USER_API.deleteUser("Bob");
        Assert.assertEquals(model.getCode(), "200");
    }
    @Test (priority = 5)
    public void loginUserTest() {
        BaseResponse model = USER_API.loginUser("Bob", "123");
        Assert.assertEquals(model.getCode(), "200");
    }

    @Test (priority = 6)
    public void logoutUserTest() {
        BaseResponse model = USER_API.logoutUser();
        Assert.assertEquals(model.getCode(), "200");
    }
    @Test (priority = 7)
    public void createWithListUsersTest() {
        User newUser = new User(1, "Bob1", "Bob1", "Bob2", "Bob@bob.bob", "123", "+7999563821", 0);
        List<User> users = new LinkedList<>();
        users.add(newUser);
        BaseResponse model = USER_API.createListUsers(users);
        Assert.assertEquals(model.getCode(), "200");
    }
}
