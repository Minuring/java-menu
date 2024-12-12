package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CategoryTest {

    @ParameterizedTest
    @MethodSource("ordinalsAndExpectedCategory")
    void getCategoryByOrdinal(int ordinal, Category expected) {
        Category category = Category.of(ordinal);
        assertThat(category).isEqualTo(expected);
    }

    static List<Arguments> ordinalsAndExpectedCategory() {
        return List.of(
            Arguments.of(1, Category.JAPANESE),
            Arguments.of(2, Category.KOREAN),
            Arguments.of(3, Category.CHINESE),
            Arguments.of(4, Category.ASIAN),
            Arguments.of(5, Category.AMERICAN)
        );
    }
}