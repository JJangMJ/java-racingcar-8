package racingcar.exception;

public enum ErrorMessage {
    RACING_CAR_NAME_CANNOT_BE_BLANK("자동차 이름은 공백일 수 없습니다."),
    RACING_CAR_NAME_LENGTH_SHOULD_BE_1_TO_5("자동차 이름은 1~5자 이내여야 합니다."),
    RACING_CAR_NAME_CANNOT_BE_DUPLICATED("자동차 이름은 중복될 수 없습니다."),
    ROUND_COUNT_CANNOT_BE_BLANK("시도 횟수는 공백일 수 없습니다."),
    ROUND_COUNT_SHOULD_BE_NUMBER("시도 횟수는 숫자로 입력해야 합니다."),
    ROUND_COUNT_SHOULD_BE_POSITIVE("시도 횟수는 자연수여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
