package com.kopo.first;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController { // 주소창 입력 세팅

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String home(Locale locale, Model model) {

		return "main";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String list(Locale locale, Model model) {
//		model.addAttribute("name", ${name} );
//		model.addAttribute("score", "안녕하세요~~!!" );
		return "list";
		
		
	}
	
		
	@RequestMapping(value = "/create_table", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String createTable(Locale locale, Model model) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/s1.db", "student"); // 해당 경로에 s.db파일 생성(지정), 테이블 이름.
		db.createTable(new Student()); // 제네릭 안에 객체 데이터
		return "message";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String insert(Locale locale, Model model) {
		return "insert";
	}
	
	@RequestMapping(value = "/insert_action", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String insert_action(Locale locale, Model model,
			@RequestParam("student_name") String name,
			@RequestParam("score") String scoreString) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/s1.db", "student");
		
		int score = Integer.parseInt(scoreString);
		db.insertData(new Student(name, score));
		return "insert"; 
		
		
	}
	
	
	


}
