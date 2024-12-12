package menu.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.exception.ExceptionMessage;
import org.junit.jupiter.api.Test;

class UnwantedMenusTest {

    @Test
    void 메뉴_이름이_두개를_초과할_경우_예외가_발생한다() {
        // given
        List<String> menuNames = List.of("메뉴1", "메뉴2", "메뉴3");

        // when & then
        assertThatThrownBy(() -> UnwantedMenus.from(menuNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_UNWANTED_MENU_COUNT.getMessage());
    }

    @Test
    void 메뉴_이름이_없어도_정상적으로_생성한다() {
        // given
        List<String> menuNames = List.of();

        // when
        UnwantedMenus result = UnwantedMenus.from(menuNames);

        // then
        assertThat(result.getMenus()).hasSize(0);
    }

    @Test
    void 메뉴_이름이_2개일_경우_정상적으로_생성된다() {
        // given
        List<String> menuNames = List.of("메뉴1", "메뉴2");

        // when
        UnwantedMenus result = UnwantedMenus.from(menuNames);

        // then
        assertThat(result.getMenus()).hasSize(2);
    }

}