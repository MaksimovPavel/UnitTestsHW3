package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> data = new ArrayList<>();

    public UserRepository() {


    }

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutAll() {
        data.removeIf(user -> !user.getIsAdmin());
    }
}