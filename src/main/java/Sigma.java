import tableA.CreateTableA;
import tableCurrency.CreateCurrency;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;


public class Sigma {
    public static void main(String[] args) throws IOException {

        CreateTableA createTableA = new CreateTableA();
        Scanner in = new Scanner(System.in);

        System.out.println("**** Witaj! ****" + "\n");    
        System.out.println("oto dostepne waluty:" + "\n");
        createTableA.showCodeAndCurency();
        System.out.println();
        
        System.out.println("wybierz walute i wpisz jej 3 literowy kod");
        String code = in.nextLine();
        code.toUpperCase();
        
        System.out.println("wybierz przedzial‚ czasu:");
        System.out.println("1 -> tydzien„" + "\n" + "2 -> 2 tygodnie" + "\n" + "3 -> miesiace" + "\n" + "4 -> kwartal‚" +
                "\n" + "5 -> pol‚ roku" + "\n" + "6 -> rok");

        int option = in.nextInt();
        Calendar newCalendar = Calendar.getInstance();
        String[] Data = new Sigma().setDate(option, newCalendar);

        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(Data[1], Data[0], code);
        int[] Result = createCurrency.changeOfsession();
        
        System.out.println("ilosc sesji wzrostowych: " + Result[0]);
        System.out.println("ilosc sesji spadkowych: " + Result[1]);
        System.out.println("ilosc sesji bez zmian: " + Result[2]);


        in.close();

    }
    
    public String[] setDate(int numberOption, Calendar calendar) {
        PeriodOftime periodOftime = new PeriodOftime();
        String[] Data = new String[2];

        switch (numberOption) {
            case 1: {
                periodOftime.oneWeek(calendar);
                Data[0] = periodOftime.getStartDate();
                Data[1] = periodOftime.getEndDate();
                return Data;
            }
            case 2: {
                periodOftime.twoWeek(calendar);
                Data[0] = periodOftime.getStartDate();
                Data[1] = periodOftime.getEndDate();
                return Data;
            }
            case 3: {
                periodOftime.oneMonth(calendar);
                Data[0] = periodOftime.getStartDate();
                Data[1] = periodOftime.getEndDate();
                return Data;
            }
            case 4: {
                periodOftime.quarter(calendar);
                Data[0] = periodOftime.getStartDate();
                Data[1] = periodOftime.getEndDate();
                return Data;
            }
            case 5: {
                periodOftime.halfYear(calendar);
                Data[0] = periodOftime.getStartDate();
                Data[1] = periodOftime.getEndDate();
                return Data;
            }
            case 6: {
                periodOftime.Year(calendar);
                Data[0] = periodOftime.getStartDate();
                Data[1] = periodOftime.getEndDate();
                return Data;
            }
            default: {
            	System.out.println("Zle wybrana opcja");
            	return Data;
            
            }
        }
    }

}
