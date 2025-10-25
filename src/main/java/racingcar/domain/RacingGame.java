package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final List<RacingCar> racingCars;
    private final int roundCount;

    public RacingGame(List<RacingCar> racingCars, int roundCount) {
        this.racingCars = racingCars;
        this.roundCount = roundCount;
    }

    public void start() {
        for (int i = 0; i < roundCount; i++) {
            RacingRound racingRound = new RacingRound(racingCars);
            racingRound.start();
        }
    }
}
