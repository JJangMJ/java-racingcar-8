package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<String> carNames = inputView.inputCarNames();
        List<RacingCar> racingCars = carNames.stream()
                .map(RacingCar::new)
                .toList();
        int roundCount = inputView.inputRoundCount();

        RacingGame racingGame = new RacingGame(racingCars, roundCount);
        racingGame.start();
    }
}
