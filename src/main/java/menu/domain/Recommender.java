package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.food.Category;
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
        for (int sequence = 1; sequence <= count; sequence++) {
            int randomValue = Randoms.pickNumberInRange(1, Category.values().length);
            Category category = Category.of(randomValue);

            if (shouldRetryChoice(categories, category)) {
                sequence -= 1;
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
