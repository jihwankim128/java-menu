package menu.ui.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class View extends OutputView {

    private String readLine() {
        final String input = Console.readLine();
        System.out.println();
        return input;
    }

    public List<String> enterCoachNames() {
        displayCoachNamesInput();
        return Arrays.stream(readLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> enterUnwantedMenu(final String coachName) {
        displayUnwantedMenu(coachName);
        return Arrays.stream(readLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
