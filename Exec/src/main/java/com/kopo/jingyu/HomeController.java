package com.kopo.jingyu;


import java.util.Date;
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
		logger.info("Welcome home! The client locale is {}.", locale);

		return "home";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createMethod(Locale locale, Model model) {
		JGDB db = new JGDB();
		db.createTable();

		model.addAttribute("msg", "테이블 생성 완료");
		return "message";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertMethod(Locale locale, Model model) {
	
		return "insert";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listData(Locale locale, Model model) {
		JGDB db = new JGDB();
		String listString = db.selectData();
		
		model.addAttribute("list", listString);
		return "list";
	}

	@RequestMapping(value = "/insert_action", method = RequestMethod.GET)
	public String insertActionMethod(Locale locale, Model model, 
			@RequestParam("student_name") String name,
			@RequestParam("middleScore") String middleScoreString, 
			@RequestParam("finalScore") String finalScoreString){
		
		double middleScore = Double.parseDouble(middleScoreString);
		double finalScore = Double.parseDouble(finalScoreString);
		
		JGDB db = new JGDB();
		db.insertData(name, middleScore, finalScore);

		model.addAttribute("msg", "정보 입력 완료");
		return "message";
	}
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMethod(Locale locale, Model model,
			@RequestParam("idx") int idx) {
		JGDB db = new JGDB();
		Student selectStudent = db.detailsData(idx);
		
		if(selectStudent != null) {
			model.addAttribute("idx", selectStudent.idx);
			model.addAttribute("name", selectStudent.name);
			model.addAttribute("middleScore", selectStudent.middleScore);
			model.addAttribute("finalScore", selectStudent.finalScore);
		}
		
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
		
		 
	
		
		return "update";
	}
}
