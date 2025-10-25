package racingcar.domain;

import java.util.List;
import racingcar.dto.RoundResult;

public class RacingGame {
    private static final int START_POSITION = 0;
    private final List<RacingCar> racingCars;

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RoundResult> playOneRound() {
        RacingRound racingRound = new RacingRound(racingCars);
        return racingRound.start();
    }

    public List<RacingCar> extractWinners() {
        int maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(START_POSITION);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .toList();
    }
}
