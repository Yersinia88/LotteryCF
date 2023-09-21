import java.util.*;

public class TotalDraws {

    public static final int PERCENT = 100;
    private Map<Integer, Integer> luckyHitsMap = new HashMap<>();
    private int counter = 0;

    public void hits(UserLotteryNumbers userLotteryNumber) {
        System.out.println("Adatok feldolgozás alatt...");
        Queue<List<Integer>> combinatonsQueue = new AllLotteryNumbers().getResult();
        List<Integer> nextCombination;
        while ((nextCombination = combinatonsQueue.poll()) != null) {
            counter++;
            int luckyHitNumber = getIntersection(nextCombination, userLotteryNumber); //mennyi a találat
            fillMap(luckyHitNumber);
        }
    }

    private void fillMap(int luckyHitNumber) {
        Integer db = luckyHitsMap.get(luckyHitNumber);
        luckyHitsMap.put(luckyHitNumber, db == null ? 1 : db + 1);
    }

    public void statistics() {
        for (Map.Entry<Integer, Integer> entry : luckyHitsMap.entrySet()) {
            double frequency = (double) entry.getValue() / counter * PERCENT;
            System.out.println("A szelvény " + (String.format("%8d", entry.getValue())) + " sorsoláson ért el " + entry.getKey() + " találatot, a találat relatív gyakorisága: " + (String.format("%11.8f", frequency)) + " %");
        }
    }

    private int getIntersection(List<Integer> lotteryNumbers, UserLotteryNumbers userLotteryNumber) {
        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(userLotteryNumber.getLotteryNumbers());
        intersection.retainAll(lotteryNumbers);

        return intersection.size();
    }
}
