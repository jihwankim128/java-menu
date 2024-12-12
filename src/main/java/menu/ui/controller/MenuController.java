package menu.ui.controller;

import java.util.List;
import menu.domain.Recommend;
import menu.domain.Recommends;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.UnwantedMenus;
import menu.ui.view.View;

public class MenuController {

    private final View view = new View();
    private final Recommends recommends = new Recommends();

    public void run() {
        view.displayRecommendServiceStart();
        processUnwantedMenuByCoach();
        view.displayRecommendSuccess();
    }

    private void processUnwantedMenuByCoach() {
        final Coaches coaches = extractCoaches();
        for (final Coach coach : coaches.getCoaches()) {
            final UnwantedMenus unwantedMenus = extractUnwantedMenuByCoach(coach);
            final Recommend recommend = Recommend.of(coach, unwantedMenus);
            recommends.addRecommend(recommend);
        }
    }

    private UnwantedMenus extractUnwantedMenuByCoach(final Coach coach) {
        try {
            return UnwantedMenus.from(view.enterUnwantedMenu(coach.getName()));
        } catch (final IllegalArgumentException e) {
            view.displayErrorMessage(e.getMessage());
            return extractUnwantedMenuByCoach(coach);
        }
    }

    private Coaches extractCoaches() {
        try {
            return new Coaches(view.enterCoachNames());
        } catch (final IllegalArgumentException e) {
            view.displayErrorMessage(e.getMessage());
            return extractCoaches();
        }
    }

}
