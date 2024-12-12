package menu.ui.controller;

import java.util.List;
import menu.domain.Coaches;
import menu.ui.view.View;

public class MenuController {

    private final View view = new View();

    public void run() {
        view.displayRecommendServiceStart();
        final List<String> coachNames = view.enterCoachNames();
        final Coaches coaches = new Coaches(coachNames);
        view.displayRecommendSuccess();
    }

}
