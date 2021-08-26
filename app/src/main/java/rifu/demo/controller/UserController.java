package rifu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rifu.demo.entities.User;
import rifu.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listChallengers() {
        return userService.listUsers();
    }
}
