package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.dto.RoundResult;

public class OutputView {
    public void printRoundResults(List<RoundResult> roundResults) {
        printResultHeader();
        roundResults.forEach(this::printRoundResult);
    }

    public void printWinners(List<RacingCar> winners) {
        String winnerNames = String.join(", ", winners.stream().map(RacingCar::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private void printRoundResult(RoundResult roundResult) {
        roundResult.carStatuses().forEach(result -> {
            System.out.println(result.racingCarName() + " : " + "-".repeat(result.racingCarPosition()));
        });
        System.out.println();
    }
}
