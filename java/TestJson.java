import com.google.gson.Gson;
public class TestJson {
  public static void main(String[] args)throws Exception{
    Gson gson = new Gson();
    PersonJson person = new PersonJson("Ta Van Lu",18);
    String json = gson.toJson(person);
    PersonJson person2 = gson.fromJson(json,PersonJson.class);
    String json2 = gson.toJson(person2);
    System.out.println(json);


    long t1 = System.currentTimeMillis();
    for(int i =0;i<100000;i++){
      gson.toJson(person);
    }
    long t2 = System.currentTimeMillis();
    for(int i =0;i<100000;i++){
       gson.fromJson(json,PersonJson.class);
    }
    long t3 = System.currentTimeMillis();
    long serialized_time = t2-t1;
    long deserialized_time = t3 - t2;
    System.out.println("Serializing Time:\t"+ serialized_time+"\nDeserializing Time:\t"+deserialized_time);
    System.out.println("Size package:\t"+ json.getBytes().length);
  }
}
