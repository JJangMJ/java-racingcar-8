package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;

    public RacingGameController() {
        this.inputView = new InputView();
    }

    public void run() {
        List<String> carNames = inputView.inputCarNames();

        List<RacingCar> racingCars = carNames.stream()
                .map(RacingCar::new)
                .toList();
    }
}
