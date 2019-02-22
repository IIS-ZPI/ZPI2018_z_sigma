import tableCurrency.CreateCurrency;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import tableA.CreateTableA;


public class Sigma {
	
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();

        System.out.println("**** Witaj! ****" + "\n");

        for (; ; ) {

            Menu menu = new Menu();
            
            System.out.println();
            System.out.println("co chcesz zrobic?" + "\n");
            System.out.println("1 -> wyznaczanie ilosci sesji (wzrostowych, spadkowych, bez zmian)" + "\n" +
                    "2 -> miary statystyczne" + "\n" + "3 -> rozklad zmian dla wybranych walut" + "\n" +
                    "0 -> wyjscie z programu" + "\n");
            
            Scanner input = new Scanner(System.in);
            int numberOption = menu.startFunction(input);

            if (numberOption == 0) {
                break;
            }

            switch (numberOption) {


                case 1: {
                	in.reset();
                	String code = "/0";

                	do {
                		code = startSequence(in, menu, 0);
                	}while(code == "/0");
                	
                	in.reset();

                    int numberOption2 = menu.showPeriodOfTime();
                    PeriodOftime periodOftime = menu.setPeriodOfTime(numberOption2, calendar);

                    CreateCurrency createCurrency = new CreateCurrency();
                    createCurrency.deserializationCurrencyfromJson(periodOftime.getEndDate(),
                               periodOftime.getStartDate(), code);
                    
                    int[] Data = createCurrency.changeOfsession();
                    System.out.println("ilosc sesji wzrostowych: " + Data[0]);
                    System.out.println("ilosc sesji spadkowych: " + Data[1]);
                    System.out.println("ilosc sesji bez zmian: " + Data[2]);
                    break;
                    


                }
                case 2: {
                    in.reset();
                	
                	String code = "/0";

                	do {
                		code = startSequence(in, menu, 0);
                	}while(code == "/0");
                	
                	in.reset();

                    int numberOption2 = menu.showPeriodOfTime();
                    PeriodOftime periodOftime = menu.setPeriodOfTime(numberOption2, calendar);

                    CreateCurrency createCurrency = new CreateCurrency();
                    createCurrency.deserializationCurrencyfromJson(periodOftime.getEndDate(),
                            periodOftime.getStartDate(), code);

                    StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
                    
                    System.out.println("mediana wynosi: " + statisticalMeasures.median());
                    System.out.println("dominanta: " + statisticalMeasures.dominant());
                    System.out.println("odchylenie standardowe: " + statisticalMeasures.StandardDeviation());
                    System.out.println("wspolczynnik zmiennosci: " + statisticalMeasures.coefficientOfVariation());

                    break;
                }
                case 3: {
                	
                    in.reset();
                    
                 	String code1 = "/0";
                 	String code2 = "/0";

                	do {
                		code1 = startSequence(in, menu, 1);
                	}while(code1 == "/0");
                	
                	do {
                		code2 = startSequence(in, menu, 2);
                	}while(code2 == "/0");
                	
                	in.reset();

                    int numberOption3 = menu.showPeriodOfTime();

                    PeriodOftime periodOftime = menu.setPeriodOfTime(numberOption3, calendar);

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
    
    public static String startSequence(Scanner in, Menu menu, int number) {
    	
        CreateTableA createTableA = new CreateTableA();
        System.out.println("dostepne waluty:" + "\n");
        createTableA.showCodeAndCurency();
        if(number == 1) {
        	System.out.println("wybierz walute pierwsza i wpisz jej 3 literowy kod:");
        	String choise = in.nextLine();

            String code = menu.showAvailableCurrencies(choise, createTableA);
            return code;
        }else if(number == 2) {
        	System.out.println("wybierz walute druga i wpisz jej 3 literowy kod:");
        	String choise = in.nextLine();

            String code = menu.showAvailableCurrencies(choise, createTableA);
            return code;
        }else
        {
        	System.out.println("wybierz walute i wpisz jej 3 literowy kod:");
        	String choise = in.nextLine();

            String code = menu.showAvailableCurrencies(choise, createTableA);
            return code;
        }

    }

}


