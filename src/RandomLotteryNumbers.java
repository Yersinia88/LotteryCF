import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomLotteryNumbers extends LotteryBasicInfos {
    private final Random random = new Random();
    private final Set<Integer> randomLotteryNumbers = new HashSet<>(getLotteryNumberType());


    @Override
    public Set<Integer> addLotteryNumbers(int number) {
        randomLotteryNumbers.add(number);
        return randomLotteryNumbers;
    }

    @Override
    public Set<Integer> getLotteryNumbers() {
        return randomLotteryNumbers;
    }

    public void fillWithNumbers() {
        do {
            int number = random.nextInt(getMinimumNumber(), getMaximumNumber() + 1);
            addLotteryNumbers(number);
        } while (randomLotteryNumbers.size() < LotteryBasicInfos.getLotteryNumberType());
    }
}
