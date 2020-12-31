package com.col.domein;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping("/error.do")
	public String error(Model model, @RequestParam(required = false) String msg,
			@RequestParam(required = false) String loc, @RequestParam(required = false) String locDesc) {
		if (msg != null && !msg.equals(""))
			model.addAttribute("msg", msg);
		if (loc != null && !loc.equals(""))
			model.addAttribute("loc", loc);
		if (locDesc != null && !locDesc.equals(""))
			model.addAttribute("locDesc", locDesc);
		else {
			locDesc = "돌아가기";
			model.addAttribute("locDesc", locDesc);
		}
		return "common/error";
	}
}
