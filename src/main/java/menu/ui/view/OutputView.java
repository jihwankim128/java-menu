package menu.ui.view;

public class OutputView {

    public void displayRecommendServiceStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    protected void displayCoachNamesInput() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void displayRecommendSuccess() {
        System.out.println("추천을 완료했습니다.");
    }

    protected void displayUnwantedMenu(final String coachName) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName);
    }

    public void displayErrorMessage(final String message) {
        System.out.println(message);
        System.out.println();
    }
}
