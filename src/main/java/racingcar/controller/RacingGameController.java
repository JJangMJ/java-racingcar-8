package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.dto.RoundResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = inputView.inputCarNames();
        List<RacingCar> racingCars = carNames.stream()
                .map(RacingCar::new)
                .toList();
        int roundCount = inputView.inputRoundCount();

        outputView.printResultHeader();
        RacingGame racingGame = new RacingGame(racingCars);
        for (int i = 0; i < roundCount; i++) {
            List<RoundResult> roundResults = racingGame.playOneRound();
            outputView.printResult(roundResults);
        }
    }
}
