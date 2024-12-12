package menu.error;

import java.util.Arrays;
import java.util.IllegalFormatException;

public enum ErrorType {
    COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자여야 합니다."),
    BAD_INPUT("잘못된 입력입니다. 다시 입력해 주세요."),
    COUNT_COACHES("코치는 2명 이상 5명 이하로 입력해야 합니다."),
    DUPLICATED_COACH("코치는 중복될 수 없습니다.");

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
