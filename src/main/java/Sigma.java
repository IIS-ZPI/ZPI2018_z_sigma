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
                break;
            }

        }


        in.close();


    }

}
