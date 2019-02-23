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

import tableCurrency.CreateCurrency;

@RunWith(Parameterized.class)
public class StatisticalMeasuresTestSuite {

	@Parameter
	public JsonObject json;
	
	Calendar newCalendar = Calendar.getInstance();
	
	@Parameters
	public static Collection<Object[]> data() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		return Helper.data("src/test/java/statisticalMeasuresData.json");
	}
    
	@Before
	public void before() {
		System.out.println("--- Start of Test case " + json.get("name") + " ---" );
	}

	@Test
	public void medianTest() throws IOException {
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
        Double expected = json.get("median").getAsDouble();
		
        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
        
        assertEquals(expected, statisticalMeasures.median(), 1);
	}
	
	
	@Test
	public void dominantTest() throws IOException {
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
		
        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
        
        Object result = statisticalMeasures.dominant();
        Float expected = json.get("dominant").getAsFloat();
        
        assertEquals(expected, result);
	}	
	
	@Test
	public void averageTest() throws IOException {
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
		
        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
        
        Double result = statisticalMeasures.average();
        Double expected = json.get("average").getAsDouble();
        
        assertEquals(expected, result);
	}
	
	
	@Test
	public void averageWithmidSquaredTest() throws IOException {
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
		
        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
        
        Double result = statisticalMeasures.averageWithmidSquared();
        Double expected = json.get("averageSqr").getAsDouble();
        
        assertEquals(expected, result);
	}
	
	@Test
	public void StandardDeviationTest() throws IOException {
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
		
        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
        
        Double result = statisticalMeasures.StandardDeviation();
        Double expected = json.get("standardDeviation").getAsDouble();
        
        assertEquals(expected, result);
	}
	
	@Test
	public void coefficientOfVariationTest() throws IOException {
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
		
        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        StatisticalMeasures statisticalMeasures = new StatisticalMeasures(createCurrency.getTableCurrency());
        
        Double result = statisticalMeasures.coefficientOfVariation();
        Double expected = json.get("coefficient").getAsDouble();
        
        assertEquals(expected, result);
	}
	
	@After
	public void after() {
		System.out.println("--- End of Test case " + json.get("name") + " ---\n");
	}
	
	
}
