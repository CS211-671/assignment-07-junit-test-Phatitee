package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
     void testUserListFindUser() {
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        User foundUser = userList.findUserByUsername("user2");

        assertNotNull(foundUser, "User should be found in the list");
        assertEquals("user2", foundUser.getUsername(), "Username should match");
    }

    @Test
    @DisplayName("User can change password")
     void testUserCanChangePassword() {
        UserList userList = new UserList();
        userList.addUser("user1", "password1");

        boolean result = userList.changePassword("user1", "password1", "newPassword");

        assertTrue(result, "Password change should be successful");
        User user = userList.findUserByUsername("user1");
        assertNotNull(user, "User should be found in the list");
        assertTrue(user.validatePassword("newPassword"), "Password should be updated to newPassword");
        assertFalse(user.validatePassword("password1"), "Old password should no longer be valid");
    }

    @Test
    @DisplayName("User with correct password can login")
     void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        User user = userList.login("user2", "password2");

        assertNotNull(user, "User should be returned with correct username and password");
        assertEquals("user2", user.getUsername(), "Username should match");
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
     void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        UserList userList = new UserList();
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        User user = userList.login("user2", "wrongPassword");

        assertNull(user, "User should not be returned with incorrect password");
    }
}
