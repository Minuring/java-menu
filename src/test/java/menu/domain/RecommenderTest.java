package menu.domain;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.Map;
import menu.domain.food.Category;
import menu.domain.food.Menu;
import menu.error.exception.CoachesCountException;
import menu.error.exception.DuplicatedCoachException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RecommenderTest {

    @DisplayName("정상적인 개수의 코치 리스트")
    @ParameterizedTest
    @MethodSource("validSizeList")
    void validCoachName(List<Coach> coaches) {
        assertDoesNotThrow(() -> new Recommender(coaches));
    }

    static List<Arguments> validSizeList() {
        return List.of(
            Arguments.of(List.of(
                new Coach("A1"),
                new Coach("A2")
            )),
            Arguments.of(List.of(
                new Coach("A1"),
                new Coach("A2"),
                new Coach("A3")
            )),
            Arguments.of(List.of(
                new Coach("A1"),
                new Coach("A2"),
                new Coach("A3"),
                new Coach("A4"),
                new Coach("A5")
            ))
        );
    }

    @DisplayName("2~5개가 아닌 개수의 코치 리스트 예외 발생")
    @ParameterizedTest
    @MethodSource("invalidSizeList")
    void invalidCoachName(List<Coach> coaches) {
        assertThatThrownBy(() -> new Recommender(coaches))
            .isInstanceOf(CoachesCountException.class);
    }

    static List<Arguments> invalidSizeList() {
        return List.of(
            Arguments.of(List.of(
                new Coach("A1")
            )),
            Arguments.of(List.of(
                new Coach("A1"),
                new Coach("A2"),
                new Coach("A3"),
                new Coach("A4"),
                new Coach("A5"),
                new Coach("A6")
            ))
        );
    }

    @DisplayName("중복된 이름의 코치 예외발생")
    @ParameterizedTest
    @MethodSource("duplicatedList")
    void duplicatedCoachName(List<Coach> coaches) {
        assertThatThrownBy(() -> new Recommender(coaches))
            .isInstanceOf(DuplicatedCoachException.class);
    }

    static List<Arguments> duplicatedList() {
        return List.of(
            Arguments.of(List.of(
                new Coach("ABCD"),
                new Coach("A2"),
                new Coach("A3"),
                new Coach("ABCD")
            ))
        );
    }

    Recommender recommender = new Recommender(List.of(
        new Coach("코치1"),
        new Coach("코치2")
    ));

    @RepeatedTest(50)
    void choiceCategoriesTest() {
        List<Category> categories = recommender.recommendCategories(5);

        Map<String, Long> countsOfCategory = categories.stream()
            .collect(groupingBy(Enum::name, counting()));

        assertThat(countsOfCategory.values()).allMatch(count -> count <= 2);
    }
}