import java.util.ArrayList;
import dao.*;
import froc.*;
import bean.*;
import java.util.List;
import com.google.gson.*;
public class Test {
	public static void main(String[] args){
	
		OraBookDao bookdao = new OraBookDao();
		List booklist = bookdao.getAllBook();
		Gson gson = new Gson();
		JsonArray jarray = gson.toJsonTree(booklist).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("booklist", jarray);

       	String json =jsonObject.toString();

		// Gson gson = new Gson();
		// String jsonuser = gson.toJson(booklist);
		System.out.println(json);

	}
}