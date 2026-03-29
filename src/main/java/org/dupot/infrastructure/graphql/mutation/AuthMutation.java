package org.dupot.graphql.infrastructure.graphql.mutation;

import org.dupot.domain.entity.User;
import org.dupot.infrastructure.model.UserModel;
import org.dupot.infrastructure.security.JwtUtil;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthMutation {

    private final UserModel userModel = new UserModel();

    @MutationMapping
    public String login(@Argument String login, @Argument String password) {
        List<User> users = userModel.getListByLogin(login);
        if (users.isEmpty() || !UserModel.checkPassword(password, users.get(0).passwordHashed())) {
            throw new RuntimeException("Invalid credentials");
        }
        return JwtUtil.generateToken(users.get(0).id());
    }
}
