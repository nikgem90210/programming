package faltu;

import java.util.ArrayList;
import java.util.List;
public class SublistExample {

 public static void main(String a[]){
     ArrayList<String> al = new ArrayList<String>();

     //Addition of elements in ArrayList
     al.add("Steve");
     al.add("Justin");
     al.add("Ajeet");
     al.add("John");
     al.add("Arnold");
     al.add("Chaitanya");
     al.add("Vivek");
     al.add("Anuj");
     al.add("Nishant");
     al.add("Anshul");

     System.out.println("Original ArrayList Content: "+al);

     //Sublist to ArrayList
     ArrayList<String> al2 = new ArrayList<String>(al.subList(0, 5));
     System.out.println("SubList stored in ArrayList: "+al2);

//     //Sublist to List
//     List<String> list = al.subList(1, 4);
//     System.out.println("SubList stored in List: "+list);
  }
}
