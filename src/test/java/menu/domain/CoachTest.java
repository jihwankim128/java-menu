package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import menu.domain.coach.Coach;
import menu.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 코치의_이름은_없을수_없다(String name) {
        // given
        // when & then
        Assertions.assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_COACH_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"일", "일이삼사오", "일이삼사오육"})
    void 코치의_이름은_두글자보다_적거나_네글자보다_많을_수_없다(String name) {
        // given
        // when & then
        Assertions.assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_COACH_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"일이", "일이삼", "일이삼사"})
    void 코치의_이름은_두글자부터_네글자_사이이다(String name) {
        // given
        // when
        Coach coach = new Coach(name);

        // then
        assertThat(coach.getName()).isEqualTo(name);
    }

}