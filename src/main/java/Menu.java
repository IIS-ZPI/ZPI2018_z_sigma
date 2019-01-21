import tableA.CreateTableA;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public int startFunction() {

        int numberOption;
        for (; ; ) {
            numberOption = showStartMenu();

            if (numberOption == 1 || numberOption == 2 || numberOption == 3 || numberOption == 0)
                break;
            else
                System.out.println("niepoprawny wybór, wybierz 1, 2 lub 3" + "\n");
        }
        return numberOption;
    }

    public int showStartMenu() {

        System.out.println();
        System.out.println("co chcesz zrobic?" + "\n");
        System.out.println("1 -> wyznaczanie ilości sesji (wzrostowych, spadkowych, bez zmian)" + "\n" +
                "2 -> miary statystyczne" + "\n" + "3 -> rozkład zmian dla wybranych walut" + "\n" +
                "0 -> wyjscie z programu" + "\n");

        Scanner in = new Scanner(System.in);
        int numberOption;

        if (in.hasNextInt()) {
            numberOption = in.nextInt();
            in.nextLine();
        } else {
            System.out.println("niepoprawny wybór, wybierz 1, 2 lub 3" + "\n");
            numberOption = showStartMenu();
        }

        return numberOption;
    }

    public String showAvailableCurrencies(int number) {


        CreateTableA createTableA = new CreateTableA();
        System.out.println("dostępne waluty:" + "\n");
        createTableA.showCodeAndCurency();
        System.out.println();
        if (number == 1)
            System.out.println("wybierz walute pierwsza i wpisz jej 3 literowy kod:");
        else if (number == 2)
            System.out.println("wybierz walute druga i wpisz jej 3 literowy kod:");
        else
            System.out.println("wybierz walute i wpisz jej 3 literowy kod:");

        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        code = code.toUpperCase();
        List<String> listCode = createTableA.getCode();
        int licznik = 0;
        for (int i = 0; i < listCode.size(); i++) {

            if (code.equals(listCode.get(i))) {
                licznik += 1;
            }
        }

        if (licznik != 1) {
            System.out.println("niepoprawny wybor! Sprobuj ponownie...");
            System.out.println();
            code = showAvailableCurrencies(number);
        }

        return code;

    }

    public int showPeriodOfTime() {
        System.out.println("wybierz przedział czasu:");
        System.out.println("1 -> tydzień" + "\n" + "2 -> 2 tygodnie" + "\n" + "3 -> miesiąc" + "\n" + "4 -> kwartał" +
                "\n" + "5 -> pół roku" + "\n" + "6 -> rok" + "\n");

        Scanner in = new Scanner(System.in);
        int numberOption;
        if (in.hasNextInt()) {
            numberOption = in.nextInt();
            in.nextLine();
            if (numberOption != 1 && numberOption != 2 && numberOption != 3 &&
                    numberOption != 4 && numberOption != 5 && numberOption != 6) {
                System.out.println("niepoprawny wybór, wybierz 1, 2, 3, 4, 5 lub 6" + "\n");
                numberOption = showPeriodOfTime();
            }
        } else {
            System.out.println("niepoprawny wybór, wybierz 1, 2, 3, 4, 5 lub 6" + "\n");
            numberOption = showPeriodOfTime();
        }
        return numberOption;
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
