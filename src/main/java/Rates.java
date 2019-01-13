public class Rates {
    public String no, effectiveDate, currency, code;
    public float mid, bid, ask;

    @Override
    public String toString() {
        return  isNotNull(mid) +
                isNotNull(currency) +
                isNotNull(code) +
                isNotNull(no) +
                isNotNull(effectiveDate);
    }

    public String isNotNull(Object obj){
        return obj == null ? "" : obj.toString() + " ";
    }
}
