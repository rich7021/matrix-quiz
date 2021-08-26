package rifu.demo.model;

import rifu.demo.entities.QuizOption;

public class OptionAnswerInfo {
    private String id;
    private boolean answer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public static OptionAnswerInfo optionToAnswerInfo(QuizOption option) {
        OptionAnswerInfo answerInfo = new OptionAnswerInfo();
        answerInfo.setId(option.getId());
        answerInfo.setAnswer(option.isAnswer());
        return answerInfo;
    }
}
