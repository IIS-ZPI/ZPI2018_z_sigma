import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import tableA.ReadURL;
import tableCurrency.CreateCurrency;
import tableCurrency.TableForCurrency;

@RunWith(Parameterized.class)
public class TableCurrencyTestSuite {

	@Parameter
	public JsonObject json;
	
	@Parameters
	public static Collection<Object[]> data() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		return Helper.data("src/test/java/tableCurrencyData.json");
	}
	
    CreateCurrency createCurrency = new CreateCurrency();
    
	@Before
	public void before() {
		System.out.println("--- Start of Test case " + json.get("name") + " ---" );
		System.out.println("Start_date: " + json.get("start_date") + "End_date: " + json.get("end_date"));
	}
	
	@Test
	public void deserializationCurrencyfromJsonTest() throws IOException {
		
		// Test function deserializationCurrencyfromJson and CreateCurrency Class
		// Verify that proper data is returned on every field.
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
		
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        
        String urlAdress = "http://api.nbp.pl/api/exchangerates/rates/A/"+ option + "/" + end_date + "/" + start_date;
        ReadURL url = new ReadURL();
        String jsonString = url.readStringJsonFromURL(urlAdress);
        Gson gson = new Gson();
        Type type = new TypeToken<TableForCurrency>() {
        }.getType();

        TableForCurrency tableCurrency = gson.fromJson(jsonString, type);
        
        assertEquals(tableCurrency.getCode(), createCurrency.getTableCurrency().getCode());
        assertEquals(tableCurrency.getTable(), createCurrency.getTableCurrency().getTable());
        assertEquals(tableCurrency.getCurrency(), createCurrency.getTableCurrency().getCurrency());
        assertEquals(tableCurrency.getRates().size(), createCurrency.getTableCurrency().getRates().size());
	}
	
	
	@Test
	public void changeOfsessionTest() throws IOException {
		
		// Test function changeOfsession and CreateCurrency Class
		// Verify that proper data is returned on every field.
		
		String end_date = json.get("end_date").getAsString();
        String start_date = json.get("start_date").getAsString();
        String option = json.get("option").getAsString();
        int increases = json.get("increases").getAsInt();
        int decreases = json.get("decreases").getAsInt();
        int none = json.get("none").getAsInt();
		
        CreateCurrency createCurrency = new CreateCurrency();
        createCurrency.deserializationCurrencyfromJson(end_date, start_date, option);
        int[]Result = createCurrency.changeOfsession();
		
        assertEquals(increases, Result[0]);
        assertEquals(decreases, Result[1]);
        assertEquals(none, Result[2]);
	}
	
	@After
	public void after() {
		System.out.println("--- End of Test case " + json.get("name") + " ---\n");
	}
	
	
}
