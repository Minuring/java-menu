package menu.domain.food;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Menus {

    private final Map<Category, List<Menu>> menus = new LinkedHashMap<>();

    public void addMenu(Category category, Menu menu) {
        if (menus.containsKey(category)) {
            List<Menu> categoryMenus = menus.get(category);
            categoryMenus.add(menu);
            return;
        }

        List<Menu> newCategoryMenu = new ArrayList<>(Arrays.asList(menu));
        menus.put(category, newCategoryMenu);
    }

    public void addAllMenus(Category category, List<Menu> menus) {
        if (this.menus.containsKey(category)) {
            List<Menu> categoryMenus = this.menus.get(category);
            categoryMenus.addAll(menus);
            return;
        }
        this.menus.put(category, menus);
    }
}
