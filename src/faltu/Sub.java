//package faltu;
//
//import java.io.File;
//import java.io.FileInputStream;
//
//public class Sub {
//
//	
//	
////	public static void main(String[] args) {
////
////		
////		        try
////		        {
////		            FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
////		 
////		            //Create Workbook instance holding reference to .xlsx file
////		            XSSFWorkbook workbook = new XSSFWorkbook(file);
////		 
////		            //Get first/desired sheet from the workbook
////		            XSSFSheet sheet = workbook.getSheetAt(0);
////		 
////		            //Iterate through each rows one by one
////		            Iterator<Row> rowIterator = sheet.iterator();
////		            while (rowIterator.hasNext()) 
////		            {
////		                Row row = rowIterator.next();
////		                //For each row, iterate through all the columns
////		                Iterator<Cell> cellIterator = row.cellIterator();
////		                 
////		                while (cellIterator.hasNext()) 
////		                {
////		                    Cell cell = cellIterator.next();
////		                    //Check the cell type and format accordingly
////		                    switch (cell.getCellType()) 
////		                    {
////		                        case Cell.CELL_TYPE_NUMERIC:
////		                            System.out.print(cell.getNumericCellValue() + "t");
////		                            break;
////		                        case Cell.CELL_TYPE_STRING:
////		                            System.out.print(cell.getStringCellValue() + "t");
////		                            break;
////		                    }
////		                }
////		                System.out.println("");
////		            }
////		            file.close();
////		        } 
////		        catch (Exception e) 
////		        {
////		            e.printStackTrace();
////		        }
////		    }
//		
//
////		String sub = "&";
////		String rex = "SO=";
////		String str = "SO=Vcode1:SongName:MovieName:ActorName:Language:SingerName;Vcode2:SongName:MovieName:ActorName:Language:SingerName&MO=Vcode3:SongName:MovieName:ActorName:Language:SingerName;Vcode4:SongName:MovieName:ActorName:Language:SingerName&NT=Vcode5:SongName:MovieName:ActorName:Language:SingerName;Vcode6:SongName:MovieName:ActorName:Language:SingerName";
////		
//////		response = str.substring(str.indexOf(sub) + sub.length(),str.length());
//////		System.out.println(response);
////		
//////		System.out.println(str.indexOf(sub) + sub.length());
//////		System.out.println(str.length());
////		
////		for(String res : str.split(sub)){
////			if(res.contains(rex)){
////				String response = res.substring(res.indexOf(rex) + rex.length(),res.length());
////				System.out.println(response);
////				
////			}
////			if(res.contains("MO=")){
////				String response = res.substring(res.indexOf("MO=") + "MO=".length(),res.length());
////				System.out.println(response);
////			}
////			if(res.contains("SI=")){
////				String response = res.substring(res.indexOf("SI=") + "SI=".length(),res.length());
////				System.out.println(response);
////			}
////			if(res.contains("AC=")){
////				String response = res.substring(res.indexOf("AC=") + "AC=".length(),res.length());
////				System.out.println(response);
////			}
////			if(res.contains("NT=")){
////				String response = res.substring(res.indexOf("NT=") + "NT=".length(),res.length());
////				System.out.println(response);
////			}
////			
//////			System.out.println(res);
////		}
//		
////		String sub = "Kabhi Dukhharta Banke, Kabhi Sukhkarta Banke";
////
////		String res[] = sub.split(" ");
////		
////		for(int i=0 ; i<res.length; i++){
////			System.out.print(res[i]);
////		}
//
//		
////		for(int i=0; i<sub.length(); i=i+20){  
////			  
////			String spLine = sub.substring(i, (20+i)); 
////		
////		System.out.println(spLine);
////		}
//	}
//		
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
