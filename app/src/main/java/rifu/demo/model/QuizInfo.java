package rifu.demo.model;

import rifu.demo.entities.QuizOption;
import rifu.demo.entities.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizInfo {
    private String id;
    private String quiz;
    private List<OptionInfo> options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public List<OptionInfo> getOptions() {
        return options;
    }

    public void setOptions(List<OptionInfo> options) {
        this.options = options;
    }

    public static QuizInfo quizToQuizInfo(Quiz quiz) {
        QuizInfo info = new QuizInfo();
        info.setId(quiz.getId());
        info.setQuiz(quiz.getQuiz());
        List<OptionInfo> optionInfos = new ArrayList<>();
        quiz.getOption().forEach(e -> {
            optionInfos.add(OptionToOptionInfo(e));
        });
        info.setOptions(optionInfos);
        return info;
    }

    public static OptionInfo OptionToOptionInfo(QuizOption option) {
        OptionInfo info = new OptionInfo();
        info.setId(option.getId());
        info.setOption(option.getOptionName());
        return info;
    }

    static class OptionInfo {
        private String id;
        private String option;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }
    }
}
