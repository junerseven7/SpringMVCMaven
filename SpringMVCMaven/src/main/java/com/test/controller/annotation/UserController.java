package com.test.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/annotation")
public class UserController {

	@RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
	public ModelAndView addUser() {
		System.out.println("addUser");
		String result = "addUser";
		return new ModelAndView("/annotation", "result", result);
	}

	@RequestMapping("/user/deleteUser")
	public String deleteUser(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteUser");
		String result = "deleteUser";
		req.setAttribute("result", result);
		return "/annotation";
	}
}
