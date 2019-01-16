package tableCurrency;

import java.util.List;

public class TableForCurrency {

    private String table;
    private String currency;
    private String code;
    private List<Rates> rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<Rates> getRates() {
        return rates;
    }
}

