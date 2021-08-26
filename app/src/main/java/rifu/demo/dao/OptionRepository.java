package rifu.demo.dao;


import org.springframework.data.repository.CrudRepository;
import rifu.demo.entities.QuizOption;

public interface OptionRepository extends CrudRepository<QuizOption, String> {
}
