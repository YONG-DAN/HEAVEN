package org.kosta.heaven.controller;

import javax.annotation.Resource;
import org.kosta.heaven.model.service.AdminService;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
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
	
	/**
	* 작성이유 : 총 신청서 목록보기
	* 
	* @author 백설희
	*/
	@RequestMapping("admin/readTotalJoinPostList.do")
	public String readTotalJoinPostList(int nowPage, Model model) {
		/*전체 재능기부리스트*/
		JoinPostListVO jpgListVO = adminService.totalGibuJoinPostList(nowPage);
		model.addAttribute("jpgListVO", jpgListVO);
		/*전체 테이킹리스트*/
		JoinPostListVO jptListVO=adminService.totalTakingJoinPostList(nowPage);
		model.addAttribute("jptListVO", jptListVO);
		return "admin/joinPostList.tiles";
	}
	/**
	* 작성이유 : 신청된 신청서 목록보기
	* 
	* @author 백설희
	*/
	@RequestMapping("admin/readApprovalJoinPostList.do")
	public String approvalTakingJoinPostList(int nowPage, Model model) {
		/*신청된 재능기부리스트*/
		JoinPostListVO jpgListVO = adminService.approvalGibuJoinPostList(nowPage);
		model.addAttribute("jpgListVO", jpgListVO);
		/*신청된 테이킹리스트*/
		JoinPostListVO jptListVO=adminService.approvalTakingJoinPostList(nowPage);
		model.addAttribute("jptListVO", jptListVO);
		return "admin/approvalTakingJoinPostList.tiles";
	}
	/**
	* 작성이유 : 처리중인 신청서 목록보기
	* 
	* @author 백설희
	*/
	@RequestMapping("admin/readUnapprovalJoinPostList.do")
	public String unapprovalTakingJoinPostList(int nowPage, Model model) {
		/*처리중인 재능기부리스트*/
		JoinPostListVO jpgListVO = adminService.unapprovalGibuJoinPostList(nowPage);
		model.addAttribute("jpgListVO", jpgListVO);
		/*처리중인 테이킹리스트*/
		JoinPostListVO jptListVO=adminService.unapprovalTakingJoinPostList(nowPage);
		model.addAttribute("jptListVO", jptListVO);
		return "admin/unapprovalTakingJoinPostList.tiles";
	}
	/**
	* 작성이유 : 거절된 신청서 목록보기
	* 
	* @author 백설희
	*/
	@RequestMapping("admin/readRefusalApprovalJoinPostList.do")
	public String refusalApprovalJoinPostList(int nowPage, Model model) {
		/*거절된 재능기부리스트*/
		JoinPostListVO jpgListVO = adminService.refusalGibuJoinPostList(nowPage);
		model.addAttribute("jpgListVO", jpgListVO);
		/*거절된 테이킹리스트*/
		JoinPostListVO jptListVO=adminService.refusalTakingJoinPostList(nowPage);
		model.addAttribute("jptListVO", jptListVO);
		return "admin/refusalApprovalJoinPostList.tiles";
	}
}
