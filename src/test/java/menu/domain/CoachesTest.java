package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.exception.ExceptionMessage;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @Test
    void 코치가_2명보다_적을_경우_예외가_발생한다() {
        // given
        List<String> coachNames = List.of("코치1");

        // when & then
        assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_COACH_COUNT.getMessage());
    }

    @Test
    void 코치가_5명보다_많을_경우_예외가_발생한다() {
        // given
        List<String> coachNames = List.of("코치1", "코치2", "코치3", "코치4", "코치5", "코치6");

        // when & then
        assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_COACH_COUNT.getMessage());
    }

    @Test
    void 코치가_2명일_경우_문제_없다() {
        // given
        List<String> coachNames = List.of("코치1", "코치2");

        // when
        Coaches coaches = new Coaches(coachNames);

        // then
        assertThat(coaches.getCoaches()).hasSize(2);
    }

    @Test
    void 코치가_4명일_경우_문제_없다() {
        // given
        List<String> coachNames = List.of("코치1", "코치2",  "코치3", "코치4");

        // when
        Coaches coaches = new Coaches(coachNames);

        // then
        assertThat(coaches.getCoaches()).hasSize(4);
    }

}