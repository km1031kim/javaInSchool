package com.kopo.student;

import java.text.DateFormat;
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
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/student100.db", "student");
		db.createTable(new Student());
		model.addAttribute("message", "생성 메세지로변경!");
		return "message";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET) // 입력받는 페이지만 띄우기
	public String insert(Locale locale, Model model) {
		return "insert"; // insert.jsp 띄운다.
	}
	
	@RequestMapping(value = "/insert_action", method = RequestMethod.GET) // 페이지에서 액션 받아서 데이터 넣기.
	public String insertAction(Locale locale, Model model
					, @RequestParam("name") String name
					, @RequestParam("middle") String middle
					, @RequestParam("final") String finalString) {
		int middleNumber = Integer.parseInt(middle);
		int finalNumber = Integer.parseInt(finalString);
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/student100.db", "student");
		db.insertData(new Student(name, middleNumber, finalNumber));
		model.addAttribute("message", "삽입 메세지로 변경!");
		return "message";
	}
	
}
