package org.employee.crud.interceptors;

import java.time.LocalDate;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class TestInterceptor implements Interceptor {
	public void init() {};
	public void destroy() {};
	
	public String intercept(ActionInvocation ai) throws Exception {
		ValueStack stack = ai.getStack();
		LocalDate myObj = LocalDate.now();
		System.out.println(myObj);
		return ai.invoke();
	}
}
