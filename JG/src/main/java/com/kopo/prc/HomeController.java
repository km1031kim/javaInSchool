package com.kopo.prc;


import java.util.Locale;

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
	
		return "home";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createMethod(Locale locale, Model model) {
		JGDB db = new JGDB();
		db.createTable();
		model.addAttribute("msg", "테이블이 생성되었씁니다");
		return "message";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertMethod(Locale locale, Model model) {

		return "insert";
	}
	
	@RequestMapping(value = "/insert_action", method = RequestMethod.GET)
	public String insertAction(Locale locale, Model model,
			@RequestParam("student_name") String name,
			@RequestParam("middleScore") String middleString,
			@RequestParam("finalScore") String finalString) {
		
		double middleScore = Double.parseDouble(middleString);		
		double finalScore = Double.parseDouble(finalString);		
		JGDB db = new JGDB();
		db.insertData(name, middleScore, finalScore);
		
		

		model.addAttribute("msg", "데이터 입력 완료");
		return "message";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMethod(Locale locale, Model model) {
		JGDB db = new JGDB();
		String listString = db.selectData();
		
		model.addAttribute("list", listString);
		return "list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMethod(Locale locale, Model model,
			@RequestParam("idx") int idx) {
		JGDB db = new JGDB();
		Student tempStudent = db.detailsData(idx);
		model.addAttribute("idx", tempStudent.idx);
		model.addAttribute("name", tempStudent.name);
		model.addAttribute("middleScore", tempStudent.middleScore);
		model.addAttribute("finalScore", tempStudent.finalScore);
	
		return "update";
	}
	

	@RequestMapping(value = "/update_action", method = RequestMethod.GET)
	public String updateAction(Locale locale, Model model,
			@RequestParam("idx") int idx,
			@RequestParam("name") String name,
			@RequestParam("middleScore") String middleScoreString, 
			@RequestParam("finalScore") String finalScoreString) {
		
		JGDB db = new JGDB();
		double middleScore = Double.parseDouble(middleScoreString);
		double finalScore = Double.parseDouble(finalScoreString);
		db.updateData(idx, name, middleScore, finalScore);
		model.addAttribute("msg", "수정완료");
		return "message";
		
	
	
	}
	
	
}
