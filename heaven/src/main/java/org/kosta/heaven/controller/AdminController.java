package org.kosta.heaven.controller;

import javax.annotation.Resource;

import org.kosta.heaven.model.service.AdminService;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@Resource
	private AdminService adminService;
	
	/**
	* 
	* 사이트 전체 문의 목록보기
	* 
	* @author 용다은
	*/
	@RequestMapping("admin/readAllQuestionList.do")
	public String readAllQuestionList(int nowPage, Model model) {
		QuestionPostListVO qListVO = adminService.readAllQuestionList(nowPage);
		model.addAttribute("qListVO", qListVO);
		return "admin/readAllQuestionList.tiles";
	}
	
	/**
	* 
	* 사이트 문의 상세보기
	* 
	* @author 용다은
	*/
	@RequestMapping("admin/readQuestionDetail.do")
	public String readQuestionDetail(int qNo,Model model) {
		QuestionPostVO qVO = adminService.readQuestionDetail(qNo);
		model.addAttribute("qVO", qVO);
		return "admin/readQuestionDetail.tiles";
	}
}
