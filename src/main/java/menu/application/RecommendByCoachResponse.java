package menu.application;

import java.util.List;

public class RecommendByCoachResponse {

    private final String coachName;
    private final List<String> menuNames;

    private RecommendByCoachResponse(final String coachName, final List<String> menuNames) {
        this.coachName = coachName;
        this.menuNames = menuNames;
    }

    public static RecommendByCoachResponse of(final String coachName, final List<String> recommendedMenuNames) {
        return new RecommendByCoachResponse(coachName, recommendedMenuNames);
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

}
