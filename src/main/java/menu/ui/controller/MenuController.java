package menu.ui.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.application.RecommendByCoachResponse;
import menu.application.RecommendCategoriesResponse;
import menu.application.RecommendMenuResponse;
import menu.domain.Recommend;
import menu.domain.Recommends;
import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.domain.category.Categories;
import menu.domain.category.Category;
import menu.domain.menu.UnwantedMenus;
import menu.ui.view.View;

public class MenuController {

    private final View view = new View();

    public void run() {
        view.displayRecommendServiceStart();

        final Recommends recommends = processUnwantedMenuByCoach();
        final Categories categories = processRecommendCategories();

        view.displayRecommendResult(recommend(categories, recommends));
        view.displayRecommendSuccess();
    }

    private static RecommendMenuResponse recommend(final Categories categories, final Recommends recommends) {
        final Map<String, List<String>> stringListMap = recommends.recommendMenus(categories);

        return new RecommendMenuResponse(
                RecommendCategoriesResponse.from(categories),
                convertResponse(stringListMap)
        );
    }

    private static List<RecommendByCoachResponse> convertResponse(final Map<String, List<String>> stringListMap) {
        return stringListMap.keySet()
                .stream()
                .map(key -> RecommendByCoachResponse.of(key, stringListMap.get(key)))
                .collect(Collectors.toList());
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
