import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;

public class JSONWorker {
    public void saveToJSONFile(Person person, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonSt = gson.toJson(person);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(gsonSt);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Person loadFromJSON(File file) {
        Gson gson = new Gson();
        Person person = null;
        try {
            person = gson.fromJson(new FileReader(file), Person.class);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
