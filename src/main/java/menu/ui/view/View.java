package menu.ui.view;

import camp.nextstep.edu.missionutils.Console;

public class View extends OutputView {

    private String readLine() {
        final String input = Console.readLine();
        System.out.println();
        return input;
    }

}
