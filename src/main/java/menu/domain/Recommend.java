package menu.domain;

import menu.domain.coach.Coach;
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

}
