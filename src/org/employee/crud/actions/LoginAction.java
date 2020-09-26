package org.employee.crud.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.employee.crud.models.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>,SessionAware {
	
	public User user = new User();
	private SessionMap<String,Object> sessionMap;  
	
	public void validate() {
		if(!user.getEmail().equals("dineshpabbi10@gmail.com")) {
			addFieldError("email","Email is incorrect");
		}
		if(!user.getPassword().equals("welcome")) {
			addFieldError("password","Password is incorrect");
		}
    }
	
	public String execute() {
			System.out.println(user.getEmail());
			this.sessionMap.put("email", user.getEmail());
			return SUCCESS;
	}
	
	public User getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = (SessionMap<String,Object>) arg0;  
	}
}
