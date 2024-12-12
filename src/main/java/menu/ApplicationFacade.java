package menu;

import static menu.domain.food.Category.AMERICAN;
import static menu.domain.food.Category.ASIAN;
import static menu.domain.food.Category.CHINESE;
import static menu.domain.food.Category.JAPANESE;
import static menu.domain.food.Category.KOREAN;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Recommender;
import menu.domain.food.Menus;
import menu.view.InputView;
import menu.view.OutputView;

public class ApplicationFacade {

    private final Menus menus = new Menus();
    private List<Coach> coaches;
    private Recommender recommender;

    public void run() {
        OutputView.printWelcome();
        setUpMenus();

        runUntilSuccess(() -> {
            List<Coach> coaches = InputView.readCoaches();
            this.recommender = new Recommender(coaches);
        });
    }

    private Menus setUpMenus() {
        menus.addAllMenus(JAPANESE, MenuConfig.japanese());
        menus.addAllMenus(KOREAN, MenuConfig.korean());
        menus.addAllMenus(CHINESE, MenuConfig.chinese());
        menus.addAllMenus(ASIAN, MenuConfig.asian());
        menus.addAllMenus(AMERICAN, MenuConfig.american());
        return menus;
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
