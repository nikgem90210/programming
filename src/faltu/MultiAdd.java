package faltu;

class MultiAdd {

/*	public static void main(String[] args) {
		
		double res = multAdd(1.0, 2.0, 3.0);
		System.out.println(res);
		
	}
	
	public static double multAdd(double x, double y, double z){
		double res = x*y+z;
		return res;
		
	}*/
	
	public static void main(String[] args) {
		boolean flag1 = isHoopy(202);
		boolean flag2 = isFrabjuous(202);
		System.out.println(flag1);
		System.out.println(flag2);
		if (flag1 && flag2) {
			System.out.println("ping!");
		}
		if (flag1 || flag2) {
			System.out.println("pong!");
		}
	}
	public static boolean isHoopy(int x) {
		boolean hoopyFlag;
		if (x%2 == 0) {
			hoopyFlag = true;
		} else {
			hoopyFlag = false;
		}
		return hoopyFlag;
	}
	public static boolean isFrabjuous(int x) {
		boolean frabjuousFlag;
		if (x > 0) {
			frabjuousFlag = true;
		} else {
			frabjuousFlag = false;
		}
		return frabjuousFlag;
	}

	
}
