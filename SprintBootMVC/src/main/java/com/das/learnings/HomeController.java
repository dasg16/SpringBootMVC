package com.das.learnings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		System.out.println("I am at the home page");
		return "index.jsp";
	}

	@RequestMapping("add")
	public String addition(HttpServletRequest req) {

		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int num3 = i + j;

		HttpSession session = req.getSession();
		session.setAttribute("num3", num3);
		System.out.println("Adding two numbers");
		return "result.jsp";
	}

}
