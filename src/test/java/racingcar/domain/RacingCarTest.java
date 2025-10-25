package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    void 자동차_생성시_초기_위치는_0() {
        RacingCar racingCar = new RacingCar("pobi");

        Assertions.assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    void move를_한번_호출하면_위치가_1_증가한다() {
        RacingCar car = new RacingCar("pobi");

        car.move();

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void move를_여러_번_호출하면_호출_횟수만큼_위치가_증가한다() {
        RacingCar car = new RacingCar("pobi");

        car.move();
        car.move();
        car.move();

        Assertions.assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void 이름이_null이면_예외() {
        Assertions.assertThatThrownBy(() -> new RacingCar(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    void 이름이_공백이면_예외() {
        Assertions.assertThatThrownBy(() -> new RacingCar("   \t"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    void 이름이_5자를_초과하면_예외() {
        Assertions.assertThatThrownBy(() -> new RacingCar("myDreamCar")) // 6자
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자 이내여야 합니다.");
    }

    @Test
    void 이름의_앞뒤_공백은_제거되어_저장된다() {
        RacingCar car = new RacingCar("pobi ");

        Assertions.assertThat(car.getName()).isEqualTo("pobi");
    }
}
