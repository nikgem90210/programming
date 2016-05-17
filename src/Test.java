import com.amazonaws.HttpMethod;


//public class Test {
//
//
//	public static void main(String[] args) {
//		
//		Screen.print();
//		
//	}
//	
//	
//}
//
//
//class Screen {
//	
//	public static void print() {
//		System.out.println("Static method from Parent class");
//	}
//	
//}
//
//class ColorScreen extends Screen{
//	
//	public static void print(){
//		System.out.println("Overridden static method in Child Class in Java");
//    }
//	
//}
	
public class Test {

//    static{
//        System.out.println("Static");
//    }
//
//    {
//        System.out.println("Non-static block");
//    }

    public static void main(String[] args) {
//        Test t = new Test();
//        Test t2 = new Test();

//    	System.out.println(HttpMethod.POST.toString());
    	System.out.println(getExcelColumnName(55));
    	
    }
    
    
    
    public static String getExcelColumnName (int columnNumber) 
    {     
        int dividend = columnNumber;   
        int i;
        String columnName = "";     
        int modulo;     
        while (dividend > 0)     
        {        
            modulo = (dividend - 1) % 26;         
            i = 65 + modulo;
            columnName = new Character((char)i).toString() + columnName;
//            columnName = (char)(i + 'A') + columnName;
            dividend = (int)((dividend-modulo) / 26);    
        }       
        return columnName; 
    }  
    
}

