package rifu.demo.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.util.Streamable;
import rifu.demo.entities.Quiz;
import rifu.demo.entities.QuizOption;

@SpringBootTest
class OptionRepositoryTest {

    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Disabled("test for testing msyql, so disabled")
    @Test
    void save() {
        Iterable<Quiz> quizzes = quizRepository.findAll();
        Quiz quiz = Streamable.of(quizzes).toList().get(0);

        QuizOption option = new QuizOption();
        option.setOptionName("中文測試，找不到是哪段出問題");
        option.setAnswer(false);
        option.setQuiz(quiz);
        optionRepository.save(option);

        Iterable<QuizOption> options = optionRepository.findAll();

        options.forEach(o -> {
            System.out.println(o.getOptionName());
        });
    }
}