package rifu.demo.dao;


import org.springframework.data.repository.CrudRepository;
import rifu.demo.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findAllByActiveEquals(boolean active);

    Optional<User> findAllByNameEqualsAndActiveEquals(String name, boolean active);
}
