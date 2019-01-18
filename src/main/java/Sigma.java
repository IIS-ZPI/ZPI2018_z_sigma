import tableA.CreateTableA;
import tableCurrency.CreateCurrency;

import java.io.IOException;
import java.util.Scanner;


public class Sigma {
    public static void main(String[] args) throws IOException {


        System.out.println("**** Witaj! ****" + "\n");
        System.out.println("co chcesz zrobic?" + "\n");
        System.out.println("1 -> wyznaczanie ilości sesji (wzrostowych, spadkowych, bez zmian)" + "\n" +
                "2 -> miary statystyczne" + "\n" + "3 -> rozkład zmian dla wybranych walut" + "\n");


        Scanner in = new Scanner(System.in);
        int numberOption1 = in.nextInt();
        in.nextLine();

        switch (numberOption1) {


            case 1: {
                Menu menu = new Menu();
                menu.showAvailableCurrencies();
                System.out.println("wybierz walute i wpisz jej 3 literowy kod");
                String code = in.nextLine();


                menu.showPeriodOfTime();

                int numberOption2 = in.nextInt();

                PeriodOftime periodOftime = menu.setPeriodOfTime(numberOption2);


                CreateCurrency createCurrency = new CreateCurrency();
                createCurrency.deserializationCurrencyfromJson(periodOftime.getEndDate(),
                        periodOftime.getStartDate(), code);

                createCurrency.changeOfsession();

                break;
            }
            case 2: {

                Menu menu = new Menu();
                menu.showAvailableCurrencies();
                System.out.println("wybierz walute i wpisz jej 3 literowy kod");
                String code = in.nextLine();

                menu.showPeriodOfTime();

                int numberOption2 = in.nextInt();

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
                Menu menu = new Menu();
                menu.showAvailableCurrencies();
                System.out.println("podaj pierwszą walute: ");
                String code1 = in.nextLine();
                System.out.println("podaj drugą walute: ");
                String code2 = in.nextLine();
                menu.showPeriodOfTime();

                int numberOption3 = in.nextInt();
                in.nextLine();

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
                distributionOfCurrencyChanges.writeCSV();


                break;
            }

        }


        in.close();


    }

}
