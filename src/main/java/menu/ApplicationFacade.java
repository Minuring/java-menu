package menu;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Recommender;
import menu.domain.food.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class ApplicationFacade {

    private List<Coach> coaches;
    private Recommender recommender;

    public void run() {
        OutputView.printWelcome();

        runUntilSuccess(() -> {
            coaches = InputView.readCoaches();
            this.recommender = new Recommender(coaches);
        });

        for (Coach coach : coaches) {
            runUntilSuccess(() -> {
                List<Menu> impossibleMenus = InputView.readImpossibleMenus(coach);
                coach.setImpossibleMenus(impossibleMenus);
            });
        }
    }

    private void runUntilSuccess(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
