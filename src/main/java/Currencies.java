import java.util.List;

public class Currencies {
    public String table, currency, code, no, effectiveDate;

    private static final String space = " ";

    public List<Rates> rates;

    @Override
    public String toString() {
        return  isNotNull(table) +
                isNotNull(currency) +
                isNotNull(code) +
                isNotNull(no) +
                isNotNull(effectiveDate);
    }

    public String isNotNull(Object obj){
        return obj == null ? "" : obj.toString() + space;
    }
}
