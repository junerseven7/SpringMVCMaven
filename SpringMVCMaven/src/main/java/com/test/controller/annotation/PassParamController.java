package com.test.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.User;

@Controller
@RequestMapping("/pass")
public class PassParamController {

	@RequestMapping("/dataSubmit")
	public String formParamSubmit(HttpServletRequest res, HttpServletResponse req, String userName, String password) {
		System.out.println("username = " + userName);
		System.out.println("password = " + password);

		res.setAttribute("username", userName);
		res.setAttribute("password", password);

		return "formParamSubmit";
	}

	@RequestMapping("/domainDataSubmit")
	public String formParamDomainSubmit(HttpServletRequest res, HttpServletResponse req, User user) {
		System.out.println("user.getUsername = " + user.getUsername());
		System.out.println("user.getPassword = " + user.getPassword());

		res.setAttribute("user.getUsername", user.getUsername());
		res.setAttribute("user.getPassword", user.getPassword());

		return "formParamDomainSubmit";
	}

}
