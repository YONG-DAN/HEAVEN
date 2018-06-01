package org.kosta.heaven.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.kosta.heaven.model.service.UserService;
import org.kosta.heaven.model.vo.user.UserGroupVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.review.ReviewListVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	* 회원가입 메서드
	* 
	* UserVO를 받아와서 db에 저장시킨다.
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="users/registerUser.do")
	public String registerUser(UserVO vo, String place, String uGroupNo) {
		//hidden으로 받은 uGroupNo 값을 UserGroupVO에 넣음
		UserGroupVO ugvo = new UserGroupVO(uGroupNo, null);
		//생성된 UserGroupVO를 UserVO에 set
		vo.setUserGroupVO(ugvo);
		//지도 api와 name을 통일하기 위해 place라는 매개변수로 받은 address 값을 userVO에 set해줌
		vo.setAddress(place);
		//위에서 set된 내용을 토대로 완성된 vo를 db에 저장시킴
		userService.registerUser(vo);
		//home.do로 redirect
		return "redirect:/home.do";
	}
	
	/**
	* 아이디를 중복체크 하는 메서드
	* 
	* 아이디를 받아와서 db에 같은 아이디가 있는지 확인하고
	* 결과에 따라 ajax로 사용 가능 여부를 나타냄
	* 
	* @author 용다은
	*/
	@RequestMapping("users/checkId.do")
	@ResponseBody
	public String checkId(String id) {
		UserVO uvo = userService.checkId(id);
		if(uvo != null) {// 아이디가 이미 존재한다면
			return "fail";
		} else // 아이디가 아직 존재하지 않는다면
			return "ok";
	}
	
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
		}else if (uvo.getUserGroupVO().getUgroupNo().equals("3")) { //미승인 단체가 로그인 하는 경우
			return "users/loginFail.tiles";
		}else if(uvo.getUserGroupVO().getUgroupNo().equals("5")) {//탈퇴회원이 로그인하는 경우
			return "users/loginFail.tiles";
		}else { //정상적으로 로그인 하는 경우	
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
	/**
	* 작성이유 : 일반회원 수정 메서드
	* 
	* @author 백설희
	*/
	@RequestMapping(method=RequestMethod.POST, value="users/updateUserInfoForm.do")
	public String updateUserInfo(HttpServletRequest request,UserVO vo,String place) {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("uvo")==null){
			return "users/loginForm.tiles";
		}
		vo.setAddress(place);
		userService.updateUserInfoForm(vo);
		session.setAttribute("uvo", userService.checkId(vo.getId()));
		return "users/mypage.tiles";
	}
	/**
	* 작성이유 : 나의 후기목록 보기
	* 
	* @author 백설희
	*/
	@RequestMapping("users/readMyReviewList.do")
	public ModelAndView readMyReviewList(HttpServletRequest request,int nowPage) {
		HttpSession session = request.getSession(false);
		UserVO uvo = (UserVO) session.getAttribute("uvo");
		ReviewListVO rListVO=userService.readMyReviewPostList(uvo.getId(),nowPage);
		return new ModelAndView("users/myReviewList.tiles","rListVO",rListVO);
	}
	
}
