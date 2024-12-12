package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.food.Menu;
import menu.view.input.CoachesInputView;
import menu.view.input.ImpossibleMenuNameInputView;

public class InputView {

    public static List<Coach> readCoaches() {
        CoachesInputView view = new CoachesInputView();
        return view.readUntilSuccess();
    }

    public static List<Menu> readImpossibleMenus(Coach coach) {
        ImpossibleMenuNameInputView view = new ImpossibleMenuNameInputView();
        List<String> menuNames = view.readUntilSuccess(coach.getName());

        return menuNames.stream()
            .map(Menu::ofName)
            .toList();
    }
}
