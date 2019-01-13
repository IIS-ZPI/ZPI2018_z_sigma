import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadStringFromURL {
    private String stringFromURL;

    public String getJsonFormat() {
        return stringFromURL;
    }

    ReadStringFromURL(String url) throws IOException {
        stringFromURL = readStringFromURL(url);
    }

    public static String readStringFromURL(String requestURL) throws IOException
    {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(), StandardCharsets.UTF_8.toString()))
        {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}
