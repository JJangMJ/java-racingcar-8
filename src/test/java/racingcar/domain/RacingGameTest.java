package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    void 단독_우승자_추출() {
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("woni");

        car1.move(4);
        car2.move(5);
        car2.move(5);

        RacingGame racingGame = new RacingGame(List.of(car1, car2));
        List<RacingCar> winners = racingGame.extractWinners();

        Assertions.assertThat(winners)
                .extracting(RacingCar::getName)
                .containsExactly("woni");
    }

    @Test
    void 공동_우승자_추출() {
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("woni");
        RacingCar car3 = new RacingCar("jun");

        car1.move(9);
        car1.move(9);
        car2.move(9);
        car2.move(9);
        car3.move(9);

        RacingGame racingGame = new RacingGame(List.of(car1, car2, car3));
        List<RacingCar> winners = racingGame.extractWinners();

        Assertions.assertThat(winners)
                .extracting(RacingCar::getName)
                .containsExactly("pobi", "woni");
    }
}
