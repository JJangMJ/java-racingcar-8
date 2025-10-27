package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.dto.RoundResult;

public class RacingRound {
    private final RacingCars racingCars;

    public RacingRound(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RoundResult start() {
        List<CarStatus> carStatuses = racingCars.move();
        return new RoundResult(carStatuses);
    }
}
