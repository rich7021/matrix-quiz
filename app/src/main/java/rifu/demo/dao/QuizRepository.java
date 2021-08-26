package rifu.demo.dao;

import org.springframework.data.repository.CrudRepository;
import rifu.demo.entities.Quiz;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz, String> {
    List<Quiz> findAllByUser_Id(String id);
}
