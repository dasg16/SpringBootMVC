package com.das.learnings;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		System.out.println("I am at the home page");
		return "index";
	}

	// Using ModelAndView
	@RequestMapping("add")
	public ModelAndView addition(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		int num3 = i + j;

		session.setAttribute("num3", num3);
		System.out.println("Adding two numbers");
		return mv;
	}

	// Using Model
	@RequestMapping("minus")
	public String subtraction(@RequestParam("num1") int i, @RequestParam("num2") int j, Model model) {

		int num3 = i - j;
		model.addAttribute("num3", num3);
		System.out.println("Subtracting two numbers");
		return "result";
	}

	// Using ModelMap
	@RequestMapping("multi")
	public String multiplication(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap modelmap) {

		int num3 = i * j;
		modelmap.addAttribute("num3", num3);
		System.out.println("Multiplying two numbers");
		return "result";
	}

	// before Using ModelAttribute
	@RequestMapping("addUsers1")
	public String addUsers1(@RequestParam("fID") String i, @RequestParam("fName") String j, Model model) {

		Family family = new Family();
		family.setfID(i);
		family.setfName(j);
		model.addAttribute("num3", family);
		System.out.println("Added user details");
		return "result";
	}

	// Using ModelAttribute
	@RequestMapping("addUsers2")
	public String addUsers(@ModelAttribute Family family, Model model) {

		model.addAttribute("num3", family);
		System.out.println("Added user details");
		return "result";
	}

	// Another way of doing without Using ModelAttribute
	@RequestMapping("addUsers3")
	public String addUsers(@ModelAttribute("num3") Family family) {
		return "result";
	}

	// Another way of doing without Using ModelAttribute
	@RequestMapping("addUsers4")
	public String addUsers1(@ModelAttribute Family num3) {
		return "result";
	}

	// Another way of doing without Using ModelAttribute
	@RequestMapping("addUsers")
	public String addUsers2(Family num3) {
		return "result";
	}

	// Model attribute gets called first before calling RequestMapping
	@ModelAttribute
	public void assignName(Model model) {
		model.addAttribute("name", "Das");
	}

}
