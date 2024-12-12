package menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
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

        Map<Coach, List<String>> recommended = new LinkedHashMap<>();
        coaches.stream().forEach(coach -> recommended.put(coach, new ArrayList<>()));
        List<Category> categories = recommender.recommendCategories(DAYS);
        for (int coachIdx = 0; coachIdx < coaches.size(); coachIdx++) {
            for (int categoryIdx = 0; categoryIdx < DAYS; categoryIdx++) {
                Coach coach = coaches.get(coachIdx);
                Category category = categories.get(categoryIdx);
                String menu = recommender.choiceMenu(category, coach);
                List<String> coachMenus = recommended.get(coach);
                if (coachMenus.contains(menu)) {
                    categoryIdx -= 1;
                }
                coachMenus.add(menu);
            }
        }
        OutputView.printTable(categories, recommended);
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
