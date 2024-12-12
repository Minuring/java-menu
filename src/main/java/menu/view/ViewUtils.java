package menu.view;

import menu.error.exception.BadInputException;

public class ViewUtils {

    public static void validateCommaPattern(String input) {
        if (input.matches("^\\S+(,\\S+)*$")) {
            return;
        }
        throw new BadInputException();
    }
}
