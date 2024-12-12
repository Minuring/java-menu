package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.view.input.CoachesInputView;

public class InputView {
    public static List<Coach> readCoaches() {
        CoachesInputView view = new CoachesInputView();
        return view.readUntilSuccess();
    }
}
