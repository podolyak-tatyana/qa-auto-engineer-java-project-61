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

    public static Byte getValueByEven(Integer number) {
        return number % 2 == 0 ? YES.number : NO.number;
    }

    public static Byte getValueByPrime(int n) {
        if (n < 2) {
            return NO.number;
        }
        if (n == 2) {
            return YES.number;
        }
        if (n % 2 == 0) {
            return NO.number;
        }
        // Проверяем делители только до sqrt(n), только нечётные
        for (int i = DIVIDER_THREE; i <= n / i; i += 2) {
            if (n % i == 0) {
                return NO.number;
            }
        }
        return YES.number;
    }

    public static Byte getNumberByValue(String value) {
        return switch (value) {
            case "yes" -> YES.number;
            case "no" -> NO.number;
            default -> throw new IllegalArgumentException();
        };
    }

    public static String getValueByNumber(Byte numberValue) {
        return switch (numberValue) {
            case 1 -> YES.value;
            case 0 -> NO.value;
            default -> throw new IllegalArgumentException();
        };
    }
}
