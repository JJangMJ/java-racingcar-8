package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import racingcar.dto.CarResult;
import racingcar.exception.ErrorMessage;

public class RacingCars {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int START_POSITION = 0;
    private final List<RacingCar> racingCars;

    public RacingCars(List<String> carNames) {
        validateDuplicateNames(carNames);
        this.racingCars = carNames.stream()
                .map(RacingCar::new)
                .toList();
    }

    public List<CarResult> move() {
        return racingCars.stream()
                .map(racingCar -> {
                    int randomValue = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
                    racingCar.move(randomValue);
                    return new CarResult(racingCar.getName(), racingCar.getPosition());
                })
                .toList();
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

    private void validateDuplicateNames(List<String> carNames) {
        List<String> trimmedNames = carNames.stream()
                .map(String::trim)
                .toList();
        Set<String> uniqueNames = Set.copyOf(trimmedNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.RACING_CAR_NAME_CANNOT_BE_DUPLICATED.getErrorMessage());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
