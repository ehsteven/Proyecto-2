import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CrearJson {
    public CrearJson() {
    }

    public void crearJson(StringBuffer json){
        try(FileWriter file = new FileWriter("Json.json")){
            file.write(json.toString());
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println(json);
    }
}
