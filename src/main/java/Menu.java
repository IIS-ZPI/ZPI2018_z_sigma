import tableA.CreateTableA;

import java.util.Scanner;

public class Menu {

    public int startFunction() {

        int numberOption;
        for (; ; ) {
            numberOption = showStartMenu();

            if (numberOption == 1 || numberOption == 2 || numberOption == 3)
                break;
            else
                System.out.println("niepoprawny wybór, wybierz 1, 2 lub 3" + "\n");
        }
        return numberOption;
    }

    public int showStartMenu() {

        System.out.println("**** Witaj! ****" + "\n");
        System.out.println("co chcesz zrobic?" + "\n");
        System.out.println("1 -> wyznaczanie ilości sesji (wzrostowych, spadkowych, bez zmian)" + "\n" +
                "2 -> miary statystyczne" + "\n" + "3 -> rozkład zmian dla wybranych walut" + "\n");

        Scanner in = new Scanner(System.in);
        int numberOption;

        if (in.hasNextInt()) {
            numberOption = in.nextInt();
            in.nextLine();
        }else {
            System.out.println("niepoprawny wybór, wybierz 1, 2 lub 3" + "\n");
            numberOption = showStartMenu();
        }

        return numberOption;
    }

    public void showAvailableCurrencies() {


        CreateTableA createTableA = new CreateTableA();
        System.out.println("dostępne waluty:" + "\n");
        createTableA.showCodeAndCurency();
        System.out.println();

    }

    public void showPeriodOfTime() {
        System.out.println("wybierz przedział czasu:");
        System.out.println("1 -> tydzień" + "\n" + "2 -> 2 tygodnie" + "\n" + "3 -> miesiąc" + "\n" + "4 -> kwartał" +
                "\n" + "5 -> pół roku" + "\n" + "6 -> rok" + "\n");
    }

    public PeriodOftime setPeriodOfTime(int numberOption) {

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
