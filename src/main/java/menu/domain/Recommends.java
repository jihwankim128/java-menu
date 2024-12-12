package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommends {

    private final List<Recommend> recommends;

    public Recommends() {
        this.recommends = new ArrayList<>();
    }

    public void addRecommend(final Recommend recommend) {
        this.recommends.add(recommend);
    }

    public List<Recommend> getRecommends() {
        return Collections.unmodifiableList(recommends);
    }

}
