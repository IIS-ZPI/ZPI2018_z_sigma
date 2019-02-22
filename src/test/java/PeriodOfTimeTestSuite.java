import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;

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

@RunWith(Parameterized.class)
public class PeriodOfTimeTestSuite {

	@Parameter
	public JsonObject json;
	
	@Parameters
	public static Collection<Object[]> data() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		return Helper.data("src/test/java/periodOfTimeData.json");
	}
	
    Calendar newCalendar = Calendar.getInstance();
    String[] Data;
    
	@Before
	public void before() {
		System.out.println("--- Start of Test case " + json.get("name") + " ---" );
		System.out.println("Start_date: " + json.get("start_date") + "End_date: " + json.get("end_date"));
	}
	
	@Test
	public void setDateTest() throws IOException{
		
		// Test function setDate and PeriodOfTime Class
		// Verify that proper data is returned.
		
		newCalendar.clear();
	    newCalendar.set(2019, 1, 21);
		
        int option = json.get("option").getAsInt();
        Data = new Sigma().setDate(option, newCalendar);
        assertEquals(json.get("start_date").getAsString(), Data[0]);
        assertEquals(json.get("end_date").getAsString(), Data[1]);
	}
	
	@After
	public void after() {
		System.out.println("--- End of Test case " + json.get("name") + " ---\n");
	}
	
	
}
