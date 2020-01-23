package com.ccs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	@RequestMapping("/abc")
	public String abc() {
		return "index.html";
	}
}
