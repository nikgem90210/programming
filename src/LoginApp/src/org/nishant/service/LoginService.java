package LoginApp.src.org.nishant.service;

import java.util.HashMap;

import com.amazonaws.services.identitymanagement.model.User;

public class LoginService {
	
	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService(){
		users.put("nishant", "Nishant P");
		users.put("vivek", "Vivek K");
		users.put("ranjan", "Ranjan V");
	}	
	public boolean authenticate(String userId, String password){
		
		if(password == null || password.trim() == ""){
			return false;
		}
		return true;
	}
	public User getUserDetails(String userId){
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
	}

}
