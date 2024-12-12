package menu.error.exception;

import menu.error.BusinessException;
import menu.error.ErrorType;

public class CoachNameException extends BusinessException {

    public CoachNameException() {
        super(ErrorType.COACH_NAME_LENGTH);
    }

    public CoachNameException(Object... args) {
        super(ErrorType.COACH_NAME_LENGTH, args);
    }
}
