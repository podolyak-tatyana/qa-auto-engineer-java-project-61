package hexlet.code.games;

import static hexlet.code.games.Prime.DIVIDER_THREE;

public enum Answer {
    YES("yes", (byte) 1),
    NO("no", (byte) 0);

    private final String value;
    private final Byte number;

    Answer(String answer, Byte numberValue) {
        this.value = answer;
        this.number = numberValue;
    }

    public Byte getNumber() {
        return number;
    }

    public static Answer getValueByEven(Integer number) {
        return number % 2 == 0 ? YES : NO;
    }

    public static Answer getValueByPrime(int n) {
        if (n < 2) {
            return NO;
        }
        if (n == 2) {
            return YES;
        }
        if (n % 2 == 0) {
            return NO;
        }
        // Проверяем делители только до sqrt(n), только нечётные
        for (int i = DIVIDER_THREE; i <= n / i; i += 2) {
            if (n % i == 0) {
                return NO;
            }
        }
        return YES;
    }

    public static Answer getAnswerByValue(String value) {
        return switch (value) {
            case "yes" -> YES;
            case "no" -> NO;
            default -> throw new IllegalArgumentException();
        };
    }
}
