package menu.ui.controller;

import menu.ui.view.View;

public class MenuController {

    private final View view = new View();

    public void run() {
        view.displayRecommendServiceStart();
        view.displayRecommendSuccess();
    }

}
