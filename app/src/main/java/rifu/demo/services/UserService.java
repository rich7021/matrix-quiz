package rifu.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifu.demo.dao.UserRepository;
import rifu.demo.entities.User;
import rifu.demo.exception.ResourceNotFoundException;
import rifu.demo.model.UserInfo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers() {
        return userRepository.findAllByActiveEquals(true);
    }

    public UserInfo getUserByName(String name) {
        Optional<User> opt = userRepository.findAllByNameEqualsAndActiveEquals(name, true);
        User user = opt.orElseThrow(ResourceNotFoundException::new);
        UserInfo info = new UserInfo(user.getId(), user.getName());
        return info;
    }
}
