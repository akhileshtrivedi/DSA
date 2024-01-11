package dp;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadFromTheFileTest {


  public static void main(String[] args) {
    JSONParser parser = new JSONParser();
    try{

      Object obj = parser.parse(new FileReader("/Users//akhilesh.trivedi/Downloads/PS-683_attachments/aus_dmas.json"));

      JSONArray subjects = (JSONArray) obj;
     // JSONObject jsonObject = (JSONObject)obj;

     // String code = (String)jsonObject.get("code");

     // String name = (String)jsonObject.get("name");

     // String course = (String)jsonObject.get("Course");
      //JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
      //System.out.println("code: " + code);
     // System.out.println("name: " + name);

      Iterator iterator = subjects.iterator();
      while (iterator.hasNext()) {
        JSONObject jsonObject = (JSONObject)iterator.next();
       // System.out.println("here-->"+jsonObject);
         String name= jsonObject.get("name").toString();
         String code= jsonObject.get("code").toString();
         String country_code= jsonObject.get("country_code").toString();
       // System.out.println("name "+jsonObject.get("code"));
       // System.out.println("name "+jsonObject.get("country_code"));
       // String code = (String)jsonObject.get("code");
       // String name = (String)jsonObject.get("name");
        System.out.println("'"+code+", '"+name+"', '"+country_code+"' ;");
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
