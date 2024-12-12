package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;
import menu.domain.category.Category;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuStore;
import menu.domain.menu.UnwantedMenus;

public class Recommend {

    private final Coach coach;
    private final UnwantedMenus unwantedMenus;

    private Recommend(final Coach coach, final UnwantedMenus unwantedMenus) {
        this.coach = coach;
        this.unwantedMenus = unwantedMenus;
    }

    public static Recommend of(final Coach coach, final UnwantedMenus unwantedMenus) {
        return new Recommend(coach, unwantedMenus);
    }

    public String recommendMenuName(final Category category) {
        final List<Menu> menus = MenuStore.getMenu(category).filterMenu(unwantedMenus);
        final List<String> menuNames = extractMenuNames(menus);
        return Randoms.shuffle(menuNames).get(0);
    }

    private static List<String> extractMenuNames(final List<Menu> menus) {
        return menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    public String getCoachName() {
        return coach.getName();
    }

}
