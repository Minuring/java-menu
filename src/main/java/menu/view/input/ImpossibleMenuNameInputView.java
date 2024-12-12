package menu.view.input;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import menu.error.exception.BadInputException;

public class ImpossibleMenuNameInputView extends InputViewTemplate<List<String>> {

    @Override
    protected void printHeader(Object... args) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", args);
    }

    @Override
    protected List<String> bind(String userInput) {
        userInput = userInput.trim();
        if (userInput.isEmpty() || userInput.isBlank()) {
            return Collections.emptyList();
        }
        if (userInput.matches("^\\D+(,\\D+)*$")) {
            return Arrays.asList(userInput.split(","));
        }
        throw new BadInputException();
    }
}
