package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.food.Category;
import menu.domain.food.Menu;
import menu.error.exception.CoachesCountException;
import menu.error.exception.DuplicatedCoachException;

public class Recommender {

    private static final int MIN_COACHES = 2;
    private static final int MAX_COACHES = 5;
    private static final int MAX_SAME_CATEGORY_PER_WEEK = 2;

    private final List<Coach> coaches;

    public Recommender(List<Coach> coaches) {
        validateSize(coaches);
        validateDuplicate(coaches);
        this.coaches = coaches;
    }

    public List<Category> recommendCategories(int count) {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < count) {
            int randomValue = Randoms.pickNumberInRange(1, Category.values().length);
            Category category = Category.of(randomValue);

            if (shouldRetryChoice(categories, category)) {
                continue;
            }
            categories.add(category);
        }
        return categories;
    }

    private static boolean shouldRetryChoice(List<Category> categories, Category category) {
        long alreadySelectedCount = categories.stream()
            .filter(inList -> inList.equals(category))
            .count();
        return alreadySelectedCount == MAX_SAME_CATEGORY_PER_WEEK;
    }

    public Map<Coach, List<String>> choiceMenus(Category category, List<Coach> coaches) {
        Map<Coach, List<String>> recommended = new LinkedHashMap<>();
        List<String> menus = Menu.namesOfCategory(category);
        for (Coach coach : coaches) {
            choiceMenus(coach, menus, recommended);
        }
        return recommended;
    }

    private void choiceMenus(Coach coach, List<String> menus, Map<Coach, List<String>> recommended) {
        while(true) {
            String choose = choiceMenu(menus, coach);
            List<String> menusOfCoach = recommended.get(coach);
            if (!menusOfCoach.contains(choose)) {
                menusOfCoach.add(choose);
                break;
            }
        }
    }

    private String choiceMenu(List<String> menus, Coach coach) {
        List<String> candidates = computeCandidates(menus, coach);
        return Randoms.shuffle(candidates).get(0);
    }

    private List<String> computeCandidates(List<String> menus, Coach coach) {
        return menus.stream()
            .map(Menu::ofName)
            .filter(coach::canEat)
            .map(Menu::getName)
            .toList();
    }

    private void validateDuplicate(List<Coach> coaches) {
        int size = coaches.size();
        long distinctSize = coaches.stream().distinct().count();
        if (size != distinctSize) {
            throw new DuplicatedCoachException();
        }
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < MIN_COACHES || coaches.size() > MAX_COACHES) {
            throw new CoachesCountException();
        }
    }
}
