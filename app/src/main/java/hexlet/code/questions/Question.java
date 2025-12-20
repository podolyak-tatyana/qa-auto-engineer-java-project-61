package hexlet.code.questions;

/**
 * Base abstract class for questions used in the game engine.
 * <p>
 * Subclasses must provide logic for converting user input into
 * a comparable numeric value via {@link #handleUsersValue(String)}.
 * Instances of this class are immutable.
 *
 * @param <T> the type of data representing the question and the correct value
 */
public abstract class Question<T> {

    private final T given;
    private final T rightAnswer;

    /**
     * Creates a question with the displayed value and its correct answer.
     *
     * @param givenValue  the value that will be shown to the user
     * @param rightValue  the correct answer to the question
     */
    public Question(T givenValue, T rightValue) {
        this.given = givenValue;
        this.rightAnswer = rightValue;
    }

    /**
     * Converts raw user input into a numeric value that can be evaluated
     * against {@link #getRightAnswer()}.
     * <p>
     * Subclasses must ensure that:
     * <ul>
     *     <li>the returned value is non-null;</li>
     *     <li>invalid user input results in an {@link IllegalArgumentException};</li>
     *     <li>conversion does not produce side effects.</li>
     * </ul>
     *
     * @param usersAnswer the raw string provided by the user
     * @return a numeric representation of the user's answer
     */
    public abstract Number handleUsersValue(String usersAnswer);

    /**
     * Returns the representation of the question that will be shown to the user.
     * Subclasses must ensure this value is immutable and non-null.
     *
     * @return the question shown to the user
     */
    public T getGiven() {
        return given;
    }

    /**
     * Returns the correct answer to the question.
     * Subclasses must ensure the answer is immutable and non-null.
     *
     * @return the correct answer to the question
     */
    public T getRightAnswer() {
        return rightAnswer;
    }

    public abstract String getAnswerDisplayValue();
}

