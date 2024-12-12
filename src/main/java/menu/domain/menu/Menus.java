package menu.domain.menu;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Menus {

    private final List<Menu> menus;

    protected Menus(final List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus from(final List<String> menuNames) {
        return new Menus(menuNames.stream()
                .map(Menu::new)
                .collect(Collectors.toList()));
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public List<Menu> filterMenu(final Menus otherMenu) {
        return menus.stream()
                .filter(menu -> !otherMenu.getMenus().contains(menu))
                .collect(Collectors.toList());
    }

}
