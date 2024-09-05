package spring.springhello.quiz;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class QuizSession {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;

    public QuizSession() {
        this.questions = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    @PostConstruct
    public void init() {
        questions.add(new QuizQuestion(
                "대한민국의 수도는?",
                new String[]{"부산", "경주", "대전", "서울"},
                3
        ));
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizQuestion> questions) {
        this.questions = questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public QuizQuestion getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public boolean isQuizFinished() {
        return currentQuestionIndex >= questions.size();
    }

    public void reset() {
        currentQuestionIndex = 0;
        score = 0;
    }

    public void incrementScore() {
        score++;
    }
}
