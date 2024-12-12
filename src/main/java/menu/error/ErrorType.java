package menu.error;

import java.util.Arrays;
import java.util.IllegalFormatException;

public enum ErrorType {
    COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자여야 합니다.")
    ;

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String message(Object... args) {
        try {
            return String.format(message, args);
        } catch (IllegalFormatException e) {
            System.err.printf("[message] %s [args] %s", message, Arrays.toString(args));
            throw e;
        }
    }
}
