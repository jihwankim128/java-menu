package menu.domain.menu;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.exception.BadRequestException;
import menu.exception.ExceptionMessage;

public class UnwantedMenus extends Menus {

    private final static int MAXIMUM_UNWANTED_MENU_COUNT = 2;

    private UnwantedMenus(final List<Menu> menus) {
        super(menus);
    }

    private static void validateMenusLength(final List<String> menuNames) {
        if (menuNames.size() > MAXIMUM_UNWANTED_MENU_COUNT) {
            throw new BadRequestException(ExceptionMessage.INVALID_UNWANTED_MENU_COUNT);
        }
    }

    public static UnwantedMenus from(final List<String> unwantedMenuNames) {
        validateMenusLength(unwantedMenuNames);

        return new UnwantedMenus(unwantedMenuNames.stream()
                .map(Menu::new)
                .collect(Collectors.toList()));
    }

}
