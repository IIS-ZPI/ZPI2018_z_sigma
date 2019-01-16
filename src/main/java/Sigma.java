import tableA.CreateTableA;
import tableCurrency.CreateCurrency;

import java.io.IOException;
import java.util.Scanner;


public class Sigma {
    public static void main(String[] args) throws IOException {


        CreateTableA createTableA = new CreateTableA();

        Scanner in = new Scanner(System.in);

        System.out.println("**** Witaj! ****" + "\n");
        System.out.println("oto dostępne waluty:" + "\n");
        createTableA.showCodeAndCurency();
        System.out.println();
        System.out.println("wybierz walute i wpisz jej 3 literowy kod");

        String code = in.nextLine();
        code = code.toUpperCase();
        System.out.println("wybierz przedział czasu:");
        System.out.println("1 -> tydzień" + "\n" + "2 -> 2 tygodnie" + "\n" + "3 -> miesiąc" + "\n" + "4 -> kwartał" +
                "\n" + "5 -> pół roku" + "\n" + "6 -> rok");


        int numberOption = in.nextInt();

        PeriodOftime periodOftime = new PeriodOftime();

        switch (numberOption) {
            case 1: {
                periodOftime.oneWeek();
                break;
            }
            case 2: {
                periodOftime.twoWeek();
                break;
            }
            case 3: {
                periodOftime.oneMonth();
                break;
            }
            case 4: {
                periodOftime.quarter();
                break;
            }
            case 5: {
                periodOftime.halfYear();
                break;
            }
            case 6: {
                periodOftime.Year();
                break;
            }
        }


        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(periodOftime.getEndDate(), periodOftime.getStartDate(), code);

        createCurrency.changeOfsession();


        in.close();

    }

}
