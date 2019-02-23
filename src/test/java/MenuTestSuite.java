import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import tableA.CreateTableA;

@RunWith(Parameterized.class)
public class MenuTestSuite {

	@Parameter
	public JsonObject json;
	
	Calendar newCalendar = Calendar.getInstance();
	
	@Parameters
	public static Collection<Object[]> data() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		return Helper.data("src/test/java/menuData.json");
	}
    
	@Before
	public void before() {
		System.out.println("--- Start of Test case " + json.get("name") + " ---" );
	}
	
	@Test
	public void startFunctionTest(){
		
		// Test function startFunction and Menu Class
		// Verify that proper data is returned.
		String in = json.get("input").getAsString();
		int expected = json.get("result").getAsInt();
		
		Menu menu = new Menu();
		Scanner sc = new Scanner(in);
		int result = menu.startFunction(sc);
		
		assertEquals(expected, result);
	}
	
	
	@Test
	public void showAvailableCurrenciesPossitiveTest(){
		
		// Test function startFunction and Menu Class
		// Verify that proper data is returned.
		String in = json.get("input").getAsString();
		String expected = json.get("code").getAsString();
		
		Menu menu = new Menu();
		Scanner sc = new Scanner(in);
		CreateTableA createTableA = new CreateTableA();
    
		String choise = expected;
		String code = menu.showAvailableCurrencies(choise, createTableA);
		
		assertEquals(expected, code);
	}
	
	@Test
	public void showAvailableCurrenciesNegativeTest(){
		
		// Test function startFunction and Menu Class
		// Verify that proper data is returned.
		
		Menu menu = new Menu();
		Scanner sc = new Scanner("1");
		CreateTableA createTableA = new CreateTableA();
    
		String choise = "TLC";
		String code = menu.showAvailableCurrencies(choise, createTableA);
		
		assertEquals("/0", code);
	}
	
	@Test
	public void setPeriodOfTimeTest() {
		
		newCalendar.clear();
	    newCalendar.set(2019, 1, 21);
	    String expectedEndDate = json.get("end_date").getAsString();
	    String expectedStartDate = json.get("start_date").getAsString();
	    
	    int timePeriod = json.get("time_period").getAsInt();
	    Menu menu = new Menu();
	    PeriodOftime period = menu.setPeriodOfTime(timePeriod, newCalendar);

	    assertEquals(expectedEndDate, period.getEndDate());
	    assertEquals(expectedStartDate, period.getStartDate());
	}
	
	
	@After
	public void after() {
		System.out.println("--- End of Test case " + json.get("name") + " ---\n");
	}
	
	
}
