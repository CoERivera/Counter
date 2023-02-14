package com.christopherrivera.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}
		else {
			Integer currentCount =  (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
}
