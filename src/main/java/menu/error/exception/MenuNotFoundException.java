package menu.error.exception;

import menu.error.BusinessException;
import menu.error.ErrorType;

public class MenuNotFoundException extends BusinessException {

    public MenuNotFoundException() {
        super(ErrorType.MENU_NOT_FOUND);
    }

    public MenuNotFoundException(Object... args) {
        super(ErrorType.MENU_NOT_FOUND, args);
    }
}
