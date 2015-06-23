package being;

import java.util.Date;

public final class IAmImmutable {

	private Integer id;
	private String name;
	private Date currentDate;
	
	private IAmImmutable(Integer id, String name, Date currentDate){
		this.id = id;
		this.name = name;
		this.currentDate = currentDate;
	}
	
	public static IAmImmutable getInstance(Integer fld1, String fld2, Date fld3){
		return new IAmImmutable(fld1, fld2, fld3);
	}
	
	public Integer getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public Date getCurrentDate(){
		return new Date(currentDate.getTime());
	}
}

