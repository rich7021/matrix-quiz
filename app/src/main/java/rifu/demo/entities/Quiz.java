package rifu.demo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Quiz {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String topic;
    private String quiz;
    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<QuizOption> option;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public Set<QuizOption> getOption() {
        return option;
    }

    public void setOption(Set<QuizOption> option) {
        this.option = option;
    }
}
