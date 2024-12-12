package menu.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class MenusTest {

    @Test
    void test() {
        Menus menus1 = Menus.from(List.of("메뉴1", "메뉴2"));
        Menus menus2 = Menus.from(List.of("메뉴1", "메뉴3"));

        List<Menu> menus = menus1.filterMenu(menus2);

        assertThat(menus).hasSize(1);
    }

}