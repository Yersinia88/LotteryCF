
import java.util.Set;

public abstract class LotteryBasicInfos {
    private static final int LOTTERY_NUMBER_TYPE = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;


    public boolean isValidNumber(int number) {
        return number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER;
    }

    public abstract Set<Integer> addLotteryNumbers(int number);

    public abstract Set<Integer> getLotteryNumbers();

    public static int getMinimumNumber() {
        return MINIMUM_NUMBER;
    }

    public static int getMaximumNumber() {
        return MAXIMUM_NUMBER;
    }

    public static int getLotteryNumberType() {
        return LOTTERY_NUMBER_TYPE;
    }
}
