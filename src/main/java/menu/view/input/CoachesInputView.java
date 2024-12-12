package menu.view.input;

import static menu.view.ViewUtils.validateCommaPattern;

import java.util.Arrays;
import java.util.List;
import menu.domain.Coach;

public class CoachesInputView extends InputViewTemplate<List<Coach>> {

    @Override
    protected void printHeader(Object... args) {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    @Override
    protected List<Coach> bind(String userInput) {
        validateCommaPattern(userInput);
        return Arrays.stream(userInput.split(","))
            .map(Coach::new)
            .toList();
    }
}
