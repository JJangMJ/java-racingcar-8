package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    void 시도_횟수가_숫자가_아닌_경우_예외_처리() {
        provideInput("abc");

        Assertions.assertThatThrownBy(() -> inputView.inputRoundCount()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자로 입력해야 합니다.");
    }

    @Test
    void 시도_횟수가_공백인_경우_예외_처리() {
        provideInput(" ");

        Assertions.assertThatThrownBy(() -> inputView.inputRoundCount()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 공백일 수 없습니다.");
    }

    @Test
    void 시도_횟수가_자연수가_아닌_경우_예외_처리() {
        provideInput("-1");

        Assertions.assertThatThrownBy(() -> inputView.inputRoundCount()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 자연수여야 합니다.");
    }
}
