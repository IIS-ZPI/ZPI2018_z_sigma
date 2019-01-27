package tableA;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CreateTableATest {
    private String url = "http://api.nbp.pl/api/exchangerates/tables/a/2019-01-02?format=json";

    private int expectedSize = 35;
    private String expectedCurrencyAt0 = "THB";
    private String expectedCurrencyAtEND = "XDR";

    @Test
    public void getCode() {
        CreateTableA createTableA = new CreateTableA();
        List<String> codeList = createTableA.getCode();

        assertEquals("createTableA.codeList size(): ", expectedSize, codeList.size());

        assertEquals("createTableA.codeList stringAt0: ",
                expectedCurrencyAt0, codeList.get(0));

        assertEquals("createTableA.codeList stringAtEND:",
                expectedCurrencyAtEND, codeList.get(expectedSize-1));
    }
}