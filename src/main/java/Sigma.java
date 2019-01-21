import tableCurrency.CreateCurrency;

import java.io.IOException;
import java.util.Scanner;


public class Sigma {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        System.out.println("**** Witaj! ****" + "\n");

        for (; ; ) {

            Menu menu = new Menu();

            int numberOption = menu.startFunction();

            if (numberOption == 0) {
                break;
            }

            switch (numberOption) {


                case 1: {

                    String code = menu.showAvailableCurrencies(0);

                    int numberOption2 = menu.showPeriodOfTime();


                    PeriodOftime periodOftime = menu.setPeriodOfTime(numberOption2);


                    CreateCurrency createCurrency = new CreateCurrency();
                    createCurrency.deserializationCurrencyfromJson(periodOftime.getEndDate(),
                            periodOftime.getStartDate(), code);

                    createCurrency.changeOfsession();

                    break;
                }
                case 2: {

                    String code = menu.showAvailableCurrencies(0);

                    int numberOption2 = menu.showPeriodOfTime();


                    PeriodOftime periodOftime = menu.setPeriodOfTime(numberOption2);

                    CreateCurrency createCurrency = new CreateCurrency();

                    createCurrency.deserializationCurrencyfromJson(periodOftime.getEndDate(),
                            periodOftime.getStartDate(), code);

                    StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
                    statisticalMeasures.median();
                    statisticalMeasures.dominant();
                    System.out.println("odchylenie standardowe: " + statisticalMeasures.StandardDeviation());
                    System.out.println("współczynnik zmienności: " + statisticalMeasures.coefficientOfVariation());

                    break;
                }
                case 3: {


                    String code1 = menu.showAvailableCurrencies(1);
                    String code2 = menu.showAvailableCurrencies(2);

                    int numberOption3 = menu.showPeriodOfTime();

                    PeriodOftime periodOftime = menu.setPeriodOfTime(numberOption3);

                    CreateCurrency createCurrency1 = new CreateCurrency();
                    CreateCurrency createCurrency2 = new CreateCurrency();

                    createCurrency1.deserializationCurrencyfromJson(periodOftime.getEndDate(),
                            periodOftime.getStartDate(), code1);
                    createCurrency2.deserializationCurrencyfromJson(periodOftime.getEndDate(),
                            periodOftime.getStartDate(), code2);

                    DistributionOfCurrencyChanges distributionOfCurrencyChanges = new DistributionOfCurrencyChanges();

                    distributionOfCurrencyChanges.setCreateCurrency1(createCurrency1);
                    distributionOfCurrencyChanges.setCreateCurrency2(createCurrency2);
                    distributionOfCurrencyChanges.writeCSV(code1, code2);


                    break;
                }

            }
        }

        in.close();
    }

}


