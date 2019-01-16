import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CreateTableA{

   private String urlTableA = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
   private List<TableA> tableA;

    public List<TableA> getTableA() {
        return tableA;
    }

    public CreateTableA() {
        try {
            this.deserializationTableAfromJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializationTableAfromJson() throws IOException {
        ReadURL url = new ReadURL();
        String json = url.readStringJsonFromURL(urlTableA);

        Gson gson = new Gson();
        Type type = new TypeToken<List<TableA>>() {
        }.getType();

        tableA = gson.fromJson(json, type);
    }

}


