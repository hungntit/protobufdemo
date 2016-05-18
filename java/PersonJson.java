public class PersonJson {
 public String name;
 public int old;
  public PersonJson(){
    name = null;
    old =0;
  }
 public PersonJson(String name, int old){
   this.name = name;
   this.old = old;
 }
 public String getName(){
   return this.name;
 }
 public int getOld(){
   return this.old;
 }
}
