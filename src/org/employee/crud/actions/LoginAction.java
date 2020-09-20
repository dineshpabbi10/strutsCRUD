package org.employee.crud.actions;

import org.employee.crud.models.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {
	
	public User user = new User();
	
	public void validate() {
		if(!user.getEmail().equals("dineshpabbi10@gmail.com")) {
			addFieldError("email","Email is incorrect");
		}
		if(!user.getPassword().equals("welcome")) {
			addFieldError("password","Password is incorrect");
		}
    }
	
	public String execute() {
		return SUCCESS;
		
	}
	
	public User getModel() {
		return user;
	}
}
