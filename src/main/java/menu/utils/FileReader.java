package menu.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.category.Category;
import menu.domain.menu.MenuStore;
import menu.domain.menu.Menus;

public class FileReader {

    private FileReader() {}

    public static void loadAllMenus(final String filePath) {
        try {
            for (final String line: Files.readAllLines(Paths.get(filePath))) {
                final String[] split = line.split(":");
                final Category category = parseCategory(split[0].trim());
                saveMenus(split[1].trim(), category);
            }
        } catch (final IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void saveMenus(final String menus, final Category category) {
        final List<String> menuNames = Arrays.stream(menus.split(",")).map(String::trim)
                .collect(Collectors.toList());

        MenuStore.addMenu(category, Menus.from(menuNames));
    }

    private static Category parseCategory(final String categoryName) {
        return Category.from(categoryName);
    }

}
