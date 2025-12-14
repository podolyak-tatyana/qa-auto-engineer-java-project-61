package hexlet.code;

import hexlet.code.questions.Question;

import java.util.ArrayList;
import java.util.List;

public final class GameRound<T extends Question> {
    private String taskDescription;
    private List<T> questionList;


    public GameRound() {
        this.questionList = new ArrayList<>();
    }

    public GameRound(String taskDescriptionValue, List<T> filledQuestionList) {
        this.taskDescription = taskDescriptionValue;
        this.questionList = filledQuestionList;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public List<T> getQuestionList() {
        return questionList;
    }
}
