package pl.coderslab.tdd;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<Integer, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void createNewUser(User user) {
        this.users.put(user.getId(), user);
    }


    public User findUserById(int userId) {
        return this.users.get(userId);
    }

    public void deleteUserById(int deletedUserId) {
        this.users.remove(deletedUserId);
    }

    public void updateUser(User user) {
        User oldUser = this.users.get(user.getId());
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
    }
}
