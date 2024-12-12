package menu.error.exception;

import menu.error.BusinessException;
import menu.error.ErrorType;

public class CoachesCountException extends BusinessException {

    public CoachesCountException() {
        super(ErrorType.COUNT_COACHES);
    }

    public CoachesCountException(Object... args) {
        super(ErrorType.COUNT_COACHES, args);
    }
}
