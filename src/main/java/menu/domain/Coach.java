package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import menu.domain.food.Menu;
import menu.error.exception.CoachNameException;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_IMPOSSIBLE_MENUS = 2;

    private final String name;
    private final List<Menu> impossibleMenus = new ArrayList<>(MAX_IMPOSSIBLE_MENUS);

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (MIN_NAME_LENGTH > name.length() || name.length() > MAX_NAME_LENGTH) {
            throw new CoachNameException();
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coach coach)) {
            return false;
        }

        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
