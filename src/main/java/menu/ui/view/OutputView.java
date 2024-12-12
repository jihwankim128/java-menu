package menu.ui.view;

import java.util.List;
import menu.application.RecommendByCoachResponse;
import menu.application.RecommendCategoriesResponse;
import menu.application.RecommendMenuResponse;

public class OutputView {

    private final StringBuilder stringBuilder = new StringBuilder();

    private void clear() {
        System.out.print(stringBuilder);
        stringBuilder.setLength(0);
    }

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
        stringBuilder.append(message).append("\n");
        clear();
    }

    public void displayRecommendResult(final RecommendMenuResponse response) {
        stringBuilder.append("메뉴 추천 결과입니다.\n").append("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n");
        displayRecommendCategoryResult(response.getRecommendCategoriesResponse());
        displayRecommendMenuByCoachResult(response.getRecommendByCoaches());
        stringBuilder.append("\n");
        clear();
    }

    private void displayRecommendMenuByCoachResult(final List<RecommendByCoachResponse> recommendByCoaches) {
        for (final RecommendByCoachResponse recommendByCoach : recommendByCoaches) {
            stringBuilder.append(String.format("[ %s ", recommendByCoach.getCoachName()));
            for (final String menuName: recommendByCoach.getMenuNames()) {
                stringBuilder.append(String.format("| %s ", menuName));
            }
            stringBuilder.append("]\n");
        }
    }

    private void displayRecommendCategoryResult(final RecommendCategoriesResponse response) {
        stringBuilder.append("[ 카테고리 ");
        for (final String category: response.getCategories()) {
            stringBuilder.append(String.format("| %s ", category));
        }
        stringBuilder.append("]\n");
        clear();
    }

}
