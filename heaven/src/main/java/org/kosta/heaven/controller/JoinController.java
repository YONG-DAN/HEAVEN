package org.kosta.heaven.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.heaven.model.service.JoinService;
import org.kosta.heaven.model.vo.post.join.JoinPostGroupVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
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
}
