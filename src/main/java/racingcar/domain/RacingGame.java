package racingcar.domain;

import java.util.List;
import racingcar.dto.RoundResult;

public class RacingGame {
    private final List<RacingCar> racingCars;

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RoundResult> playOneRound() {
        RacingRound racingRound = new RacingRound(racingCars);
        return racingRound.start();
    }
}
