package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingRound {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MOVE_MIN_VALUE = 4;
    private final List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void start() {
        racingCars.forEach(racingCar -> {
            int randomValue = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            if (canMove(randomValue)) {
                racingCar.move();
            }
        });
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_MIN_VALUE;
    }
}
