package advanced.mar_29;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class JSONDECODE {

  public static void main(String[] args) {


    String s = "{\"category\": \"pagevisit\", \"subcategory\": \"homepage\", \"ga\": {\"ga_present\": true, \"events\": [{\"clientId\": \"1219526787.1680180147\", \"trackingId\": \"UA-182856875-1\", \"name\": \"gtag_UA_182856875_1\"}, {\"clientId\": \"1219526787.1680180147\", \"trackingId\": \"UA-48972824-1\", \"name\": \"gtm8\"}], \"dl\": [{\"clientId\": \"1219526787.1680180147\", \"measurementId\": \"UA-182856875-1\"}, {\"measurementId\": \"AW-627387422\"}], \"gtm\": [{\"clientId\": \"1219526787.1680180147\", \"measurementId\": \"G-V4XSBWYFS2\"}]}, \"client_ga_data\": {\"event_name\": \"OTT_homepage_view\"}, \"document_data\": {\"host\": \"www.davidchristensenlaw.com\", \"hostname\": \"www.davidchristensenlaw.com\", \"pathname\": \"/\", \"href\": \"https://www.davidchristensenlaw.com/\"}}\n";

    try{
      JSONParser parser = new JSONParser();
      Object obj = parser.parse(s);
      JSONObject obj1 = (JSONObject)obj;
      JSONObject obj2 = (JSONObject)obj1.get("client_ga_data");
      System.out.println("The 2nd element of array"+obj2.get("ga_event_name"));
      System.out.println("The 2nd element of array"+obj2.get("ga_event_action"));
      JSONObject obj3 = (JSONObject)obj1.get("document_data");
      System.out.println("The 2nd element of array"+obj3.get("href"));
     // System.out.println(array.get(1));
      System.out.println();

     /* System.out.println(obj2.get("1"));

      s = "{}";
      obj = parser.parse(s);
      System.out.println(obj);

      s = "[5,]";
      obj = parser.parse(s);
      System.out.println(obj);

      s = "[5,,2]";
      obj = parser.parse(s);
      System.out.println(obj);*/
    }catch(ParseException pe) {

      System.out.println("position: " + pe.getPosition());
      System.out.println(pe);
    }
  }
}