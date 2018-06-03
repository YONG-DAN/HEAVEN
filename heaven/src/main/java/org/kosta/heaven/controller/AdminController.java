package org.kosta.heaven.controller;

import javax.annotation.Resource;

import org.kosta.heaven.model.service.AdminService;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	/*수정완료*/
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
	
	    /**
	     * 문의 답변 작성 폼으로 이동하기
	     * 
	     * @author 용다은
	     */
	    @RequestMapping("admin/createQuestionAnswerForm.do")
	    public String writeWebQuestionAnswer(int qNo, Model model) {
	       //해당하는 문의 글 번호를 폼으로 넘겨 줌
	       model.addAttribute("qNo", qNo);
	       return "admin/createQuestionAnswerForm.tiles";
	    }
	
	    /**
	     * 
	     * 문의 답변 작성하기
	     * 
	     * @author 용다은
	     */
	     @RequestMapping("admin/createQuestionAnswer.do")
	     public String createQuestionAnswer(QuestionPostVO qVO) {
	        adminService.createQuestionAnswer(qVO);
	        return "redirect:/admin/readQuestionDetail.do?qNo="+qVO.getqNo();
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
	
	/**
	 * 
	 * 모금 포인트가 지급되어야 하는 프로그램들
	 * 즉, 마감된 프로그램들의 목록을 불러들여
	 * 해당 기부자 및 단체에게 포인트 지급이 가능하게 한다
	 * 
	 * @author 용다은
	 * 
	 */
	@RequestMapping("admin/readPointList.do")
	public String readPointList(int nowPage, Model model) {
		JoinPostListVO jpListVO = adminService.readPointList(nowPage);
		System.out.println(jpListVO);
		model.addAttribute("jpListVO", jpListVO);
		return "admin/readPointList.tiles";
	}
	
}
