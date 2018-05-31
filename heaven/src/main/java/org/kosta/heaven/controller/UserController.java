package org.kosta.heaven.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kosta.heaven.model.service.UserService;
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	/**
	* 로그인 메서드
	* 
	* 아이디를 기준으로 UserVO 정보를 뽑아오며 
	* 아이디 존재 여부를 확인하고, 탈퇴여부를 확인한다.
	* 비밀번호와 비교하여 로그인 폼에 작성한 내용과 일치여부를 파악한다.
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="users/login.do")
	public String login(UserVO vo, HttpServletRequest request) {
		UserVO uvo = userService.checkId(vo.getId());
		if(uvo == null ) { //아이디가 존재하지 않는 경우
			return "users/loginFail.tiles";
		}else{
			if(!vo.getPassword().equals(uvo.getPassword())) { //비밀번호가 일치하지 않는 경우
			return "users/loginFail.tiles";
		}
			else if(uvo.getUserGroupVO().getUgroupNo().equals("5")) {//탈퇴회원이 로그인하는 경우
			return "users/loginFail.tiles";
		}
		else { //정상적으로 로그인 하는 경우	
			request.getSession().setAttribute("uvo", uvo);
			return "home.tiles";
		}
		}
	}
	/**
	* 로그아웃 메서드
	* 
	* 아직 session이 유지되고 있는 경우, 
	* invalidate 시켜서 로그아웃 되게 함
	* 
	* @author 용다은
	*/
	@RequestMapping("users/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "home.tiles";
	}

	/**
	* 
	* 작성이유: 회원탈퇴 
	* 
	* @author 백설희
	*/
	@RequestMapping("users/deleteUser.do")
	public String deleteUser(Model model, HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession(false);
		if(session==null||session.getAttribute("uvo")==null){
			return "users/loginForm.tiles";
		}
		UserVO uvo =  (UserVO) session.getAttribute("uvo");
		userService.deleteMember(uvo.getId());
		if (session != null)
			session.invalidate();
		return "home.tiles";
	}
	/**
	* 회원 비밀번호 수정
	* 
	* @author 백설희
	*/
	@RequestMapping(method=RequestMethod.POST, value="users/updatePassword.do")
	public String updatePassword(String nowPassword, HttpServletRequest request, String newPassword) {
		HttpSession session=request.getSession(false);
		if (session==null||session.getAttribute("uvo")==null) {
			return "users/loginForm.tiles";
		}
		UserVO uvo=(UserVO) session.getAttribute("uvo");
		uvo.setPassword(newPassword);
		userService.updatePassword(uvo);
		if (session!=null)
			session.invalidate();
		return "users/loginForm.tiles";
	}
	/**
	* 작성이유 : 나의 재능기부 참여목록 
	* 
	* @author 백설희
	*/
	@RequestMapping("users/readMyActivityList.do")
	public ModelAndView readMyActivityList(int nowPage,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserVO uvo = (UserVO) session.getAttribute("uvo");
		ActivityListVO aListVO=userService.readMyActivityList(uvo.getId(),nowPage);
		return new ModelAndView("users/readMyActivityList.tiles","aListVO",aListVO);
	}
	/**
	* 작성이유 : 나의 재능기부 신청 내역
	* 
	* @author 백설희
	*/
	@RequestMapping("users/readMyApplicationList.do")
	public ModelAndView readMyApplicationList(int nowPage,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserVO uvo = (UserVO) session.getAttribute("uvo");
		JoinPostListVO jpListVO=userService.readMyApplicationList(uvo.getId(),nowPage);
		System.out.println("컨트롤러끝"+jpListVO);
		return new ModelAndView("users/readMyApplicationList.tiles","jpListVO",jpListVO);
	}
}
