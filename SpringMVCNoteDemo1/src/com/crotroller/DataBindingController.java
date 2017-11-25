package com.crotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataBindingController {

	//映射视图名（通过路径设置变量）
	@RequestMapping(value="{formName}")
	public String pathVariableTest(@PathVariable String formName){
		return formName;
	}
	@RequestMapping(value="requestHeader")
	public String requestHeader(@RequestHeader("User-Agent") String userAgent,
			@RequestHeader(value="Accept") String[] accepts){
		System.out.println("requestHeader:"+userAgent);
		
		for (String accept : accepts) {
			System.out.println(accept);
		}
		return "test";
	}
	@RequestMapping(value="cookieValue")
	public String cookieValue(@CookieValue(value="JSESSIONID",defaultValue="") String sessionid){
		System.out.println(sessionid);
		return "test";
	}
}
