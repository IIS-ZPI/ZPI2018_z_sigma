import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Helper {
	
	public static Collection<Object[]> data(String path) throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		JsonParser parser = new JsonParser();
		JsonObject rawJson = (JsonObject) parser.parse(new FileReader(path));
		Object[] keys = rawJson.keySet().toArray();
		for(Object key : keys) {
			JsonObject json = rawJson.getAsJsonObject((String) key);
			data.add(new Object[] {json});
		}
		return data;
	}

}
