package org.kosta.heaven.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.heaven.model.service.CommunityService;
import org.kosta.heaven.model.vo.post.interview.InterviewListVO;
import org.kosta.heaven.model.vo.post.interview.InterviewQAVO;
import org.kosta.heaven.model.vo.post.interview.InterviewReplyVO;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommunityController {
	
	@Resource
	private CommunityService communityService;
	/**
	 * 커뮤니티 게시글 목록을 불러옴
	 *  
	 * @author 용다은
	 */
	@RequestMapping("community/communityList.do")
	public String communityList(int nowPage, Model model) {
		InterviewListVO iListVO = communityService.communityList(nowPage);
		model.addAttribute("iListVO", iListVO);
		return "community/communityList.tiles";
	}
	/**
	 * 커뮤니티 게시글 상세 보기
	 *  
	 * @author 용다은
	 */
	@RequestMapping("community/communityDetail.do")
	public String communityDetail(int iNo, Model model) {
		// 커뮤니티 게시글 보기
		InterviewVO ivo = communityService.communityDetail(iNo);
		// 해당 커뮤니티 게시글 질문/답 보기
		List<InterviewQAVO> iqList = communityService.communityDetailQNA(iNo);
		List<InterviewReplyVO> irVO = (List<InterviewReplyVO>) communityService.readReplyList(iNo);
		model.addAttribute("irVO", irVO);
		model.addAttribute("ivo", ivo);
		model.addAttribute("iqList",iqList);
		return "community/communityDetail.tiles";
	}
	/**
	 * 커뮤니티 게시글에서 댓글 작성하기
	 *  
	 * @author 용다은
	 */
	@ResponseBody
	@RequestMapping("community/createInterviewReply.do")
	public String createInterviewReply(InterviewReplyVO irVO, int iNo, HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("uvo")==null){ //session 없는 경우 로그인 페이지로 보냄
			return "users/loginForm.tiles";
		}
		//받아온 iNo로 interviewVO 생성
		InterviewVO ivo = new InterviewVO();
		ivo.setiNo(iNo);
		//생성된 interviewVO를 irVO에 set 해 줌
		irVO.setInterviewVO(ivo);
		UserVO uvo = (UserVO) session.getAttribute("uvo");
		irVO.setUserVO(uvo);
		communityService.createInterviewReply(irVO);
		return "ok";
	}
	/**
	 */
	@RequestMapping("community/readReplyList.do")
	public String readReplyList(int iNo, Model model) {
		List<InterviewReplyVO> irVO = (List<InterviewReplyVO>) communityService.readReplyList(iNo);
		model.addAttribute("irVO", irVO);
		return "community/communityDetail.tiles";
	}
	
	/**
	 * 이달의 기부자 글쓰기
	 * 인터뷰 질문/답을 작성한다.
	 * 
	 * @author 조민경
	 * 
	 */
	@RequestMapping("community/createCoummnityPost.do")
	public String createCommunityPost(InterviewVO interviewVO, InterviewQAVO interviewQAVO, HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		// name이 question인 값들을 array로 받는다
		String question[] = request.getParameterValues("question");
		// name이 answer인 값들을 array로 받는다
		String answer[] = request.getParameterValues("answer");
		UserVO uvo = new UserVO();
		if (session != null) {
			uvo = (UserVO) session.getAttribute("uvo");
			if (uvo != null)
				// interviewQAVO userVO setting
				interviewVO.setUserVO(uvo);
		}
		
		InterviewVO ivo = communityService.createCommunityPost(interviewVO);		
				
		for(int i=0; i<question.length; i++) {
			interviewQAVO.setQuestion(question[i]);
			interviewQAVO.setAnswer(answer[i]);
			interviewQAVO.setInterviewVO(ivo);
			communityService.createCoummunityQNA(interviewQAVO);
		} 
		return "community/communityList.do?nowPage=1";
	}
}
