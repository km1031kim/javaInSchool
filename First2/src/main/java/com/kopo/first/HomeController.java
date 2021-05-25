package com.kopo.first;

import java.sql.SQLException;
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
	public String list(Locale locale, Model model) throws SQLException {
//		model.addAttribute("name", ${name} );
//		model.addAttribute("score", "안녕하세요~~!!" );
		UserDB db = new UserDB();
		String htmlString = db.selectData();
		model.addAttribute("list", htmlString);
		return "list";

	}

	@RequestMapping(value = "/create_table", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String createTable(Locale locale, Model model) {
//		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/p500.db", "student"); // 해당 경로에 s.db파일 생성(지정), 테이블 이름.
//		db.createTable(new Student()); // 제네릭 안에 객체 데이터
		UserDB db = new UserDB();
		db.createTable();
		model.addAttribute("m1", "테이블이 생성되었씁니다");
		return "message";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String insert(Locale locale, Model model) {
		return "insert";
	}

	@RequestMapping(value = "/insert_action", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String insert_action(Locale locale, Model model, 
		@RequestParam("student_name") String name, 
		@RequestParam("middleScore") String middleScoreString,
		@RequestParam("finalScore") String finalScoreString) { 
		// integer로 받을때, 스트링으로 들어오면 서버 터짐. 후에 인티져로 파싱

		UserDB db = new UserDB();
		double middelScore = Double.parseDouble(middleScoreString);
		double finalScore = Double.parseDouble(finalScoreString);
		db.insertData(name, middelScore, finalScore);
		model.addAttribute("m1", "데이터가 입력되었씁니다");
		return "message";

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String updateMethod(Locale locale, Model model, 
		@RequestParam("idx") int idx) { 
		// integer로 받을때, 스트링으로 들어오면 서버 터짐. 후에 인티져로 파싱

		UserDB db = new UserDB();
		Student selectStudent = db.detailsData(idx);
		
		
		if(selectStudent != null) {
			model.addAttribute("idx", selectStudent.idx);
			model.addAttribute("studentName", selectStudent.name);
			model.addAttribute("middleScore", selectStudent.middleScore);
			model.addAttribute("finalScore", selectStudent.finalScore);
		}
		
	
		return "update";

	}
	
	@RequestMapping(value = "/update_action", method = RequestMethod.GET) // 아무것도 입력 안했을때
	public String updateAction(Locale locale, Model model, 
		@RequestParam("idx") int idx,
		@RequestParam("student_name") String sName,
		@RequestParam("middleScore") String middleScoreString,
		@RequestParam("finalScore") String finalScoreString) { 
		

		UserDB db = new UserDB();
		double middleScore = Double.parseDouble(middleScoreString);
		double finalScore = Double.parseDouble(finalScoreString);
		db.updateData(idx, sName, middleScore, finalScore);
		
		model.addAttribute("m1", "데이터가 수정되엇씁니다");
	
		return "message";

	}
	
	
	
	
	
	
	

}
