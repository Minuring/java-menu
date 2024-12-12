package menu.domain.food;

import static menu.domain.food.Category.ASIAN;
import static menu.domain.food.Category.CHINESE;
import static menu.domain.food.Category.JAPANESE;
import static menu.domain.food.Category.KOREAN;

import java.util.Arrays;
import menu.error.exception.MenuNotFoundException;

public enum Menu {
    GYUDONG("규동", JAPANESE),
    WOODONG("우동", JAPANESE),
    MISOSIRU("미소시루", JAPANESE),
    SUSHI("스시", JAPANESE),
    GACHDONG("가츠동", JAPANESE),
    ONIGIRI("오니기리", JAPANESE),
    HIRICE("하이라이스", JAPANESE),
    RAMEN("라멘", JAPANESE),
    OKONOMIA("오코노미야", JAPANESE),
    GIMBAP("김밥", KOREAN),
    GIMCHIJJIGAE("김치찌개", KOREAN),
    SSAMBAP("쌈밥", KOREAN),
    DAENJANGJJIGAE("된장찌개", KOREAN),
    BIBIMABP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    JEYUKBOKKEUM("제육볶음", KOREAN),
    KKANPUNGI("깐풍기", CHINESE),
    BOGGEUMMYEON("볶음면", CHINESE),
    DONGPAYUK("동파육", CHINESE),
    JJAJANGMYEON("짜장면", CHINESE),
    JJAMPPONG("짬뽕", CHINESE),
    MAPADUBU("마파두부", CHINESE),
    TANGSUYUK("탕수육", CHINESE),
    TOMATOEGGBOKUM("토마토 달걀볶음", CHINESE),
    GOCHUJAPCHAE("고추잡채", CHINESE),
    PATAI("팟타이", ASIAN),
    KAOPAT("카오 팟", ASIAN),
    NASIGORANG("나시고렝", ASIAN),
    PINEAPPLERICE("파인애플 볶음밥", ASIAN),
    SSALGUKSU("쌀국수", ASIAN),
    TOMYAMKOONG("똠얌꿍", ASIAN),
    BANMI("반미", ASIAN),
    WOLNAMSSAM("월남쌈", ASIAN),
    BUNJJA("분짜", ASIAN),
    RAJANYA("라자냐", JAPANESE),
    GRATANG("그라탱", JAPANESE),
    NYOKKI("뇨끼", JAPANESE),
    KKISHU("끼슈", JAPANESE),
    FRENCH("프렌치", JAPANESE),
    BAGUETTE("바게트", JAPANESE),
    SPAGHETTI("스파게티", JAPANESE),
    PIZZA("피자", JAPANESE),
    PANINI("파니니", JAPANESE);

    private final String name;
    private final Category category;

    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static Menu ofName(String name) {
        return Arrays.stream(values())
            .filter(menu -> menu.name.equals(name))
            .findAny()
            .orElseThrow(MenuNotFoundException::new);
    }
}
