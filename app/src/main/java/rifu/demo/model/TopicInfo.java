package rifu.demo.model;

import rifu.demo.entities.Quiz;

public class TopicInfo {
    public String id;
    public String topic;

    public TopicInfo(String id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "TopicInfo{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }

    public static TopicInfo quizToTopicInfo(Quiz quiz) {
        TopicInfo info = new TopicInfo(quiz.getId(), quiz.getTopic());
        return info;
    }
}
