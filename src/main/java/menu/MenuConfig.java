package menu;

import static menu.domain.food.Category.*;

import java.util.ArrayList;
import java.util.List;
import menu.domain.food.Menu;

public class MenuConfig {

    public static List<Menu> japanese() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("규동", JAPANESE));
        menus.add(new Menu("우동", JAPANESE));
        menus.add(new Menu("미소시루", JAPANESE));
        menus.add(new Menu("스시", JAPANESE));
        menus.add(new Menu("가츠동", JAPANESE));
        menus.add(new Menu("오니기리", JAPANESE));
        menus.add(new Menu("하이라이스", JAPANESE));
        menus.add(new Menu("라멘", JAPANESE));
        menus.add(new Menu("오코노미야", JAPANESE));
        return menus;
    }

    public static List<Menu> korean() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("김밥", KOREAN));
        menus.add(new Menu("김치찌개", KOREAN));
        menus.add(new Menu("쌈밥", KOREAN));
        menus.add(new Menu("된장찌개", KOREAN));
        menus.add(new Menu("비빔밥", KOREAN));
        menus.add(new Menu("칼국수", KOREAN));
        menus.add(new Menu("불고기", KOREAN));
        menus.add(new Menu("떡볶이", KOREAN));
        menus.add(new Menu("제육볶음", KOREAN));
        return menus;
    }

    public static List<Menu> chinese() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("깐풍기", CHINESE));
        menus.add(new Menu("볶음면", CHINESE));
        menus.add(new Menu("동파육", CHINESE));
        menus.add(new Menu("짜장면", CHINESE));
        menus.add(new Menu("짬뽕", CHINESE));
        menus.add(new Menu("마파두부", CHINESE));
        menus.add(new Menu("탕수육", CHINESE));
        menus.add(new Menu("토마토 달걀볶음", CHINESE));
        menus.add(new Menu("고추잡채", CHINESE));
        return menus;
    }

    public static List<Menu> asian() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("팟타이", ASIAN));
        menus.add(new Menu("카오 팟", ASIAN));
        menus.add(new Menu("나시고렝", ASIAN));
        menus.add(new Menu("파인애플 볶음밥", ASIAN));
        menus.add(new Menu("쌀국수", ASIAN));
        menus.add(new Menu("똠얌꿍", ASIAN));
        menus.add(new Menu("반미", ASIAN));
        menus.add(new Menu("월남쌈", ASIAN));
        menus.add(new Menu("분짜", ASIAN));
        return menus;
    }

    public static List<Menu> american() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("라자냐", JAPANESE));
        menus.add(new Menu("그라탱", JAPANESE));
        menus.add(new Menu("뇨끼", JAPANESE));
        menus.add(new Menu("끼슈", JAPANESE));
        menus.add(new Menu("프렌치", JAPANESE));
        menus.add(new Menu("바게트", JAPANESE));
        menus.add(new Menu("스파게티", JAPANESE));
        menus.add(new Menu("피자", JAPANESE));
        menus.add(new Menu("파니니", JAPANESE));
        return menus;
    }
}
