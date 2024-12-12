package menu.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CategoriesTest {

    @Test
    void 카테고리_정보가_없을_때_카테고리를_추가할_수_있다() {
        Categories categories = new Categories();
        boolean result = categories.canAdditionalCategory();
        assertThat(result).isTrue();
    }

    @Test
    void 카테고리_정보가_5개_이상이면_카테고리를_추가할_수_없다() {
        Categories categories = new Categories();
        categories.addCategory(Category.ASIAN_FOOD);
        categories.addCategory(Category.JAPANESE_FOOD);
        categories.addCategory(Category.CHINESE_FOOD);
        categories.addCategory(Category.KOREAN_FOOD);
        categories.addCategory(Category.WESTERN_FOOD);

        boolean result = categories.canAdditionalCategory();

        assertThat(result).isFalse();
    }

    @Test
    void 추가된_카테고리_정보가_없으면_카테고리를_추가할_수_있다() {
        Categories categories = new Categories();

        boolean result = categories.canAdditionalCategory(Category.ASIAN_FOOD);

        assertThat(result).isTrue();
    }

    @Test
    void 추가된_카테고리_정보가_2개_이상이면_카테고리를_추가할_수_없다() {
        Categories categories = new Categories();
        categories.addCategory(Category.ASIAN_FOOD);
        categories.addCategory(Category.ASIAN_FOOD);

        boolean result = categories.canAdditionalCategory(Category.ASIAN_FOOD);

        assertThat(result).isFalse();
    }

    @Test
    void 같은_카테고리_3개_이상이_추가되어도_최대_2개를_유지한다() {
        Categories categories = new Categories();
        categories.addCategory(Category.ASIAN_FOOD);
        categories.addCategory(Category.ASIAN_FOOD);
        categories.addCategory(Category.ASIAN_FOOD);

        List<Category> result = categories.getCategories();

        assertThat(result).hasSize(2);
    }

}