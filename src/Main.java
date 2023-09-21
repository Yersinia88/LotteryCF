import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            UserLotteryNumbers userLotteryNumber = new UserLotteryNumbers();
            getListOfUserNumbers(userLotteryNumber, scanner);

            RandomDraws randomDraws = new RandomDraws();
            randomDraws.hits(userLotteryNumber);
            randomDraws.statistics();

            System.out.println();

            TotalDraws totalDraws = new TotalDraws();
            totalDraws.hits(userLotteryNumber);
            totalDraws.statistics();
        }
    }


    private static void getListOfUserNumbers(UserLotteryNumbers userLotteryNumber, Scanner scanner) {
        do {
            int number = userInput(scanner);
            userLotteryNumber.addLotteryNumbers(number);
        } while (userLotteryNumber.getLotteryNumbers().size() < LotteryBasicInfos.getLotteryNumberType());
    }


    private static int userInput(Scanner scanner) {
        System.out.printf("Kérlek adj meg egy egész számot, [%d - %d] értékkel: ", LotteryBasicInfos.getMinimumNumber(), LotteryBasicInfos.getMaximumNumber());
        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }
}
