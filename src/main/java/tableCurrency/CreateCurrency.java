package tableCurrency;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import tableA.ReadURL;

import java.io.IOException;
import java.lang.reflect.Type;

public class CreateCurrency {

    private TableForCurrency tableCurrency;


    public TableForCurrency getTableCurrency() {
        return tableCurrency;
    }


    public int[] changeOfsession() {

        int[] Data = new int[3];
       // Data[0] = 0; Data[1] = 0; Data[2] = 0;

        for (int i = 0; i < tableCurrency.getRates().size() - 1; i++) {

            if (tableCurrency.getRates().get(i).getMid() < tableCurrency.getRates().get(i + 1).getMid()) {
                Data[0] += 1;
            } else if (tableCurrency.getRates().get(i).getMid() > tableCurrency.getRates().get(i + 1).getMid()) {
                Data[1] += +1;  //Check this place, +1 was 
            } else {
                Data[2] += 1;
            }
        }
        
        return Data;
    }


    public void deserializationCurrencyfromJson(String startDate, String endDate, String code) throws IOException {

        String urlAdress = "http://api.nbp.pl/api/exchangerates/rates/A/" + code + "/" + startDate + "/" + endDate + "/";
        ReadURL url = new ReadURL();
        String json = url.readJsonFromURL(urlAdress);
        Gson gson = new Gson();
        Type type = new TypeToken<TableForCurrency>() {
        }.getType();

        tableCurrency = gson.fromJson(json, type);
    }

}
