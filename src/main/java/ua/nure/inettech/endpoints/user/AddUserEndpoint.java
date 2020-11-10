package ua.nure.inettech.endpoints.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.nure.inettech.entity.User;
import ua.nure.inettech.entity.Users;
import ua.nure.inettech.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AddUserEndpoint {
    private static final String NAMESPACE_URI = "http://inettech.nure.ua";

    private UserRepository userRepository;

    @Autowired
    public AddUserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddUser")
    @ResponsePayload
    public Users addNewUser(@RequestPayload User user) {
        List<User> userList = new ArrayList<>();
        userList.add(userRepository.addUser(user));
        Users users = new Users();
        users.setUser(userList);
        return users;
    }
}
