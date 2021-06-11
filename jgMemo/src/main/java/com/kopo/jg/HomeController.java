package com.kopo.jg;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String home(Locale locale, Model model) {

		return "main";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		MemoDB memoDB = new MemoDB();
		boolean isSuccess = memoDB.createTable();
		if (isSuccess) {
			model.addAttribute("m1", "테이블이 생성되었습니다.");
		} else {
			model.addAttribute("m1", "테이블이 이미 존재합니다");
		}
		return "message";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertMethod(Locale locale, Model model) {
		return "insert";
	}

	@RequestMapping(value = "/insert_action", method = RequestMethod.POST)
	public String insertAction(HttpServletRequest request, Locale locale, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());
		User user = new User(id, pwd, name, birthday, address, now);

		boolean isSuccess = MemoDB.insertDB(user);
		if (isSuccess) {
			model.addAttribute("m1", "데이터가 입력되었습니다.");
		} else {
			model.addAttribute("m1", "아이디가 중복되었거나 DB에 이상이 있습니다.");
		}
		return "message";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		try {
			boolean isLogin = (Boolean) session.getAttribute("is_login");

			if (isLogin) {
				session.invalidate();
				model.addAttribute("m1", "로그아웃 완료");
				return "message";
			} else {
				model.addAttribute("m1", "로그인이 필요합니다.");
				return "message";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("m1", "로그인이 필요합니다.");
			return "message";
		}
	}

	@RequestMapping(value = "/login_action", method = RequestMethod.POST)
	public String loginAction(HttpServletRequest request, Locale locale, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemoDB memoDB = new MemoDB();

//		boolean isSuccess = userDB.loginDB(id, pwd);
		int userIdx = memoDB.loginDB(id, pwd);
		if (userIdx > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("is_login", true);
			session.setAttribute("user_idx", userIdx);
			return "redirect:/";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/insertMemo", method = RequestMethod.GET)
	public String memoInsert(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		try {
			boolean isLogin = (Boolean) session.getAttribute("is_login");

			if (isLogin) {

				return "memoPage";
			} else {
				model.addAttribute("m1", "로그인이 필요합니다.");
				return "message";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("m1", "로그인이 필요합니다.");
			return "message";
		}
	}

	@RequestMapping(value = "/memo_insert", method = RequestMethod.POST)
	public String memoInsertAction(HttpServletRequest request, Locale locale, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String title = request.getParameter("subject");
		String content = request.getParameter("contents");

		int loginedIdx = (Integer) session.getAttribute("user_idx");

		// 인덱스는 가져왔으니 이제 memo랑 idx를 연결시키자.
		MemoDB memo = new MemoDB();
		User currentUser = new User();
		currentUser = memo.selectInfo(loginedIdx);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());
		// 이제 해당 유저 정보와 메모의 내용, 제목을 db에 넣자.

		boolean isSucess = memo.insertMemo(title, content, now, now, loginedIdx);

		if (isSucess) {
			model.addAttribute("m1", "메세지 입력 성공");
			return "message";
		} else {
			model.addAttribute("m1", "메세지 입력 실패");
			return "message";
		}

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		try {
			boolean isLogin = (Boolean) session.getAttribute("is_login");

			if (isLogin) {
				MemoDB memo = new MemoDB();
				int loginedIdx = (Integer) session.getAttribute("user_idx");
				model.addAttribute("userIdx", loginedIdx);
				String result =  memo.memoList(loginedIdx);
				model.addAttribute("list", result);
				return "list";
			} else {
				model.addAttribute("m1", "로그인이 필요합니다.");
				return "message";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("m1", "로그인이 필요합니다.");
			return "message";
		}

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMemo(HttpServletRequest request, Locale locale, Model model,
			@RequestParam("idx") int memoIdx) {
		HttpSession session = request.getSession();
		try {
			boolean isLogin = (Boolean) session.getAttribute("is_login");

			if (isLogin) {
				MemoDB memo = new MemoDB();
				int loginedIdx = (Integer) session.getAttribute("user_idx");
			
				// 내일하자
				Memo temp = new Memo();
				temp = memo.selectMemo(loginedIdx, memoIdx);
				
				model.addAttribute("title", temp.title);
				model.addAttribute("content", temp.content);
				model.addAttribute("idx", temp.idx);
				model.addAttribute("userIdx", temp.userIdx);
				
				
				return "updateMemo";
			} else {
				model.addAttribute("m1", "로그인이 필요합니다.");
				return "message";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("m1", "로그인이 필요합니다.");
			return "message";
		}

	}

}
