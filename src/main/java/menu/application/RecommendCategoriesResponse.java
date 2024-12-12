package menu.application;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.category.Categories;
import menu.domain.category.Category;

public class RecommendCategoriesResponse {

    private final List<String> categories;

    private RecommendCategoriesResponse(List<String> categories) {
        this.categories = categories;
    }

    public static RecommendCategoriesResponse from(final Categories categories) {
        return new RecommendCategoriesResponse(categories.getCategories()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList()));
    }

    public List<String> getCategories() {
        return categories;
    }

}
