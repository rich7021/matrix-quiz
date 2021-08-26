package rifu.demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rifu.demo.entities.User;

import java.util.List;

@SpringBootTest
class ChallengerControllerTest {

    @Autowired
    private UserController challengerController;

    @Test
    void listChallengers() {
        List<User> challengers = challengerController.listChallengers();

        Assertions.assertEquals(3, challengers.size());
    }
}