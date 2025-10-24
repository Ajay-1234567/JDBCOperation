package dao;

import model.User;

public class UserDao {
    // Dummy database logic
    public boolean validate(User user) {
        return "admin".equals(user.getUsername()) && "1234".equals(user.getPassword());
    }
}
