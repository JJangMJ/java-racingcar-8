package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingRound {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private final List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void start() {
        racingCars.forEach(racingCar -> {
            int randomValue = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            if (randomValue >= 4) {
                racingCar.move();
            }
        });
    }
}
