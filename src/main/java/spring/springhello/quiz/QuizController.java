package spring.springhello.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {

    private final QuizSession quizSession;

    public QuizController(QuizSession quizSession) {
        this.quizSession = quizSession;
    }

    @GetMapping("/quiz")
    public String startQuiz(Model model) {
        quizSession.reset();
        model.addAttribute("question", quizSession.getCurrentQuestion());
        return "quiz";
    }

    @PostMapping("/quiz")
    public String submitQuiz(@RequestParam int answer, Model model) {
        QuizQuestion currentQuestion = quizSession.getCurrentQuestion();
        if (currentQuestion != null && answer == currentQuestion.getCorrectAnswer()) {
            quizSession.incrementScore();
        }
        quizSession.nextQuestion();

        if (quizSession.isQuizFinished()) {
            return "redirect:/quiz-result";
        }

        model.addAttribute("question", quizSession.getCurrentQuestion());
        return "quiz";
    }

    @GetMapping("/quiz-result")
    public String quizResult(Model model) {
        model.addAttribute("score", quizSession.getScore());
        return "quiz-result";
    }

    @GetMapping("/restart")
    public String restartQuiz() {
        quizSession.reset();
        return "redirect:/quiz";
    }
}
