package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RoundResult;

public class RacingGame {
    private final RacingCars racingCars;
    private final int roundCount;

    public RacingGame(RacingCars racingCars, int roundCount) {
        this.racingCars = racingCars;
        this.roundCount = roundCount;
    }

    public List<RoundResult> playRounds() {
        List<RoundResult> roundResults = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            roundResults.add(playOneRound());
        }
        return roundResults;
    }

    public List<RacingCar> extractWinners() {
        return racingCars.extractWinners();
    }

    private RoundResult playOneRound() {
        RacingRound racingRound = new RacingRound(racingCars);
        return racingRound.start();
    }
}
