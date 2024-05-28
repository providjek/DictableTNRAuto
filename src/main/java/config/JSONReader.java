package config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    private String filePath;

    public JSONReader(String filePath) {
        this.filePath = filePath;
    }
    //edte

    public String readJSONValue(String key){
        JSONParser jsonP = new JSONParser();
        try {
            JSONObject jsonO = (JSONObject)jsonP.parse(new FileReader(this.filePath));
            return (String) jsonO.get(key);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        } catch (
                ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
}
