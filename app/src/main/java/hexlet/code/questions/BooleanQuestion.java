package hexlet.code.questions;

import hexlet.code.games.Answer;

public final class BooleanQuestion extends Question {

    public BooleanQuestion(Integer number, Number answer) {
        super(number, answer);
    }

    @Override
    public Byte handleUsersValue(String userRawAnswer) {
        return Answer.getNumberByValue(userRawAnswer);
    }

    @Override
    public String getAnswerDisplayValue() {
        return Answer.getValueByNumber((Byte) this.getRightAnswer());
    }


}
