import java.util.ArrayList;
import dao.*;
import froc.*;
import bean.*;
import java.util.List;
import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.*;
import com.google.gson.internal.bind.*;
public class Test {
	public static void main(String[] args){
	
		OraBookDao bookdao = new OraBookDao();
		List booklist = bookdao.getAllBook();
		Gson gson = new Gson();
		//Convert java object (array) to Json Syntax (String)  1

		// JsonArray jarray = gson.toJsonTree(booklist).getAsJsonArray();
  //       JsonObject jsonObject = new JsonObject();
  //       jsonObject.add("booklist", jarray);

  //      	String json =jsonObject.toString();



		//Convert java object (array) to Json Syntax (String) 2
		String json = gson.toJson(booklist);


		System.out.println(json);

		// Convert Json array to java Array  1
		// EbBookBean[] booklistfromJson = gson.fromJson(json,EbBookBean[].class);



		// Convert Json array to java Array  2
		Type bookType = new TypeToken<ArrayList<EbBookBean>>(){}.getType();
		ArrayList<EbBookBean> booklistfromJson = gson.fromJson(json,bookType);
		for(EbBookBean book : booklistfromJson) {
    		System.out.println(book.getBook_name());
		}
	}
}