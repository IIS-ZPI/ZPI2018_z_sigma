import tableCurrency.CreateCurrency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DistributionOfCurrencyChanges {
    private CreateCurrency createCurrency1;
    private CreateCurrency createCurrency2;

    public void setCreateCurrency1(CreateCurrency createCurrency1) {
        this.createCurrency1 = createCurrency1;
    }

    public void setCreateCurrency2(CreateCurrency createCurrency2) {
        this.createCurrency2 = createCurrency2;
    }

    public void writeCSV(String code1, String code2) {

        Path path = Paths.get("compare_two_currencies.csv");

        List<Float> compareValue = compareTwoCurrencies();
        List<String> date = dateToList(createCurrency1);

        List<String> toWrite = new ArrayList<>();

        toWrite.add(0, "data, kurs " + code1 + "/" + code2);
        for (int i = 0; i < date.size(); i++) {
            String s = date.get(i) + ", " + compareValue.get(i).toString();
            toWrite.add(i + 1, s);
        }

        try {
            Files.write(path, toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("dane zapisane do pliku CSV :)");


    }

    private List<Float> compareTwoCurrencies() {

        List<Float> listValue1 = valueToList(createCurrency1);
        List<Float> listValue2 = valueToList(createCurrency2);
        List<Float> compare = new ArrayList<>();

        for (int i = 0; i < listValue1.size(); i++) {
            compare.add(i, (listValue1.get(i) / listValue2.get(i)));
        }
        return compare;
    }


    private List<Float> valueToList(CreateCurrency createCurrency) {
        List<Float> value = new ArrayList<>();

        for (int i = 0; i < createCurrency.getTableCurrency().getRates().size(); i++) {
            value.add(i, createCurrency.getTableCurrency().getRates().get(i).getMid());
        }
        return value;
    }

    private List<String> dateToList(CreateCurrency createCurrency) {
        List<String> date = new ArrayList<>();

        for (int i = 0; i < createCurrency.getTableCurrency().getRates().size(); i++) {
            date.add(i, createCurrency.getTableCurrency().getRates().get(i).getEffectiveDate());
        }
        return date;
    }

}
