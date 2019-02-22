import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tableA.CreateTableA;
import tableA.ReadURL;
import tableA.TableA;
import tableCurrency.CreateCurrency;
import tableCurrency.TableForCurrency;

public class TestSuite {
	
	@Before
	public void before() {
		System.out.println("Before method start!");
	}
	
	//ReadURL Class
	@Test
	public void readStringJsonFromURLTest() throws IOException {
		
		// Test of function readStringJsonFromURL(), check that
		// function returned correct data
		
	    String url = "http://api.nbp.pl/api/cenyzlota/2018-01-02/?format=json";
	    String expectedResult = "[{\"data\":\"2018-01-02\",\"cena\":145.10}]";

        ReadURL readURL = new ReadURL();
        assertEquals(expectedResult, readURL.readStringJsonFromURL(url));
	}
	
	//CreateTableA Class
	@Test
	public void createTableClassTest() throws IOException {
		
		// Test Check that class CreateTableA correct generate tableA
		// and value of each element in List<tableA> is filled correctly.

        Calendar newCalendar = Calendar.getInstance();  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(newCalendar.getTime());
		String url = "http://api.nbp.pl/api/exchangerates/tables/A/"+ currentDate +"?format=json";

        ReadURL readURL = new ReadURL();
		String json = readURL.readStringJsonFromURL(url);
		
		Gson gson = new Gson();
        Type type = new TypeToken<List<TableA>>() {
        }.getType();
        List<TableA> tableA = gson.fromJson(json, type);

        CreateTableA createTable = new CreateTableA();
        assertEquals(tableA.size() ,createTable.tableA.size());
        
        for (int i = 0; i < tableA.get(0).getRates().size(); i++) {
        	for (int j = 0; j < tableA.size(); j++) {
				assertEquals(tableA.get(j).getRates().get(i).getCode(),
				 createTable.tableA.get(j).getRates().get(i).getCode());
				assertEquals(tableA.get(j).getRates().get(i).getCurrency(),
				 createTable.tableA.get(j).getRates().get(i).getCurrency());
        	}
        }
	}
	
	
	

	@After
	public void after() {
		System.out.println("After method start!");
	}
	
}