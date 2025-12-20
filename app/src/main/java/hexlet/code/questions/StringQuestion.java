package hexlet.code.questions;

public final class StringQuestion extends Question {

    public StringQuestion(String given, Number answer) {
        super(given, answer);
    }

    @Override
    public Integer handleUsersValue(String usersValue) {
        return Integer.valueOf(usersValue);
    }

    @Override
    public String getAnswerDisplayValue() {
        return getRightAnswer().toString();
    }
}
