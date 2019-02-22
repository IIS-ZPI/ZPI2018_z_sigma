import tableA.CreateTableA;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public int startFunction(Scanner in) {

        int numberOption;
        for (; ; ) {
            numberOption = showStartMenu(in);

            if (numberOption == 1 || numberOption == 2 || numberOption == 3 || numberOption == 0)
                break;
            else
                System.out.println("niepoprawny wybor, wybierz 1, 2 lub 3" + "\n");
        }
        return numberOption;
    }

    public int showStartMenu(Scanner in) {

        int numberOption;

        if (in.hasNextInt()) {
            numberOption = in.nextInt();
            //in.nextLine();
        } else {
            System.out.println("niepoprawny wybor, wybierz 1, 2 lub 3" + "\n");
            numberOption = 0;
        }

        return numberOption;
    }

    public String showAvailableCurrencies(String code, CreateTableA createTableA) {
        
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
            code = "/0";
        }

        return code;

    }

    // Untestable function, check only input data
    public int showPeriodOfTime() {
        System.out.println("wybierz przedzial‚ czasu:");
        System.out.println("1 -> tydzien" + "\n" + "2 -> 2 tygodnie" + "\n" + "3 -> miesiac" + "\n" + "4 -> kwartal" +
                "\n" + "5 -> pol roku" + "\n" + "6 -> rok" + "\n");

        Scanner in = new Scanner(System.in);
        int numberOption;
        if (in.hasNextInt()) {
            numberOption = in.nextInt();
            in.nextLine();
            if (numberOption != 1 && numberOption != 2 && numberOption != 3 &&
                    numberOption != 4 && numberOption != 5 && numberOption != 6) {
                System.out.println("niepoprawny wybor, wybierz 1, 2, 3, 4, 5 lub 6" + "\n");
                numberOption = showPeriodOfTime();
            }
        } else {
            System.out.println("niepoprawny wybor, wybierz 1, 2, 3, 4, 5 lub 6" + "\n");
            numberOption = showPeriodOfTime();
        }
        return numberOption;
    }

    public PeriodOftime setPeriodOfTime(int numberOption, Calendar calendar) {

        PeriodOftime periodOftime = new PeriodOftime();

        switch (numberOption) {
            case 1: {
                periodOftime.oneWeek(calendar);
                break;
            }
            case 2: {
                periodOftime.twoWeek(calendar);
                break;
            }
            case 3: {
                periodOftime.oneMonth(calendar);
                break;
            }
            case 4: {
                periodOftime.quarter(calendar);
                break;
            }
            case 5: {
                periodOftime.halfYear(calendar);
                break;
            }
            case 6: {
                periodOftime.Year(calendar);
                break;
            }
        }
        return periodOftime;
    }
}
