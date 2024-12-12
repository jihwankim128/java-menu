package menu.domain.menu;

import java.util.HashMap;
import java.util.Map;
import menu.domain.category.Category;

public class MenuStore {

    private static final Map<Category, Menus> store = new HashMap<>();

    private MenuStore() {}

    public static void addMenu(final Category category, final Menus menus) {
        store.put(category, menus);
    }

    public static Menus getMenu(final Category category) {
        return store.get(category);
    }

}
