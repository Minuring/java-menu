package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    AMERICAN("양식", 5);

    private final String name;
    private final int ordinal;

    Category(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public static Category of(int ordinal) {
        return Arrays.stream(values())
            .filter(category -> category.ordinal == ordinal)
            .findAny()
            .orElseThrow();
    }
}
