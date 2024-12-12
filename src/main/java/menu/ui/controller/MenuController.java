package menu.ui.controller;

import camp.nextstep.edu.missionutils.Randoms;
import menu.application.RecommendCategoriesResponse;
import menu.domain.Recommend;
import menu.domain.Recommends;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.menu.Categories;
import menu.domain.menu.Category;
import menu.domain.menu.UnwantedMenus;
import menu.ui.view.View;

public class MenuController {

    private final View view = new View();

    public void run() {
        view.displayRecommendServiceStart();
        final Recommends recommends = processUnwantedMenuByCoach();
        final Categories categories = processRecommendCategories();
        view.displayRecommendResult(RecommendCategoriesResponse.from(categories));
        view.displayRecommendSuccess();
    }

    private Categories processRecommendCategories() {
        final Categories categories = new Categories();
        while (categories.canAdditionalCategory()) {
            final Category category = Category.from(Randoms.pickNumberInRange(1, 5));
            categories.addCategory(category);
        }

        return categories;
    }

    private Recommends processUnwantedMenuByCoach() {
        final Recommends recommends = new Recommends();
        final Coaches coaches = extractCoaches();

        for (final Coach coach : coaches.getCoaches()) {
            final UnwantedMenus unwantedMenus = extractUnwantedMenuByCoach(coach);
            final Recommend recommend = Recommend.of(coach, unwantedMenus);
            recommends.addRecommend(recommend);
        }
        return recommends;
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
