package being;

//public class Student {
//
//	private Integer id;
//	private String name;
//	
//	public Student(Integer id, String name){
//		this.id = id;
//		this.name = name;
//		
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public boolean equal(Object obj){
//		if(obj instanceof Student && ((Student) obj).getId() == id && ((Student) obj).getName() == name){
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
//	
//}



import java.io.File;

public class Student {
   public static void main(String[] args) {
      
      File f = null;
      File f1 = null;
      String v;
      boolean bool = false;
      
      try{
         // create new file
         f = new File("/Users/nishant/suk");
         
         // returns abstract parent pathname
         f1 = f.getParentFile();
         System.out.println("Nishnat-----"+f1);
         
         // absolute path from abstract pathname
         v = f1.getAbsolutePath();
         
         // true if the file path exists
         bool = f.exists();
         
         // if file exists
         if(bool)
         {
            // prints
            System.out.print("Parent file path: "+v);
         }
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }
   }
}