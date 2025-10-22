package racingcar.domain;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public RacingCar(String name) {
        validateRacingCarName(name);
        this.name = name.trim();
    }

    private void validateRacingCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 이내여야 합니다.");
        }
    }
}
