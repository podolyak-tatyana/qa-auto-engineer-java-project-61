package hexlet.code.questions;

import hexlet.code.games.Answer;

public final class BooleanQuestion extends Question {

    public BooleanQuestion(Integer number, Answer answer) {
        super(number, answer);
    }

    @Override
    public Byte handleUsersValue(String userRawAnswer) {
        return Answer.getAnswerByValue(userRawAnswer).getNumber();
    }
}
