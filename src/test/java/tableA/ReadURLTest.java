package tableA;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReadURLTest {
    private String url = "http://api.nbp.pl/api/cenyzlota/2018-01-02/?format=json";
    private String expectedResult = "[{\"data\":\"2018-01-02\",\"cena\":145.10}]";

    @org.junit.Test
    public void readStringJsonFromURL() throws IOException {

        ReadURL readURL = new ReadURL();

        assertEquals(expectedResult, readURL.readJsonFromURL(url));
    }
}