package org.dupot.infrastructure.model;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.dupot.domain.entity.User;

public class UserModel {

    private List<User> userList = Arrays.asList(
        new User(1, "login1@mail.com", UserModel.hashPassword("myPassword")),
        new User(2, "login2@mail.com", UserModel.hashPassword("myPassword2"))
        
    );

    public User getById(int id) {
        return userList.stream()
                .filter(user -> user.id() == id)
                .findFirst().orElse(null); 

    }

    public List<User> getListByLogin(String login) {
        return userList.stream()
                .filter(user -> user.login().equals(login))
                .collect(Collectors.toList()); 

    }

    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}