package menu.domain.category;

import java.util.Arrays;

public enum Category {

    JAPANESE_FOOD("일식"),
    KOREAN_FOOD("한식"),
    CHINESE_FOOD("중식"),
    ASIAN_FOOD("아시안"),
    WESTERN_FOOD("양식"),
    ;

    private final String name;

    Category(final String name) {
        this.name = name;
    }

    public static Category from(final int number) {
        return values()[number - 1];
    }

    public static Category from(final String name) {
        return Arrays.stream(values())
                .filter(category -> category.name.equals(name))
                .findFirst()
                .get();
    }

    public String getName() {
        return name;
    }

}
