package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    void 단독_우승자_추출() {
        RacingCars racingCars = new RacingCars(List.of("pobi", "woni"));
        RacingCar pobi = findByName(racingCars, "pobi");
        RacingCar woni = findByName(racingCars, "woni");

        pobi.move(4);
        woni.move(5);
        woni.move(5);

        RacingGame racingGame = new RacingGame(racingCars, 1);
        List<RacingCar> winners = racingGame.extractWinners();

        Assertions.assertThat(winners)
                .extracting(RacingCar::getName)
                .containsExactly("woni");
    }

    @Test
    void 공동_우승자_추출() {
        RacingCars racingCars = new RacingCars(List.of("pobi", "woni", "jun"));
        RacingCar pobi = findByName(racingCars, "pobi");
        RacingCar woni = findByName(racingCars, "woni");
        RacingCar jun = findByName(racingCars, "jun");

        pobi.move(9);
        pobi.move(9);
        woni.move(9);
        woni.move(9);
        jun.move(9);

        RacingGame racingGame = new RacingGame(racingCars, 1);
        List<RacingCar> winners = racingGame.extractWinners();

        Assertions.assertThat(winners)
                .extracting(RacingCar::getName)
                .containsExactly("pobi", "woni");
    }

    private RacingCar findByName(RacingCars racingCars, String carName) {
        return racingCars.getRacingCars().stream()
                .filter(racingCar -> racingCar.getName().equals(carName))
                .findFirst()
                .orElseThrow();
    }
}
