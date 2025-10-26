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
        List<RacingCar> racingCars = enrollRacingCars();
        int roundCount = setRoundCount();

        RacingGame racingGame = new RacingGame(racingCars);
        playRacingGame(racingGame, roundCount);
        findWinners(racingGame);
    }

    private List<RacingCar> enrollRacingCars() {
        List<String> carNames = inputView.inputCarNames();
        return carNames.stream()
                .map(RacingCar::new)
                .toList();
    }

    private int setRoundCount() {
        return inputView.inputRoundCount();
    }

    private void playRacingGame(RacingGame racingGame, int roundCount) {
        outputView.printResultHeader();
        for (int i = 0; i < roundCount; i++) {
            List<RoundResult> roundResults = racingGame.playOneRound();
            outputView.printRoundResults(roundResults);
        }
    }

    private void findWinners(RacingGame racingGame) {
        List<RacingCar> winners = racingGame.extractWinners();
        outputView.printWinners(winners);
    }
}
