package com.kopo.score;

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
import org.springframework.web.bind.annotation.RequestPart;

import com.kopo.score.DBCommon;
import com.kopo.score.Student;

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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/scoreDB.db", "score2");
		ArrayList<Student> student = db.selectArrayList(new Student());
		String htmlString = "";

		for (int i = 0; i < student.size(); i++) {
			htmlString = htmlString + "<tr>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).idx;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).name;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).midScore;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).finScore;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + student.get(i).created;
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + "<a href='verify?idx=" + student.get(i).idx + "'>수정하기</a>";
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "<td>";
			htmlString = htmlString + "<a href='delete?idx=" + student.get(i).idx + "'>삭제하기</a>";
			htmlString = htmlString + "</td>";
			htmlString = htmlString + "</tr>";

		}
		model.addAttribute("list", htmlString);

		return "list";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Locale locale, Model model) {

		return "insert";

	}

	@RequestMapping(value = "/insert_action", method = RequestMethod.GET)
	public String insert_action(Locale locale, Model model, @RequestParam("student_name") String name,
			@RequestParam("midScore") String SmidScore, @RequestParam("finScore") String SfinScore) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/scoreDB.db", "score2");
		int midScore = Integer.parseInt(SmidScore);
		int finScore = Integer.parseInt(SfinScore);
		String now = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		db.insertData(new Student(name, midScore, finScore, now));

		model.addAttribute("msg", "성적 입력 완료");
		return "message";
	}

	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/scoreDB.db", "score2");
		db.createTable(new Student());
		model.addAttribute("msg", "테이블이 생성되었습니다");
		return "message";
	}

	// 이름과 점수 확인 url
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verifyMethod(Locale locale, Model model,
			 @RequestParam("idx") int idx) {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/scoreDB.db", "score2");
		Student selectStudent = db.detailsData(new Student(), idx);
		if(selectStudent != null) {
			model.addAttribute("idx", selectStudent.idx);
			model.addAttribute("studentName", selectStudent.name);
			model.addAttribute("middleScore", selectStudent.midScore);
			model.addAttribute("finalScore", selectStudent.finScore);
		}
		return "verify";
	}

	// 수정 url
	@RequestMapping(value = "/verify_action", method = RequestMethod.GET)
	public String verify_action(Locale locale, Model model, 	
			@RequestParam("idx") int idx,
			@RequestParam("student_name") String sName,
			@RequestParam("midScore") String SmidScore, 
			@RequestParam("finScore") String SfinScore) {
		
		int midScore = Integer.parseInt(SmidScore);
		int finScore = Integer.parseInt(SfinScore);
		
		String now = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/scoreDB.db", "score2");
		db.updateData(new Student(idx, sName, midScore, finScore, now));
		

		model.addAttribute("msg", "데이터가 수정되었습니다.");
		return "message";

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteMethod(Locale locale, Model model,
			 @RequestParam("idx") int idx) throws SQLException {
		DBCommon<Student> db = new DBCommon<Student>("c:/tomcat/scoreDB.db", "score2");
		Student selectStudent = db.detailsData(new Student(), idx);
	
		
		db.deleteData(selectStudent);
		model.addAttribute("msg", "데이터가 삭제되었습니다.");
		return "message";
	}


}
