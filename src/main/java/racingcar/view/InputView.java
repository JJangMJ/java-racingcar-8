package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;

public class InputView {
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));
        validateDuplicateName(carNames);
        return carNames;
    }

    public int inputRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void validateDuplicateName(List<String> carNames) {
        Set<String> uniqueNames = Set.copyOf(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.RACING_CAR_NAME_CANNOT_BE_DUPLICATED.getErrorMessage());
        }
    }
}
