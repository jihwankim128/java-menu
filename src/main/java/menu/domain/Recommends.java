package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.domain.category.Categories;
import menu.domain.category.Category;

public class Recommends {

    private final List<Recommend> recommends;
    private final Map<String, List<String>> result = new LinkedHashMap<>();

    public Recommends() {
        this.recommends = new ArrayList<>();
    }

    public void addRecommend(final Recommend recommend) {
        this.recommends.add(recommend);
    }

    public List<Recommend> getRecommends() {
        return Collections.unmodifiableList(recommends);
    }

    public Map<String, List<String>> recommendMenus(final Categories categories) {
        for (final Category category : categories.getCategories()) {
            for (final Recommend recommend : recommends) {
                final String menuName = recommend.recommendMenuName(category);
                final String coachName = recommend.getCoachName();
                result.put(coachName, extractValues(coachName, menuName));
            }
        }

        return result;
    }

    private List<String> extractValues(final String coachName, final String menuName) {
        final List<String> values = result.getOrDefault(coachName, new ArrayList<>());
        if (values.contains(menuName)) {
            return values;
        }

        values.add(menuName);
        return values;
    }

}
