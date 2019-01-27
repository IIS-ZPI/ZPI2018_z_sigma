package tableA;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CreateTableA {

    private String urlTableA = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
    private List<TableA> tableA;


    public CreateTableA() {
        try {
            this.deserializationTableAfromJson(urlTableA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CreateTableA(String url) {
        try {
            this.deserializationTableAfromJson(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserializationTableAfromJson(String jsonURL) throws IOException {
        ReadURL url = new ReadURL();
        String json = url.readJsonFromURL(jsonURL);

        Gson gson = new Gson();
        Type type = new TypeToken<List<TableA>>() {
        }.getType();

        tableA = gson.fromJson(json, type);
    }

    public List<String> getCode(){
        List<String> listCode = new ArrayList<>();

        for (int i = 0; i < tableA.get(0).getRates().size(); i++){
            listCode.add(i , tableA.get(0).getRates().get(i).getCode());
        }
        return listCode;
    }

    public void showCodeAndCurency() {
        for (int i = 0; i < tableA.get(0).getRates().size(); i++) {
            System.out.println(tableA.get(0).getRates().get(i).getCode() +
                    " --> " +
                    tableA.get(0).getRates().get(i).getCurrency());
        }
    }


}


