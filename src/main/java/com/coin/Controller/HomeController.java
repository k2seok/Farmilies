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

import com.coin.dao.UserDAO;

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

//		String id = "";
//
//		if (request.getCookies().length > 0) {
//			Cookie[] cookies = request.getCookies();
//			for (int i = 0; i < cookies.length; i++) {
//				cookies[i].getName().equals("id");
//				if (cookies[i].getName().equals("id")) {
//					id = cookies[i].getValue();
//					break;
//				}
//				// TODO view change
//			}
//		}
//
//		if (id.length() > 0) {
////			Object obj = request.getAttribute("comment");
////			System.out.println(obj.toString());
//		}

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

	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String board_map(HttpServletRequest request, HttpServletResponse response) {

		
		response.addHeader("map_x", "0.5");
		response.addHeader("map_y", "1.5");
		return "map";
	}
	
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(HttpServletRequest request, HttpServletResponse response) {
		// TODO �α��μ����� main_login, fail �� �ٽ� redirect

		String id = request.getParameter("user_id").toString();
		System.out.println(id);

		String pw = request.getParameter("user_pw").toString();

		// TODO user select() ȣ��
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

	
	//일꾼이 자신이 일한 내역을 보는 곳
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String goMypage(Locale locale, Model model) {

		return "mypage";
	}

	//계약하는 부분
	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public String contracts(Locale locale, Model model) {

		return "contract";
	}
	
	
	
	//전체조회(농부가 올린거를 관리자가 조회)
	@RequestMapping(value = "/selectList", method = RequestMethod.GET)
	public String selectAll(Locale locale, Model model) {

		return "select";
	}
	
	//일할 곳 검색 및 조회(농부가 올린거를 일꾼이 조회)
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchAll(Locale locale, Model model) {

		return "search";
	}
	
	
	//등록 및 수정하는 곳(농부가 자신이 게시물을 올리고, 수정하는 부분)
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String insert_farmer(HttpServletRequest request, Model model) {

			UserDAO user = new UserDAO();
			
//			Collection<?> attributeValues = user.getListByIDLike("");
//			model.addAllAttributes(attributeValues);
			return "index";
		}
	
	/*
	@RequestMapping(value = "/board_write", method = RequestMethod.GET)
	public String board_write(Locale locale, Model model) {

		return "board_write";
	}*/
	
	
	
	
}
