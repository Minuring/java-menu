package menu.error.exception;

import menu.error.BusinessException;
import menu.error.ErrorType;

public class BadInputException extends BusinessException {

    public BadInputException() {
        super(ErrorType.BAD_INPUT);
    }
    
    public BadInputException(Object... args) {
        super(ErrorType.BAD_INPUT, args);
    }
}
