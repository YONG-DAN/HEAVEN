package org.kosta.heaven.controller;

import javax.annotation.Resource;

import org.kosta.heaven.model.service.CommunityService;
import org.kosta.heaven.model.vo.post.interview.InterviewListVO;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("community/communityDetail.do")
	public String communityDetail(int iNo, Model model) {
		InterviewVO ivo = communityService.communityDetail(iNo);
		model.addAttribute("ivo", ivo);
		return "community/communityDetail.tiles";
	}
	
/*	@ResponseBody
	@RequestMapping("community/createInterviewReply.do")
	public String createInterviewReply(InterviewReplyVO irVO) {
		communityService.createInterviewReply(irVO);
		System.out.println();
	}*/

}
