import tableCurrency.TableForCurrency;

import java.util.*;

public class StatisticalMeasures {

    private List<Float> mid = new ArrayList<>();

    public StatisticalMeasures(TableForCurrency tableCurrency) {

        for (int i = 0; i < tableCurrency.getRates().size(); i++) {
            mid.add(tableCurrency.getRates().get(i).getMid());
        }
    }

    public double median() {
        Collections.sort(mid);
        double median;


        if (mid.size() % 2 == 0) {
            median = (mid.get(mid.size() / 2) + mid.get((mid.size() / 2) - 1)) / 2;
            return median;
        } else {
            median = mid.get(mid.size() / 2);
            return median;
        }
    }

    // Private function can't be single tested
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


    public Object dominant() {

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

        return key.get(0);
    }

    double average() {

        double sum = 0;

        for (float x : mid) {
            sum += x;
        }

        return sum / mid.size();
    }

    double averageWithmidSquared() {
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
