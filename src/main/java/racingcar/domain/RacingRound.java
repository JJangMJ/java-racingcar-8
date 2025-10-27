package racingcar.domain;

import java.util.List;
import racingcar.dto.CarResult;
import racingcar.dto.RoundResult;

public class RacingRound {
    private final RacingCars racingCars;

    public RacingRound(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RoundResult start() {
        List<CarResult> carResults = racingCars.move();
        return new RoundResult(carResults);
    }
}
