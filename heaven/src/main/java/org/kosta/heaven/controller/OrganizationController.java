package org.kosta.heaven.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.heaven.model.service.UserService;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrganizationController {
	@Resource
	private UserService userService;
	
	@RequestMapping("users/readMyTakingList.do")
	public ModelAndView readMyTakingList(int nowPage,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		UserVO uvo = (UserVO) session.getAttribute("uvo");
		JoinPostListVO jpListVO=userService.readMyTakingList(uvo.getId(),nowPage);
		System.out.println("나의 테이킹 목록 : "+jpListVO);
		return new ModelAndView("users/readMyActivityList.tiles","jpList",jpListVO);
	}
}
