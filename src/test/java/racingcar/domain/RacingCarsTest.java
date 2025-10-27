package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
    @Test
    void 이름_중복이면_예외_처리() {
        Assertions.assertThatThrownBy(() -> new RacingCars(List.of("pobi", " pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}
