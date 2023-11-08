package lotto;

import static lotto.constant.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.IO.Input;
import lotto.IO.Output;

public class LottoGame {
    private Output output = new Output();
    private Input input = new Input();
    private List<Lotto> lottos = new ArrayList<>();


    public void startGame() {
        try {
            int moneyInput = requestMoneyInput();
            List<Lotto> lottos = buyLotto(moneyInput);
            List<Integer> numbers = requestWinningNumbers();
            int bonusNumber = requestBonusNumber();
            responseCalculateWinners(lottos, numbers, bonusNumber, moneyInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }

    private List<Lotto> buyLotto(int moneyInput) {
        int count = moneyInput / LOTTO_PRICE;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = randomNumberGenerator.GenerateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        output.responseBuyOutput(count, lottos);
        return lottos;
    }

    private int requestMoneyInput() {
        output.requestMoneyOutput();
        int moneyInput = input.getMoneyInput();
        return moneyInput;
    }

    private List<Integer> requestWinningNumbers() {
        output.requestWinnerNumbers();
        List<Integer> numbers = input.getWinnerNumbers();
        return numbers;
    }

    private int requestBonusNumber() {
        output.requestBonusNumber();
        int bonusNumber = input.getBonusNumber();
        return bonusNumber;
    }

    private void responseCalculateWinners(List<Lotto> lottos, List<Integer> winningNumbers,
                                          int bonusNumber, int moneyInput) {
        WinnersCalculator winnersCalculator = new WinnersCalculator(winningNumbers, bonusNumber);
        Map<Integer, Integer> winners = winnersCalculator.calculateWinners(lottos);
        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profit = profitCalculator.calculateProfit(moneyInput, winners);
        output.responseCalculateWinners(winners, profit);
    }


}
