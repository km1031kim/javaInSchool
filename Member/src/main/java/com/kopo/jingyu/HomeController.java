package com.kopo.jingyu;

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

		return "main";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		ComDB db = new ComDB();
		db.createTable();
		model.addAttribute("msg", "직원 테이블이 생성되었습니다");
		return "message";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertMethod(Locale locale, Model model) {

		return "insert";
	}
	

	@RequestMapping(value = "/insert_action", method = RequestMethod.GET)
	public String insertAction(Locale locale, Model model, 
			@RequestParam("worker_name") String name,
			@RequestParam("sex") String sex, 
			@RequestParam("address") String address,
			@RequestParam("part") String part) {
		ComDB db = new ComDB();
		db.insertData(name, sex, address, part);
		model.addAttribute("msg", "직원정보 입력 완료");
		return "message";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMethod(Locale locale, Model model) {
		ComDB db = new ComDB();
		String listString = db.selectData();
		model.addAttribute("list", listString);
		return "list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMethod(Locale locale, Model model,
			@RequestParam("idx") int idx) {
		ComDB db = new ComDB();
		Worker tempWorker = db.detailsData(idx);
		model.addAttribute("idx", tempWorker.idx);
		model.addAttribute("name", tempWorker.name);
		model.addAttribute("sex", tempWorker.sex);
		model.addAttribute("address", tempWorker.address);
		model.addAttribute("part", tempWorker.part);
	
		return "update";
	}
	
	@RequestMapping(value = "/update_action", method = RequestMethod.GET)
	public String updateAction(Locale locale, Model model,
			@RequestParam("idx") int idx,
			@RequestParam("worker_name") String name,
			@RequestParam("sex") String sex, 
			@RequestParam("address") String address,
			@RequestParam("part") String part) {
		
		ComDB db = new ComDB();
		db.updateData(idx, name, sex, address, part);
		model.addAttribute("msg", "수정완료");
		return "message";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteMethod(Locale locale, Model model,
			@RequestParam("idx") int idx) {
		ComDB db = new ComDB();
		Worker tempWorker = db.detailsData(idx);
		model.addAttribute("idx", tempWorker.idx);
		model.addAttribute("name", tempWorker.name);
		model.addAttribute("sex", tempWorker.sex);
		model.addAttribute("address", tempWorker.address);
		model.addAttribute("part", tempWorker.part);
	
		return "delete";
	}
	
	@RequestMapping(value = "/delete_action", method = RequestMethod.GET)
	public String updateAction(Locale locale, Model model,
			@RequestParam("idx") int idx) {
		
		ComDB db = new ComDB();
		db.deleteData(idx);
		model.addAttribute("msg", "삭제완료");
		return "message";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Locale locale, Model model) {

		return "search";
	}

	
	@RequestMapping(value = "/search_action", method = RequestMethod.GET)
	public String searchMethod(Locale locale, Model model,
			@RequestParam("worker_name") String name) {
		
		ComDB db = new ComDB();
		String temp = db.searchData(name);
		
		
		if (temp != null) {
			model.addAttribute("list", temp);
			return "searchResult";
		}
		
		else {
			model.addAttribute("msg", "대상없음");
			return "message";
		}
	
		
	}
	
	
	

}
