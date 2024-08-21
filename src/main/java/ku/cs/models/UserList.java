package ku.cs.models;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.isUsername(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String username, String password) {
        User exist = findUserByUsername(username);
        if (exist == null) {
            users.add(new User(username, password));
        }
    }

    /**
     * Changes the user's password if the old password is correct.
     * @param username the username of the user
     * @param oldPassword the current password of the user
     * @param newPassword the new password to be set
     * @return true if the password was changed successfully, false otherwise
     */
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = findUserByUsername(username);
        if (user != null && user.validatePassword(oldPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    /**
     * Logs in a user by verifying the username and password.
     * @param username the username of the user
     * @param password the password of the user
     * @return the User object if the username and password are correct, null otherwise
     */
    public User login(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null && user.validatePassword(password)) {
            return user;
        }
        return null;
    }
}
