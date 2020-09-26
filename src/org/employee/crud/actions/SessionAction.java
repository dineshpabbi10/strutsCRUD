package org.employee.crud.actions;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class SessionAction extends ActionSupport{
	
	HttpSession session = ServletActionContext.getRequest().getSession(false);  
	
	public String execute() {
		if(session != null && session.getAttribute("email") != null ) {
			return "redirect";
		}
		else {
			return SUCCESS;
		}
	}

}
