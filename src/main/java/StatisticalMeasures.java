import tableCurrency.TableForCurrency;

import java.util.*;

public class StatisticalMeasures {

    private List<Float> mid = new ArrayList<Float>();

    public StatisticalMeasures(TableForCurrency tableCurrency) {

        for (int i = 0; i < tableCurrency.getRates().size(); i++) {
            mid.add(tableCurrency.getRates().get(i).getMid());
        }
    }

    public void median() {
        Collections.sort(mid);
        double median;


        if (mid.size() % 2 == 0) {
            median = (mid.get(mid.size() / 2) + mid.get((mid.size() / 2) - 1)) / 2;
            System.out.println("mediana wynosi: " + median);
        } else {
            median = mid.get(mid.size() / 2);
            System.out.println("mediana wynosi: " + median);
        }
    }

    private static Map<Float, Integer> sortByValue(Map<Float, Integer> unsortMap) {

        List<Map.Entry<Float, Integer>> list =
                new LinkedList<>(unsortMap.entrySet());

        Comparator<Map.Entry<Float, Integer>> listComparator = Comparator.comparing(o -> (o.getValue()));
        Collections.sort(list, listComparator.reversed());

        Map<Float, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<Float, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


    public void dominant() {

        int size = mid.size();

        Map<Float, Integer> midValue = new HashMap<>();

        for (int i = 0; i < size; i++) {
            float key = mid.get(i);
            if (!midValue.isEmpty() && midValue.containsKey(key)) {
                int count = midValue.get(key);
                midValue.replace(key, (midValue.get(key) + 1));

            } else {
                midValue.put(key, 1);
            }
        }


        Map<Float, Integer> sortedValues = sortByValue(midValue);

        List<Map.Entry<Float, Integer>> sortedList =
                new LinkedList<>(sortedValues.entrySet());

        List key = new ArrayList();
        List value = new ArrayList();
        int i = 0;
        for (Map.Entry<Float, Integer> entry : sortedList) {
            key.add(i, entry.getKey());
            value.add(i, entry.getValue());
            i += 1;
        }

        System.out.println("dominanta: " + key.get(0));

        for (int j = 1; j < key.size(); j++) {

            if (value.get(0) != (value.get(j))) {
                break;
            }
            System.out.println("dominanta: " + key.get(j));
        }
    }

    private double average() {

        double sum = 0;

        for (float x : mid) {
            sum += x;
        }

        return sum / mid.size();
    }

    private double averageWithmidSquared() {
        double sum = 0;

        for (float x : mid) {
            sum += x * x;
        }

        return sum / mid.size();
    }

    public double StandardDeviation (){
        double standardDeviation;
        int n = mid.size();
        standardDeviation = Math.sqrt((n/ (n-1)) * (averageWithmidSquared() - (average() * average())));

        return standardDeviation;
    }

    public double coefficientOfVariation (){

        return StandardDeviation()/average();
    }
}
