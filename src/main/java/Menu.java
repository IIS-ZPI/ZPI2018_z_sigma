import tableA.CreateTableA;

import java.util.Scanner;

public class Menu {

    public void showAvailableCurrencies() {


        CreateTableA createTableA = new CreateTableA();
        System.out.println("dostępne waluty:" + "\n");
        createTableA.showCodeAndCurency();
        System.out.println();
        System.out.println("wybierz walute i wpisz jej 3 literowy kod");

    }

    public void showPeriodOfTime() {
        System.out.println("wybierz przedział czasu:");
        System.out.println("1 -> tydzień" + "\n" + "2 -> 2 tygodnie" + "\n" + "3 -> miesiąc" + "\n" + "4 -> kwartał" +
                "\n" + "5 -> pół roku" + "\n" + "6 -> rok" + "\n");
    }

    public PeriodOftime setPeriodOfTime(int numberOption){

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

        return periodOftime;
    }
}
