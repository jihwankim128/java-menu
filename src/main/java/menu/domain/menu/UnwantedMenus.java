package menu.domain.menu;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.BadRequestException;
import menu.exception.ExceptionMessage;

public class UnwantedMenus {

    private final static int MAXIMUM_UNWANTED_MENU_COUNT = 2;

    private final List<Menu> menus;

    private UnwantedMenus(final List<Menu> menus) {
        validateMenusLength(menus);
        this.menus = menus;
    }

    private static void validateMenusLength(final List<Menu> menus) {
        if (menus.size() > MAXIMUM_UNWANTED_MENU_COUNT) {
            throw new BadRequestException(ExceptionMessage.INVALID_UNWANTED_MENU_COUNT);
        }
    }

    public static UnwantedMenus from(final List<String> unwantedMenuNames) {
        return new UnwantedMenus(unwantedMenuNames.stream()
                .map(Menu::new)
                .collect(Collectors.toList()));
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

}
