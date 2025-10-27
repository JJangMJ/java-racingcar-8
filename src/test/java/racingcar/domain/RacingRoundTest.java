package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatus;
import racingcar.dto.RoundResult;

public class RacingRoundTest {
    @Test
    void 라운드를_시작하면_각_자동차의_위치는_0_또는_1() {
        RacingCars racingCars = new RacingCars(List.of("pobi", "woni"));
        RacingRound racingRound = new RacingRound(racingCars);

        RoundResult roundResult = racingRound.start();

        Assertions.assertThat(roundResult.carStatuses()).hasSize(2);

        Assertions.assertThat(roundResult.carStatuses())
                .extracting(CarStatus::racingCarName)
                .containsExactlyInAnyOrder("pobi", "woni");

        Assertions.assertThat(roundResult.carStatuses())
                .extracting(CarStatus::racingCarPosition)
                .allMatch(pos -> pos == 0 || pos == 1);
    }

    @Test
    void 라운드를_N번_실행하면_각_자동차의_위치는_0에서_N_사이() {
        int roundCount = 10;
        RacingCars racingCars = new RacingCars(List.of("pobi", "woni"));
        RacingRound racingRound = new RacingRound(racingCars);

        for (int i = 0; i < roundCount; i++) {
            racingRound.start();
        }

        racingCars.getRacingCars().forEach(racingCar ->
                Assertions.assertThat(racingCar.getPosition()).isBetween(0, roundCount)
        );
    }
}
