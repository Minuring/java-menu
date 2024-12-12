package menu.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.food.Category;

public class OutputView {

    public static void printWelcome() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }


    public static void printTable(List<Category> categories, Map<Coach, List<String>> recommended) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(categoriesRow(categories));
        for (Entry<Coach, List<String>> entry : recommended.entrySet()) {
            String name = entry.getKey().getName();
            List<String> menus = entry.getValue();
            System.out.println(format(name, menus));
        }
    }

    private static String categoriesRow(List<Category> categories) {
        String categoriesText = categories.stream()
            .map(Category::getName)
            .collect(Collectors.joining(" | "));
        return "[ 카테고리 | " + categoriesText + " ] ";
    }

    private static String format(String head, List<String> menus) {
        return "[ " + head + " | " + String.join(" | ", menus) + " ]";
    }
}
