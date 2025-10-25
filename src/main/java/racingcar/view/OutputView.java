package racingcar.view;

import java.util.List;
import racingcar.dto.RoundResult;

public class OutputView {
    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(List<RoundResult> roundResults) {
        roundResults.forEach(result -> {
            System.out.println(result.racingCarName() + " : " + "-".repeat(result.racingCarPosition()));
        });
        System.out.println();
    }
}
