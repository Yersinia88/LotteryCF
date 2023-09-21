import java.util.*;

public class RandomDraws {
    public static final int PERCENT = 100;


    private Set<RandomLotteryNumbers> randomLotteryNumbersSet = new HashSet<>();
    private Map<Integer, Integer> luckyHitsMap = new HashMap<>();
    private int counter = 0; //számolom a random generálásokat

    public void hits(UserLotteryNumbers userLotteryNumber) {
        System.out.println("Adatok feldolgozás alatt...");
        RandomLotteryNumbers randomLotteryNumbers;
        do {
            randomLotteryNumbers = fillSetWithNumbers(); //feltöltötm RandomLotteryNumbers-szel a Set-et
            counter++;
            int luckyHitNumber = getIntersection(randomLotteryNumbers, userLotteryNumber); //mennyi a találat
            fillMap(luckyHitNumber); //map -->key- hány találatos a szelvény, value - db, ahányszor annyi találatos
            if (isDirectHit(userLotteryNumber, randomLotteryNumbers)) { //telitalálat
                return;
            }
        } while (true);

    }

    private static boolean isDirectHit(UserLotteryNumbers userLotteryNumber, RandomLotteryNumbers randomLotteryNumbers) {
        return randomLotteryNumbers.getLotteryNumbers().containsAll(userLotteryNumber.getLotteryNumbers());
    }

    private void fillMap(int luckyHitNumber) {
        Integer db = luckyHitsMap.get(luckyHitNumber); //az intersection-nél kapott találatok száma kulcshoz tartozó értéke
        luckyHitsMap.put(luckyHitNumber, db == null ? 1 : db + 1); //találat számával növelés
    }

    public void statistics() {
        for (Map.Entry<Integer, Integer> entry : luckyHitsMap.entrySet()) {
            double frequency = (double) entry.getValue() / counter * PERCENT;
            System.out.println("A szelvény " + (String.format("%8d", entry.getValue())) + " sorsoláson ért el " + entry.getKey() + " találatot, a találat relatív gyakorisága: " + (String.format("%11.8f", frequency)) + " %");
        }
    }

    private int getIntersection(RandomLotteryNumbers randomLotteryNumbers, UserLotteryNumbers userLotteryNumber) {
        Set<Integer> intersection = new HashSet<>(); //lérehzok egy új set-et
        intersection.addAll(userLotteryNumber.getLotteryNumbers()); //ebbe belemásolom az összes userLotteryNumbert
        intersection.retainAll(randomLotteryNumbers.getLotteryNumbers()); //csak azokat hagyom meg, ahol van közös a 2 halmazban

        return intersection.size();     //visszatérek a halmaz mérretével, azaz a találatok számával
    }

    private RandomLotteryNumbers fillSetWithNumbers() {
        RandomLotteryNumbers randomLotteryNumbers = new RandomLotteryNumbers(); //legenerálok 6 véletlen számot 1-45 között
        do {
            randomLotteryNumbers.fillWithNumbers();
            if (randomLotteryNumbersSet.add(randomLotteryNumbers)) { //csak akkor adom hozzá és térek vissza vele, ha még nincs benne a halmazban
                return randomLotteryNumbers;
            }
        } while (true);
    }


}
