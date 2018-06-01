package com.coin.Controller;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response) {

		String id = "";

		if (request.getCookies().length > 0) {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				cookies[i].getName().equals("id");
				if (cookies[i].getName().equals("id")) {
					id = cookies[i].getValue();
					break;
				}
				// TODO view change
			}
		}

		if (id.length() > 0) {
			Object obj = request.getAttribute("comment");
			System.out.println(obj.toString());
		}

		return "main";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String singup(Locale locale, Model model) {

		return "signup";
	}

	@RequestMapping(value = "/board_write", method = RequestMethod.GET)
	public String board_write(Locale locale, Model model) {

		return "board_write";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인성공시 main_login, fail 시 다시 redirect

		String id = request.getParameter("user_id").toString();
		System.out.println(id);

		String pw = request.getParameter("user_pw").toString();

		// TODO user select() 호출
		boolean success = true;
		if (success) {
			// setMaxAge is day hour min sec
			//
			Cookie c = new Cookie(id, pw);
			c.setMaxAge(60 * 60);
			// response.addCookie(new Cookie() -> { );
			// TODO Onchain create id value
			// response.addCookie(new Cookie("count", count));

		} else {

			return "main";
		}

		return home(request, response);
	}

}
