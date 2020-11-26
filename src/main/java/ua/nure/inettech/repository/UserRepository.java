package ua.nure.inettech.repository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import ua.nure.inettech.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<User>(users.values());
        return userList;
    }

    public User addUser(User user){
        Assert.notNull(user, "Объект должен быть не пустым");
        users.put(user.getUserName(), user);
        return user;
    }
}
