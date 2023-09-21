import java.util.HashSet;
import java.util.Set;

public class UserLotteryNumbers extends LotteryBasicInfos {

    private Set<Integer> userLotteryNumbers = new HashSet<>(getLotteryNumberType()); //megadja, hogy mekkora elemű lehet a lista

    @Override
    public Set<Integer> addLotteryNumbers(int number) { //lottószám hozzáadása + validáció
        if (isValidNumber(number)) {
            if (!userLotteryNumbers.add(number)) {
                System.out.println("Ezt a számot már megadtad, próbálkozz másik számmal.");
            } else {
                userLotteryNumbers.add(number);
            }
        } else if (!isValidNumber(number)) {
            System.out.printf("A szám nem [%d - %d] van, próbálkozz újra.%n", getMinimumNumber(), getMaximumNumber());
        }
        return userLotteryNumbers;
    }


    public Set<Integer> getLotteryNumbers() { //getter
        return userLotteryNumbers;
    }
}
