package hexlet.code.games;

public enum Answer {
    YES("yes"),
    NO("no"),
    ERROR(null);

    final String value;

    Answer(String answer) {
        this.value = answer;
    }

    static String getValueByEven(boolean isEven) {
        return isEven ? YES.value : NO.value;
    }

    static Answer getAnswerByValue(String value) {
        return switch (value) {
            case "yes" -> YES;
            case "no" -> NO;
            default -> ERROR;
        };
    }
}