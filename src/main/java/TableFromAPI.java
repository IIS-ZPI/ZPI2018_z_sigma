import com.google.gson.Gson;

import java.io.IOException;

public class TableFromAPI {
    public static final String tableA = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";


    public TableFromAPI() throws IOException {
        String jsonAsString = new ReadStringFromURL(tableA).getJsonFormat();
        Gson gson = new Gson();
        Currencies currencies = gson.fromJson(jsonAsString.substring(1, jsonAsString.length() - 1), Currencies.class);
        System.out.println(currencies.toString() + currencies.rates.toString());
        currencies.rates.forEach(value -> System.out.println(value));
    }
}
