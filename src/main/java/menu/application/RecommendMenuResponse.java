package menu.application;

import java.util.List;

public class RecommendMenuResponse {

    private final RecommendCategoriesResponse recommendCategoriesResponse;
    private final List<RecommendByCoachResponse> recommendByCoaches;

    public RecommendMenuResponse(
            final RecommendCategoriesResponse recommendCategoriesResponse,
            final List<RecommendByCoachResponse> recommendByCoaches
    ) {
        this.recommendCategoriesResponse = recommendCategoriesResponse;
        this.recommendByCoaches = recommendByCoaches;
    }

    public RecommendCategoriesResponse getRecommendCategoriesResponse() {
        return recommendCategoriesResponse;
    }

    public List<RecommendByCoachResponse> getRecommendByCoaches() {
        return recommendByCoaches;
    }

}
