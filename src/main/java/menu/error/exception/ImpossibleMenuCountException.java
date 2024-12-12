package menu.error.exception;

import menu.error.BusinessException;
import menu.error.ErrorType;

public class ImpossibleMenuCountException extends BusinessException {

    public ImpossibleMenuCountException() {
        super(ErrorType.COUNT_IMPOSSIBLE_MENUS);
    }

    public ImpossibleMenuCountException(Object... args) {
        super(ErrorType.COUNT_IMPOSSIBLE_MENUS, args);
    }
}
