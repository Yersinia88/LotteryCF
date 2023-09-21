import java.util.*;

public class AllLotteryNumbers {
    private final static int MAXIMUM_NUMBER = LotteryBasicInfos.getMaximumNumber();
    private final int LOTTERY_TYPE = LotteryBasicInfos.getLotteryNumberType();
    private final Queue<List<Integer>> result = new LinkedList<>();


    public AllLotteryNumbers() {
        combinations();
    }

    public Queue<List<Integer>> getResult() {
        return result;
    }

    private void combinations() {
        combine(1, MAXIMUM_NUMBER, LOTTERY_TYPE, new ArrayList<>(), result);
    }

    private void combine(int pos, int maximumNumber, int lotteryType, List<Integer> comb, Queue<List<Integer>> result) {
        if (lotteryType == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int x = pos; x <= maximumNumber - lotteryType + 1; x++) {
            comb.add(x);
            combine(x + 1, maximumNumber, lotteryType - 1, comb, result);
            comb.remove(comb.size() - 1); //backtracking approach
        }
    }
}
