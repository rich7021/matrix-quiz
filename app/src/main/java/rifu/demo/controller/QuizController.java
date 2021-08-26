package rifu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rifu.demo.model.QuizInfo;
import rifu.demo.model.TopicInfo;
import rifu.demo.model.UserInfo;
import rifu.demo.services.QuizService;
import rifu.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    final QuizService quizService;
    final UserService userService;

    @Autowired
    public QuizController(QuizService quizService, UserService userService) {
        this.quizService = quizService;
        this.userService = userService;
    }

    @GetMapping("/topic")
    public List<TopicInfo> getTopics(@RequestParam(name = "user") String userName) {
        UserInfo userInfo = userService.getUserByName(userName);
        List<TopicInfo> topicInfos = quizService.getTopic(userInfo.getId());
        return topicInfos;
    }

    @GetMapping("/{id}")
    public QuizInfo getQuiz(@PathVariable(name = "id") String id) {
        QuizInfo info = quizService.getQuiz(id);
        return info;
    }
}
