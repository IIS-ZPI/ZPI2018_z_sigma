package tableA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ReadURL {


    public String readStringJsonFromURL(String adressURL) throws IOException {
        URL readUrl = new URL(adressURL);
        BufferedReader in = new BufferedReader(new InputStreamReader(readUrl.openStream(), StandardCharsets.UTF_8.toString()));

        String readJson;
        String allJson = "";

        while ((readJson = in.readLine()) != null) {
            allJson += readJson;
        }

        in.close();

        return allJson;
    }
}
