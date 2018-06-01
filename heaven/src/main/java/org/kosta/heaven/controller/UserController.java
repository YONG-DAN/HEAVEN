package org.kosta.heaven.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.heaven.model.service.UserService;
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewListVO;
import org.kosta.heaven.model.vo.user.UserGroupVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.kosta.heaven.model.vo.user.UserGroupVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
		/**
	* 작성이유 : 나의 후기 상세보기
	* 
	* @author 백설희
	*/
	@RequestMapping("users/readMyReviewDetail.do")
	public String readMyReviewDetail(String rNo,Model model) {
		ReviewVO reviewVO=userService.readMyReviewDetail(rNo);
		model.addAttribute("reviewVO", reviewVO);
		return "users/readMyReviewDetail.tiles";
	}
	/**
	* 작성이유 : 내 후기 수정 폼으로 이동하기 위해
	* 
	* @author 백설희
	*/
	@RequestMapping("users/updateMyReviewForm.do")
	public String updateMyReviewForm(String rNo, Model model) {
		ReviewVO reviewVO=userService.readMyReviewDetail(rNo);
		model.addAttribute("reviewVO", reviewVO);
		return "users/updateMyReviewForm.tiles";
	}
	/**
	* 작성이유 : 내 후기 수정
	* 
	* @author 백설희
	*/
	@RequestMapping(method=RequestMethod.POST, value="users/updateMyReviewDetail.do")
	public String updateMyReviewDetail(ReviewVO rVO, Model model) {
		/*String rNo=Integer.toString(rVO.getrNo());
		ReviewVO reviewVO=userService.readMyReviewDetail(rNo);*/
		String rNo=Integer.toString(rVO.getrNo());
		userService.updateMyReviewDetail(rVO);
		ReviewVO reviewVO=userService.readMyReviewDetail(rNo);
		model.addAttribute("reviewVO", reviewVO);
		return "users/readMyReviewDetail.tiles";
	}
	/**
	 * 작성이유 : 후기 번호를 받아와서 
	 * 해당하는 후기를 삭제하기 위하여
	 * 
	 * 나의 후기 삭제하기
	 * 
	 * @author 백설희
	 */
	@RequestMapping("users/deleteMyReview.do")
	public String deleteMyReview(int rNo) {
		userService.deleteMyReview(rNo);
		return "redirect:/users/readMyReviewList.do?nowPage=1";
	}
	/**
	* 문의 게시판 게시글 작성
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="board/createQuestion.do")
	public String addWebQuestion(HttpServletRequest request, QuestionPostVO qpVO, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession(false);
		if(session==null||session.getAttribute("uvo")==null){
			return "users/loginForm.tiles";
		}
		//session -> UserVO로 회원 정보 저장
		UserVO uvo =  (UserVO) session.getAttribute("uvo");
		qpVO.setUserVO(uvo);
		//createQuestion
		userService.createQuestion(qpVO);
		//작성한 게시글을 바로 보여 주기 위해 qNo 부여함
		redirectAttributes.addAttribute("qNo", + qpVO.getqNo());
		return "redirect:/users/readMyQuestionDetail.do";
	}
	
	/**
	* 나의 문의 게시판 목록 보기
	* 
	* @author 용다은
	*/
	@RequestMapping("users/readMyQuestionList.do")
	public String readMyWebQuestionList(int nowPage, HttpServletRequest request, Model model) {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("uvo")==null){ //session 없는 경우 로그인 페이지로 보냄
			return "users/loginForm.tiles";
		}
		UserVO uvo = (UserVO) session.getAttribute("uvo");
		QuestionPostListVO qListVO = userService.readMyQuestionList(uvo.getId(), nowPage);
		model.addAttribute("qListVO", qListVO);
		return "users/readMyQuestionList.tiles";
	}
	
	/**
	* 나의 문의 게시판 게시글 상세 보기
	* 
	* @author 용다은
	*/
	@RequestMapping("users/readMyQuestionDetail.do")
	public String readWebQuestion(int qNo, Model model) {
		QuestionPostVO qPostVO=userService.readMyQuestionDetail(qNo);
		model.addAttribute("qPostVO", qPostVO);
		//답변완료 된 문의글인 경우 답변VO를 찾는 메서드
		/*	if(qPostVO.getqStatus().equals("답변완료")) {
			QuestionPostVO qAnswerVO = userService.readWebQuestionAnswer(qNo);
			//답변VO를 view로 보내줌
			model.addAttribute("qAnswerVO", qAnswerVO);
		}*/
		return "users/readMyQuestionDetail.tiles";
	}
	/**
	 * 작성이유 : 신청활동 신청을 위한 해당 재능기부의 신청날짜가져오기
	 * 
	 * 신청취소가능 날짜 가져오기
	 * 
	 * @author 백설희
	 */
	@RequestMapping("users/deleteMyActivity.do")
	public String deleteMyActivity(int rNo) {
		JoinPostVO joinPostVO=userService.selectMyJoinDate(rNo);
		String startDate=joinPostVO.getJpAppStartDate();
		String endDate=joinPostVO.getJpAppEndDate();
		/*오늘날짜를 int로 가져오기*/
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
		int today=Integer.parseInt(strToday);*/
		Date today= new Date();
	    SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date endday = transFormat.parse(endDate);
			Date startday = transFormat.parse(startDate);
			if(today.compareTo(startday)==1 || today.compareTo(startday)==0) {
	            if(today.compareTo(endday)==-1||today.compareTo(endday)==0) {
	            	userService.deleteMyActivity(rNo);
	            }else {
		        	 return "users/deleteFail.tiles";
		         }
	         }
		} catch (ParseException e) {
			e.printStackTrace();
		}  

		return "redirect:/users/readMyActivityList.do?nowPage=1";
	}
	

	
}
