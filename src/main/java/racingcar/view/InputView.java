package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class InputView {
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return List.of(Console.readLine().split(","));
    }

    public int inputRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return validateRoundCount(input);
    }

    private int validateRoundCount(String input) {
        validateBlankTryCount(input);
        int roundCount = validateAndParseToInt(input);
        validatePositive(roundCount);
        return roundCount;
    }

    private void validateBlankTryCount(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_COUNT_CANNOT_BE_BLANK.getErrorMessage());
        }
    }

    private int validateAndParseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_COUNT_SHOULD_BE_NUMBER.getErrorMessage());
        }
    }

    private void validatePositive(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_COUNT_SHOULD_BE_POSITIVE.getErrorMessage());
        }
    }
}
