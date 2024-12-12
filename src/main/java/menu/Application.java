package menu;

import menu.ui.controller.MenuController;
import menu.utils.FileReader;

public class Application {

    private static final String FILE_PATH = "src/main/resources/menus.md";

    public static void main(String[] args) {
        FileReader.loadAllMenus(FILE_PATH);
        new MenuController().run();
    }

}
