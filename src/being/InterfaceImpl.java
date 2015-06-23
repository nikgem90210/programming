package being;


interface interface1{
	public void impl1();
}

interface interface2{
	public void impl2();
}


class InterfaceImpl implements interface1, interface2 {

	@Override
	public void impl1() {
		
	}

	@Override
	public void impl2() {
		// TODO Auto-generated method stub
		
	}

}

abstract class InterfacesImpl implements interface1{
	
}	

class impl extends InterfacesImpl{

	@Override
	public void impl1() {
		
		
	}

}

interface interface3 extends interface1,interface2{
	
	public void impl3();
	
}

class inter implements interface3{

	@Override
	public void impl1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void impl2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void impl3() {
		// TODO Auto-generated method stub
		
	}
	
}