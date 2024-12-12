package menu.domain.food;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MenuTest {

    @Test
    void ofName() {
        Menu ofNameSushi = Menu.ofName("스시");
        assertThat(ofNameSushi).isEqualTo(Menu.SUSHI);
    }

    @DisplayName("카테고리별 메뉴를 순서대로 얻는다.")
    @ParameterizedTest
    @MethodSource("provideData")
    void namesOfCategory(Category category, List<String> mustBeContainedInOrder) {
        List<String> menuNames = Menu.namesOfCategory(category);
        assertThat(menuNames).containsSequence(mustBeContainedInOrder);
    }

    static List<Arguments> provideData() {
        return List.of(
            Arguments.of(Category.JAPANESE, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
            Arguments.of(Category.KOREAN, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
            Arguments.of(Category.CHINESE, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
            Arguments.of(Category.ASIAN, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
            Arguments.of(Category.AMERICAN, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"))
        );
    }
}