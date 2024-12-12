package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.domain.food.Category;
import menu.domain.food.Menu;
import menu.error.exception.CoachNameException;
import menu.error.exception.ImpossibleMenuCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("정상적인 이름의 코치 생성")
    @ParameterizedTest
    @ValueSource(strings = {"토미", "제임스", "포코", "구구"})
    void validCoachName(String name) {
        Coach coach = new Coach(name);
        assertThat(coach.getName()).isEqualTo(name);
    }

    @DisplayName("코치 이름이 2~4자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"A", "ABCDE", "가", "가나다라마", "", " "})
    void invalidCoachName(String name) {
        assertThatThrownBy(() -> new Coach(name))
            .isInstanceOf(CoachNameException.class);
    }

    @DisplayName("못먹는 음식 2개 이하")
    @Test
    void cannotEat() {
        Coach coach = new Coach("코치");
        Menu gyuDong = Menu.ofName("규동");
        Menu sushi = Menu.ofName("스시");

        coach.setImpossibleMenus(List.of(gyuDong,sushi));
        assertThat(coach.canEat(gyuDong)).isFalse();
        assertThat(coach.canEat(sushi)).isFalse();
    }

    @DisplayName("못먹는 음식이 3개이상이면 예외 발생")
    @Test
    void cannotEatOverTwo() {
        Coach coach = new Coach("코치");
        List<Menu> impossibleMenus = List.of(
            Menu.ofName("규동"),Menu.ofName("짜장면"),Menu.ofName("비빔밥")
        );

        assertThatThrownBy(() -> coach.setImpossibleMenus(impossibleMenus))
            .isInstanceOf(ImpossibleMenuCountException.class);
    }
}