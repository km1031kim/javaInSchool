package com.kopo.first;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
public class HomeController { // 주소창 입력 세팅
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("a1", "안녕하세요~~!!" );
		
		return "home";
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET) // /page로 입력했을때 p1파일 리턴.
	public String page(Locale locale, Model model) {
			
		return "p1";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET) // db입력.
	public String create(Locale locale, Model model) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/s1.db", "student"); // 해당 경로에 s.db파일 생성(지정), 테이블 이름.
		db.createTable(new Student()); // 제네릭 안에 객체 데이터
		return "p1";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET) // 
	public String insert(Locale locale, Model model) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/s1.db", "student"); 
		db.insertData(new Student("홍길동", 100)); 
		return "p1";
	}
	
}
	