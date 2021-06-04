package com.kopo.login;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
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

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		UserDB userDB = new UserDB();
		userDB.createDB();
		boolean isSuccess = userDB.createDB();
		if (isSuccess) {
			model.addAttribute("m1", "테이블이 생성되었습니다.");
		} else {
			model.addAttribute("m1", "DB Error");
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
		Member member = new Member(id, pwd, name, birthday, address, now, now);

		UserDB userDB = new UserDB();
		boolean isSuccess = userDB.insertDB(member);
		if (isSuccess) {
			model.addAttribute("m1", "데이터가 입력되었습니다.");
		} else {
			model.addAttribute("m1", "아이디가 중복되었거나 DB에 이상이 있습니다.");
		}
		return "message";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMethod(HttpServletRequest request, Locale locale, Model model) {
		HttpSession session = request.getSession();
		try {
			boolean isLogin = (Boolean) session.getAttribute("is_login");

			if (isLogin) {
				UserDB db = new UserDB();
				String htmlString = db.selectData();
				model.addAttribute("list", htmlString);

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
	public String updateMethod(HttpServletRequest request, Locale locale, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		try {
			boolean isLogin = (Boolean) session.getAttribute("is_login");

			if (isLogin) {
				// 로그인 되어있는 경우 update 가능.
				String id = (String) session.getAttribute("login_id");
				String notHashedPwd = (String) session.getAttribute("login_pwd");
				String hasPwd = sha256(notHashedPwd);
				// 이름으로 검색, 해당되는 유저 정보를 가져온다.
				UserDB userDB = new UserDB();

				Member resultData = new Member();
				resultData = userDB.searchDetails(id, hasPwd); // 종료해야한다.
				// System.out.println(resultData.name);

				model.addAttribute("id", id);
				model.addAttribute("original_pwd", notHashedPwd);
				model.addAttribute("original_name", resultData.name);
				model.addAttribute("original_address", resultData.address);

				return "update";
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

	@RequestMapping(value = "/update_action", method = RequestMethod.POST)
	public String updateAction(HttpServletRequest request, Locale locale, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());
		UserDB userDB = new UserDB();
		HttpSession session = request.getSession();

		// 현재 비밀번호와 세션 비밀번호, 두 비밀번호가 같아야 변경이 가능!
		String notHashedPwd = (String) session.getAttribute("login_pwd");
		String original_pwd = request.getParameter("pwd");
		// System.out.println(notHashedPwd);

		if (notHashedPwd.equals(original_pwd)) {
			// 비밀번호가 일치한다. 정보 변경 가능

			String id = (String) session.getAttribute("login_id");
			String new_pwd = request.getParameter("new_pwd");
			String new_name = request.getParameter("new_name");
			String new_address = request.getParameter("new_address");

			boolean isSuccess = userDB.updateData(id, new_pwd, new_name, new_address, now);
			if (isSuccess) {
				session.invalidate();
				session = request.getSession();
				session.setAttribute("is_login", true);
				session.setAttribute("login_id", id);
				session.setAttribute("login_pwd", new_pwd);
				model.addAttribute("m1", "수정완료");
				return "message";
			}

			else {
				model.addAttribute("m1", "수정 실패");
				return "message";
			}

		} else {
			model.addAttribute("m1", "현재 비밀번호가 다릅니다.");
			return "message";
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, @RequestParam("idx") int idx) {

		UserDB userDB = new UserDB();
		boolean isSuccess = userDB.deleteData(idx);
		if (isSuccess) {
			model.addAttribute("m1", "데이터가 삭제되었습니다.");
		} else {
			model.addAttribute("m1", "데이터 삭제에 실패하였습니다.");
		}
		return "message";
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String selectMethod(Locale locale, Model model) {
		return "select";
	}

	@RequestMapping(value = "/select_action", method = RequestMethod.GET)
	public String selectAction(Locale locale, Model model, @RequestParam("name") String name) {
		UserDB userDB = new UserDB();
		String htmlString = userDB.searchData(name);
		model.addAttribute("list", htmlString);
		return "list";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginMethod(Locale locale, Model model) {
		return "login";
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

		UserDB userDB = new UserDB();
		boolean isSuccess = userDB.loginDB(id, pwd);
		if (isSuccess) {
			HttpSession session = request.getSession();

			session.setAttribute("is_login", true);
			session.setAttribute("login_id", id);
			session.setAttribute("login_pwd", pwd);
			return "redirect:/";
		}
		return "redirect:/login";
	}

	public String sha256(String msg) { // 비밀번호 암호화
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(msg.getBytes());

			StringBuilder builder = new StringBuilder();
			for (byte b : md.digest()) {
				builder.append(String.format("%02x", b));
			}
			return builder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
