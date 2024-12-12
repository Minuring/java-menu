package menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Recommender;
import menu.domain.food.Category;
import menu.domain.food.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class ApplicationFacade {

    private static final int DAYS = 5;

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

        Map<Category, Map<Coach, List<String>>> recommendMenuTable = new LinkedHashMap<>();
        List<Category> categories = recommender.recommendCategories(DAYS);
        for (Category category : categories) {
            Map<Coach, List<String>> coachMenus = recommender.choiceMenus(category, coaches);
            recommendMenuTable.put(category, coachMenus);
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
