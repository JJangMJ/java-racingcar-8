package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
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
        RacingCars racingCars = enrollRacingCars();
        int roundCount = setRoundCount();

        RacingGame racingGame = new RacingGame(racingCars, roundCount);
        playRacingGame(racingGame);
        findWinners(racingGame);
    }

    private RacingCars enrollRacingCars() {
        List<String> carNames = inputView.inputCarNames();
        return new RacingCars(carNames);
    }

    private int setRoundCount() {
        return inputView.inputRoundCount();
    }

    private void playRacingGame(RacingGame racingGame) {
        List<RoundResult> roundResults = racingGame.playRounds();
        outputView.printRoundResults(roundResults);
    }

    private void findWinners(RacingGame racingGame) {
        List<RacingCar> winners = racingGame.extractWinners();
        outputView.printWinners(winners);
    }
}
