package org.kosta.heaven.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.heaven.model.service.JoinService;
import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostGroupVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	@Resource
	private JoinService joinService;
	
	/**
	 * 신청하기
	 * 신청 form에 맞추어 작성된 신청서를 insert한다.
	 * 
	 * @author 조민경
	 * @param joinPostVO
	 * @return
	 * 
	 */	
	@RequestMapping(method=RequestMethod.POST, value="application.do")
	public String application(JoinPostVO joinPostVO, String jpGroupNo, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserVO uvo = null;
		// 참여 게시글 종류 번호
		JoinPostGroupVO joinPostGroupVO = new JoinPostGroupVO(jpGroupNo, null);
		if(session!=null) {
			uvo = (UserVO)session.getAttribute("uvo");
			if(uvo!=null)
				joinPostVO.setUserVO(uvo);
		}
		joinPostVO.setJoinPostGroupVO(joinPostGroupVO);
		joinService.application(joinPostVO);
		return "redirect:home.do";
	}
	
	/**
	 * 재능기부 목록
	 * 신청된 재능기부 중 승인이 된 재능기부에 대한 목록을 볼 수 있다.
	 * 
	 * @author 조민경
	 * @param nowPage
	 * @return
	 * 
	 */
	@RequestMapping("donation/readDonationList.do")
	public String readDonationList(int nowPage, Model model) {
		JoinPostListVO donationList = joinService.readDonationList(nowPage);
		model.addAttribute("donationList", donationList);
		return "donation/readDonationList.tiles";
	}
	
	/**
	 * 재능기부 상세
	 * 재능기부 목록에서 선택한 재능기부에 대한 상세 내용을 볼 수 있다.
	 * 
	 * @author 조민경
	 * @param jpNo
	 * @param model
	 * @return
	 */
	@RequestMapping("donation/readDonationDetail.do")
	public String readDonationDetail(int jpNo, Model model) {
		JoinPostVO donationVO = joinService.readDonationDetail(jpNo);
		model.addAttribute("donationVO",donationVO);
		return "donation/readDonationDetail.tiles";
	}
	
	/**
	 * 참여하기
	 * 특정 재능기부에 참여할 때 응원메시지, 감사 마일리지를 입력받아 참여할 수 있다.
	 *  
	 * @author 조민경
	 * @param activityVO
	 * @param jpNo
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value="addUserActivity.do")
	public String addUserActivity(ActivityVO activityVO, String jpNo, String id, String name, String gender) {
		UserVO userVO = new UserVO();
		JoinPostVO joinPostVO = new JoinPostVO();
		// userVO setting
		userVO.setId(id);
		userVO.setName(name);
		userVO.setGender(gender);
		// joinPostVO setting
		joinPostVO.setJpNo(Integer.parseInt(jpNo));
		// activityVO setting
		activityVO.setUserVO(userVO);
		activityVO.setJoinPostVO(joinPostVO);
		if(activityVO.getCheerUpMessage().equals("") || activityVO.getCheerUpMessage()==null){
			activityVO.setCheerUpMessage(null);
		}
		// 참여하기 기능
		joinService.addUserActivity(activityVO);
		return "redirect:donation/readDonationDetail.do?jpNo="+jpNo;		
	}
	
	/**
	 * 응원메시지 목록
	 * 해당 재능기부에 있는 응원메시지 목록을 가지고 온다
	 * 
	 * @param jpNo
	 * @param model
	 * @return
	 */
	@RequestMapping("donation/readCheerUpMessageList.do")
	public String readCheerUpMessageList(int jpNo, Model model) {
		List<ActivityVO> activityList = joinService.readCheerUpMessageList(jpNo);
		model.addAttribute("activityList",activityList);
		return "donation/readCheerUpMessageList.tiles";
	}
	
	@RequestMapping("donation/readReviewList.do")
	public String readReviewList(int jpNo, Model model) {
		List<ReviewVO> reviewList = joinService.readReviewList(jpNo);
		model.addAttribute("reviewList", reviewList);
		return "donation/readReviewList.tiles";
	}
}
