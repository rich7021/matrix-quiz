package rifu.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rifu.demo.dao.QuizRepository;
import rifu.demo.entities.Quiz;
import rifu.demo.exception.ResourceNotFoundException;
import rifu.demo.model.QuizInfo;
import rifu.demo.model.TopicInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    final QuizRepository quizRepository;

    public QuizService(@Autowired QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<TopicInfo> getTopic(String userId) {
        List<Quiz> quizzes = quizRepository.findAllByUser_Id(userId);
        List<TopicInfo> topics = new ArrayList<>();
        quizzes.forEach(e -> {
            TopicInfo info = TopicInfo.quizToTopicInfo(e);
            topics.add(info);
        });
        return topics;
    }

    public QuizInfo getQuiz(String id) {
        Optional<Quiz> opt = quizRepository.findById(id);
        Quiz quiz = opt.orElseThrow(ResourceNotFoundException::new);
        QuizInfo info = QuizInfo.quizToQuizInfo(quiz);
        return info;
    }
}
