package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingRoundTest {
    @Test
    void 라운드를_시작하면_각_자동차의_위치는_0_또는_1() {
        List<RacingCar> racingCars = List.of(new RacingCar("pobi"), new RacingCar("woni"));
        RacingRound round = new RacingRound(racingCars);

        round.start();

        racingCars.forEach(car ->
                Assertions.assertThat(car.getPosition()).isBetween(0, 1)
        );
    }

    @Test
    void 라운드를_N번_실행하면_각_자동차의_위치는_0에서_N_사이() {
        int roundCount = 10;
        List<RacingCar> racingCars = List.of(new RacingCar("pobi"), new RacingCar("woni"));

        for (int i = 0; i < roundCount; i++) {
            RacingRound racingRound = new RacingRound(racingCars);
            racingRound.start();
        }

        racingCars.forEach(car ->
                Assertions.assertThat(car.getPosition()).isBetween(0, roundCount)
        );
    }
}
