package com.kopo.kopo;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

	@RequestMapping(value = "/createResidentTable", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		ResidentDB db = new ResidentDB();

		boolean isSuccess = db.createDB();
		if (isSuccess) {
			model.addAttribute("m1", "테이블이 생성되었습니다.");
		} else {
			model.addAttribute("m1", "테이블이 이미 존재합니다.");
		}
		return "message";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertMethod(Locale locale, Model model) {
		
		ResidentDB db = new ResidentDB();
		String result = db.apartNameList();
		model.addAttribute("apartNameList", result);
		return "insert";
	}

	@RequestMapping(value = "/insert_action", method = RequestMethod.POST)
	public String insertAction(HttpServletRequest request, Locale locale, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		String sex = request.getParameter("sex");
		String apartment = request.getParameter("apart");

		int age = Integer.parseInt(ageStr);

		ResidentDB db = new ResidentDB();
		Resident resident = new Resident(name, age, sex, apartment);
		boolean isSuccess = db.insertResident(resident);
		if (isSuccess) {
			model.addAttribute("m1", "데이터 입력 완료");
		} else {
			model.addAttribute("m1", "데이터 입력 실패");
		}
		return "message";

	}

	@RequestMapping(value = "/residentList", method = RequestMethod.GET)
	public String toListPage(HttpServletRequest request, Locale locale, Model model) {
		ResidentDB db = new ResidentDB();
		String result = db.selectResident();

		model.addAttribute("list", result);

		return "list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMemo(HttpServletRequest request, Locale locale, Model model,
			@RequestParam("idx") int residentIdx) {

		ResidentDB db = new ResidentDB();
		Resident resident = new Resident();
		resident = db.searchDetails(residentIdx);

		model.addAttribute("idx", resident.idx);
		model.addAttribute("name", resident.name);
		model.addAttribute("age", resident.age);
		model.addAttribute("sex", resident.sex);

		return "update";

	}

	@RequestMapping(value = "/update_action", method = RequestMethod.POST)
	public String updateAction(HttpServletRequest request, Locale locale, Model model) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		String idxStr = request.getParameter("idx");
		String new_age_str = request.getParameter("age");

		int idx = Integer.parseInt(idxStr);
		String new_name = request.getParameter("name");
		int new_age = Integer.parseInt(new_age_str);
		String new_sex = request.getParameter("sex");

		ResidentDB db = new ResidentDB();

		boolean isSuccess = db.updateResident(idx, new_name, new_age, new_sex);

		if (isSuccess) {
			model.addAttribute("m1", "정보 수정 완료");
		} else {
			model.addAttribute("m1", "정보 수정 실패");
		}
		return "message";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, @RequestParam("idx") int idx) {

		ResidentDB db = new ResidentDB();
		boolean isSuccess = db.deleteResident(idx);
		if (isSuccess) {
			model.addAttribute("m1", "데이터가 삭제되었습니다.");
		} else {
			model.addAttribute("m1", "데이터 삭제에 실패하였습니다.");
		}
		return "message";
	}
	
	@RequestMapping(value = "/avg", method = RequestMethod.GET)
	public String avgPage(Locale locale, Model model) {

		ResidentDB db = new ResidentDB();
		String result = db.residentAvg();

		model.addAttribute("list", result);

		return "avg";
	}
	
	@RequestMapping(value = "/createApartmentTable", method = RequestMethod.GET)
	public String createApartmentTable(Locale locale, Model model) {
		ResidentDB db = new ResidentDB();
		boolean isSucess = db.createApartTable();
	
		if (isSucess) {
			model.addAttribute("m1", "아파트 테이블 생성 완료");
		} else {
			model.addAttribute("m1", "이미 아마트 테이블이 있습니다.");
		}
		return "message";
	}
	
	@RequestMapping(value = "/insertApart", method = RequestMethod.GET)
	public String insertApart(Locale locale, Model model) {
	
		return "insertApartInfo";
	}
	
	@RequestMapping(value = "/apart_insert", method = RequestMethod.GET)
	public String apartInfoInsert(Locale locale, Model model, @RequestParam("name") String name) {
		Apartment apart = new Apartment(name);
		ResidentDB db = new ResidentDB();
		boolean isSucess = db.insertApart(apart);
		
		if (isSucess) {
			model.addAttribute("m1", "새 아파트 입력 완료");
		} else {
			model.addAttribute("m1", "아파트 입력 실패.");
		}
		return "message";
	}
	
	@RequestMapping(value = "/apartList", method = RequestMethod.GET)
	public String apartList(HttpServletRequest request, Locale locale, Model model) {
		ResidentDB db = new ResidentDB();
		Apartment apart = new Apartment();
		
		String result = db.selectApartment();

		model.addAttribute("list", result);

		return "apartList";
	}
	
	@RequestMapping(value = "/updateApart", method = RequestMethod.GET)
	public String updateApartName(HttpServletRequest request, Locale locale, Model model,
			@RequestParam("idx") int apartIdx) {

		ResidentDB db = new ResidentDB();
		Apartment apart = new Apartment();
		apart = db.searhApart(apartIdx);

		model.addAttribute("idx", apart.idx);
		model.addAttribute("name", apart.name);


		return "updateApart";

	}
	
	@RequestMapping(value = "/apart_update", method = RequestMethod.GET)
	public String updateApartAction(Locale locale, Model model, @RequestParam("name") String name
			, @RequestParam("apartIdx") int idx) {
	
		
     
	
		ResidentDB db = new ResidentDB();

		boolean isSuccess = db.updateApartmentInfo(idx, name);

		if (isSuccess) {
			model.addAttribute("m1", "아파트 정보 수정 완료");
		} else {
			model.addAttribute("m1", "아파트 정보 수정 실패");
		}
		return "message";
	}
	
	@RequestMapping(value = "/deleteApart", method = RequestMethod.GET)
	public String deleteApart(Locale locale, Model model, @RequestParam("idx") int idx) {

		ResidentDB db = new ResidentDB();
		boolean isSuccess = db.deleteApartment(idx);
		if (isSuccess) {
			model.addAttribute("m1", "아파트가 삭제되었습니다.");
		} else {
			model.addAttribute("m1", "아파트 삭제에 실패하였습니다.");
		}
		return "message";
	}
	
	@RequestMapping(value = "/apartAvg", method = RequestMethod.GET)
	public String apartAvg(Locale locale, Model model) {

		ResidentDB db = new ResidentDB();
		String result = db.apartInfoPrint();

		model.addAttribute("list", result);

		return "apartMemberInfo";
	}


}
