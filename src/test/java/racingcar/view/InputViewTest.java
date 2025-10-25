package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final InputStream originalSystemIn = System.in;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        Console.close();
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }

    private void provideInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void 자동차_이름이_중복인_경우_예외_처리() {
        provideInput("pobi, woni, woni");

        Assertions.assertThatThrownBy(() -> inputView.inputCarNames()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}
