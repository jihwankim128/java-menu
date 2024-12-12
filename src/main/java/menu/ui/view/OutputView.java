package menu.ui.view;

import menu.application.RecommendCategoriesResponse;

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
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coachName);
    }

    public void displayErrorMessage(final String message) {
        System.out.println(message);
        System.out.println();
    }

    public void displayRecommendResult(final RecommendCategoriesResponse response) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        displayRecommendCategoryResult(response);
        System.out.println();
    }

    private static void displayRecommendCategoryResult(final RecommendCategoriesResponse response) {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[ 카테고리 ");
        for (final String category: response.getCategories()) {
            stringBuilder.append(String.format("| %s ", category));
        }
        stringBuilder.append("]");

        System.out.println(stringBuilder);
    }

}
