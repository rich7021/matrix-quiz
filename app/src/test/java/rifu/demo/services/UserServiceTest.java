package rifu.demo.services;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import rifu.demo.dao.UserRepository;
import rifu.demo.entities.User;
import rifu.demo.model.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void listChallengers() {
        List<User> mockUsers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.format("id%d", i));
            user.setName(String.format("name%d", i));
            user.setActive(true);
            mockUsers.add(user);
        }
        Mockito.when(userRepository.findAllByActiveEquals(true)).thenReturn(mockUsers);

        List<User> results = userService.listUsers();

        Assertions.assertEquals(mockUsers.size(), results.size());
    }

    @Test
    void getUserByName() {
        String id = RandomString.make(36);
        String name = "jackson";
        User mockUser = new User();
        mockUser.setId(id);
        mockUser.setName(name);
        Mockito.when(userRepository.findAllByNameEqualsAndActiveEquals(anyString(), anyBoolean())).thenReturn(Optional.of(mockUser));

        UserInfo info = userService.getUserByName(name);

        Assertions.assertEquals(id, info.getId());
        Assertions.assertEquals(name, info.getName());
    }
}