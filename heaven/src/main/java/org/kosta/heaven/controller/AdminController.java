package org.kosta.heaven.controller;

import javax.annotation.Resource;
import org.kosta.heaven.model.service.AdminService;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@Resource
	private AdminService adminService;
	
	/**
	* 작성이유 : 사이트 문의 목록보기
	* 
	* @author 용다은
	*/
	@RequestMapping("admin/readAllQuestionList.do")
	public String readWebQuestionList(int nowPage, Model model) {
		QuestionPostListVO qListVO = adminService.readQuestionList(nowPage);
		model.addAttribute("qListVO", qListVO);
		return "admin/readAllQuestionList.tiles";
	}
}
