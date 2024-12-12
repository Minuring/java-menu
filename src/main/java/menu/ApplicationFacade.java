package menu;

import static menu.domain.food.Category.AMERICAN;
import static menu.domain.food.Category.ASIAN;
import static menu.domain.food.Category.CHINESE;
import static menu.domain.food.Category.JAPANESE;
import static menu.domain.food.Category.KOREAN;

import menu.domain.food.Menus;
import menu.view.OutputView;

public class ApplicationFacade {

    private final Menus menus = new Menus();

    public void run() {
        OutputView.printWelcome();
        setUpMenus();
    }

    private Menus setUpMenus() {
        menus.addAllMenus(JAPANESE, MenuConfig.japanese());
        menus.addAllMenus(KOREAN, MenuConfig.korean());
        menus.addAllMenus(CHINESE, MenuConfig.chinese());
        menus.addAllMenus(ASIAN, MenuConfig.asian());
        menus.addAllMenus(AMERICAN, MenuConfig.american());
        return menus;
    }


}
