package menu.domain.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categories {

    private static final int MAXIMUM_DUPLICATE_CATEGORY = 2;
    private static final int MAXIMUM_CATEGORY_COUNT = 5;

    private final List<Category> categories;

    public Categories() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(final Category category) {
        if (canAdditionalCategory(category)) {
            this.categories.add(category);
        }
    }

    public boolean canAdditionalCategory() {
        return categories.size() < MAXIMUM_CATEGORY_COUNT;
    }

    public boolean canAdditionalCategory(final Category additionalCategory) {
        return categories.stream()
                .filter(category -> additionalCategory == category)
                .count() < MAXIMUM_DUPLICATE_CATEGORY;
    }

    public List<Category> getCategories() {
        return Collections.unmodifiableList(categories);
    }

}
