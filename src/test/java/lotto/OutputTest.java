package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.IO.Output;
import org.junit.jupiter.api.Test;

class OutputTest {

    private Output output = new Output();

    @Test
    void requestMoneyOutput() {
        output.requestMoneyOutput();
    }

    @Test
    void responseBuyOutput() {
        //given

        //when
        int count = 8;


    }

    @Test
    void requestWinnerNumbers() {
        output.requestWinnerNumbers();
    }

    @Test
    void requestBonusNumber() {
        output.requestBonusNumber();
    }

    @Test
    void responseCalculateWinners() {

        //given
        Map<Integer, Integer> winners = new HashMap<>();
        winners.put(3, 1);
        winners.put(4, 2);
        winners.put(5, 3);
        winners.put(6, 4);
        double benefit = 56;
        output.responseCalculateWinners(winners, benefit);

    }
}