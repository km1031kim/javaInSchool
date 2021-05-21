package com.kopo.first;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/p500.db", "student");
		ArrayList<Student> student = db.selectArrayList(new Student());
		String htmlString = "";
	
		for(int i = 0; i< student.size(); i++) { 
			htmlString = htmlString + "<tr>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).idx;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).name;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).score;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).created;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "</tr>";
						
		}
		model.addAttribute("list", htmlString);
		
		return "list";
		
		
	}
	
		
	@RequestMapping(value = "/create_table", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String createTable(Locale locale, Model model) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/p500.db", "student"); // 해당 경로에 s.db파일 생성(지정), 테이블 이름.
		db.createTable(new Student()); // 제네릭 안에 객체 데이터
		model.addAttribute("m1", "테이블이 생성되었씁니다");
		return "message";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String insert(Locale locale, Model model) {
		return "insert";
	}
	
	@RequestMapping(value = "/insert_action", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String insert_action(Locale locale, Model model,
			@RequestParam("student_name") String name, // requestParam 주소창 쿼리의 내용을 담아 변수로 사용.
			@RequestParam("score") String scoreString) { // integer로 받을때, 스트링으로 들어오면 서버 터짐. 후에 인티져로 파싱
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/p500.db", "student");
		int score = Integer.parseInt(scoreString);
		String now = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		db.insertData(new Student(name, score, now));
		model.addAttribute("m1","데이터가 입력되었씁니다");
		return "message"; 
	
		
		
	}
	
	
	


}
