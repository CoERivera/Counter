package com.christopherrivera.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}

		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount++;
		session.setAttribute("count", currentCount);
		
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "counter.jsp";
	}
	
	@RequestMapping("/by_two")
	public String byTwo(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount+= 2;
		session.setAttribute("count", currentCount);
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		
		return "counter.jsp";
	}
}
