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
    void 무작위로_추출된_값이_4_이상이면_전진한다() {
        RacingCar racingCar = new RacingCar("pobi");
        int beforePosition = racingCar.getPosition();

        racingCar.move(4);
        racingCar.move(7);

        Assertions.assertThat(racingCar.getPosition()).isEqualTo(beforePosition + 2);
    }

    @Test
    void 랜덤값이_4_미만이면_전진하지_않는다() {
        RacingCar racingCar = new RacingCar("pobi");
        int beforePosition = racingCar.getPosition();

        racingCar.move(0);
        racingCar.move(1);
        racingCar.move(3);

        Assertions.assertThat(racingCar.getPosition()).isEqualTo(beforePosition);
    }

    @Test
    void move를_한번_호출하면_위치가_1_증가한다() {
        RacingCar car = new RacingCar("pobi");

        car.move(4);

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void move를_여러_번_호출하면_호출_횟수만큼_위치가_증가한다() {
        RacingCar car = new RacingCar("pobi");

        car.move(4);
        car.move(9);
        car.move(4);

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
