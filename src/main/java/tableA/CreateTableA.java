package tableA;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CreateTableA {

    private String urlTableA = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
    public List<TableA> tableA; //private


    public CreateTableA() {
        try {
            this.deserializationTableAfromJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserializationTableAfromJson() throws IOException {
        ReadURL url = new ReadURL();
        String json = url.readStringJsonFromURL(urlTableA);

        Gson gson = new Gson();
        Type type = new TypeToken<List<TableA>>() {
        }.getType();

        tableA = gson.fromJson(json, type);
    }

    public void showCodeAndCurency() {
        for (int i = 0; i < tableA.get(0).getRates().size(); i++) {
            System.out.println(tableA.get(0).getRates().get(i).getCode() +
                    " --> " +
                    tableA.get(0).getRates().get(i).getCurrency());
        }
    }


}


