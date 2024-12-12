package menu.error.exception;

import menu.error.BusinessException;
import menu.error.ErrorType;

public class DuplicatedCoachException extends BusinessException {

    public DuplicatedCoachException() {
        super(ErrorType.DUPLICATED_COACH);
    }

    public DuplicatedCoachException(Object... args) {
        super(ErrorType.DUPLICATED_COACH, args);
    }
}
