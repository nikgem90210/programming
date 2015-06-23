package faltu;

//public class Time{
//	int hour , minute;
//	double second;
//	
//	public Time(){
//		this.hour=0;
//		this.minute=0;
//		this.second=0.0;
//	}
//	public Time(int hour, int minute, double second){
//		this.hour=hour;
//		this.minute=minute;
//		this.second=second;
//	}
//	public static void main(String args[]){
//		Time currentTime = new Time(9,31,30.0);
//		Time reqTime = new Time(3, 35, 31.0);
//		Time totTime = addTime(currentTime, reqTime);
//		printTime(totTime);
//	}
//	
//	public static void printTime(Time m){
//		System.out.println(m.hour+":"+m.minute+":"+m.second);
//	}
//	
//	public static Time addTime(Time t1, Time t2){
//		Time sum = new Time();
//		sum.hour = t1.hour + t2.hour;
//		sum.minute = t1.minute + t2.minute;
//		sum.second = t1.second + t2.second;
//		if (sum.second >= 60.0){
//			sum.second -= 60.0;
//			sum.hour += 1;
//		}
//		if(sum.minute >= 60){
//			sum.minute -=60;
//			sum.minute += 1;
//		}
//		return sum;
//		
//	}
//	
//}

public class Time
{
		  public static void main(String args[]) {
		    Integer iobj1 = new Integer(5);
		    Integer iobj2 = new Integer("6");
		    int i1 = iobj1.intValue();
		    int i2 = iobj2.intValue();
		    System.out.println("i1 = " + i1);
		    System.out.println("i2 = " + i2);
		  }
		   
}





