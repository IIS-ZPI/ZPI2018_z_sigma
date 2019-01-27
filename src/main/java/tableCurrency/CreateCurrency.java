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


    public void changeOfsession() {

        int up = 0, down = 0, constant = 0;

        for (int i = 0; i < tableCurrency.getRates().size() - 1; i++) {

            if (tableCurrency.getRates().get(i).getMid() < tableCurrency.getRates().get(i + 1).getMid()) {
                up += 1;
            } else if (tableCurrency.getRates().get(i).getMid() > tableCurrency.getRates().get(i + 1).getMid()) {
                down += +1;
            } else {
                constant += 1;
            }
        }

        System.out.println("ilość sesji wzrostowych: " + up);
        System.out.println("ilość sesji spadkowych: " + down);
        System.out.println("ilość sesji bez zmian: " + constant);

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
