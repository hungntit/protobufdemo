import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
public class TestProtoc {
  public static void main(String[] args)throws Exception{
    FileOutputStream output = new FileOutputStream("/tmp/java_person.txt");
    MessageProtobuf.Person person  = MessageProtobuf.Person.newBuilder().setName("Ta Van Lu").setOld(18).build();
    System.out.println("Object:\n\tName:\t"+ person.getName()+"\n\tOld:\t"+ person.getOld());
    System.out.println("Writing object to /tmp/cplus_person.txt");
    person.writeTo(output);
    output.close();
    MessageProtobuf.Person readPerson =  MessageProtobuf.Person.newBuilder().mergeFrom(new FileInputStream("/tmp/java_person.txt")).build();
    System.out.println("Reading object from /tmp/cplus_person.txt");
    System.out.println("Object:\n\tName:\t"+ readPerson.getName()+"\n\tOld:\t"+ readPerson.getOld());

    byte[] bytes = person.toByteArray();
    MessageProtobuf.Person.parseFrom(bytes);
    long t1 = System.currentTimeMillis();
    for(int i =0;i<100000;i++){
      person.toByteArray();
    }
    long t2 = System.currentTimeMillis();
    for(int i =0;i<100000;i++){
       MessageProtobuf.Person.parseFrom(bytes);
    }
    long t3 = System.currentTimeMillis();
    long serialized_time = t2-t1;
    long deserialized_time = t3 - t2;
    System.out.println("Serializing Time:\t"+ serialized_time+"\nDeserializing Time:\t"+deserialized_time);
    System.out.println("Size package:\t"+ bytes.length);
  }
}
