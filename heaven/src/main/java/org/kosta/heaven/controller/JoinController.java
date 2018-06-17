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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping(method = RequestMethod.POST, value = "application.do")
	public String application(@RequestParam("main_image") MultipartFile uploadfile, ModelMap modelMap,
			 JoinPostVO joinPostVO, String jpGroupNo, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		UserVO uvo = null;
		// 참여 게시글 종류 번호
		JoinPostGroupVO joinPostGroupVO = new JoinPostGroupVO(jpGroupNo, null);
		if (session != null) {
			uvo = (UserVO) session.getAttribute("uvo");
			if (uvo != null)
				joinPostVO.setUserVO(uvo);
		}
		
		if (!uploadfile.getOriginalFilename().equals("")) {
			System.out.println("대표 이미지 파일 업로드 : "+uploadfile.getOriginalFilename());
			joinPostVO.setJpImgDirect(uploadfile.getOriginalFilename());

			System.out.println("대표이미지 이름 : " + joinPostVO.getJpImgDirect());
			joinPostVO.setJpImgDirect(joinService.file_upload_save(uploadfile, modelMap));
		}

		joinPostVO.setJoinPostGroupVO(joinPostGroupVO);
		joinService.application(joinPostVO);
		
		if(jpGroupNo.equals("1")) {
			return "redirect:donation/readDonationList.do?nowPage=1";
		}else if(jpGroupNo.equals("2")) {
			return "redirect:taking/readTakingList.do?nowPage=1";
		}else {
			return "redirect:home.do";
		}
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
	public String readDonationDetail(int jpNo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserVO uvo = null;
		ActivityVO entryVO = null;
		if (session != null || session.getAttribute("uvo") != null) {
			uvo = (UserVO) session.getAttribute("uvo");
			if (uvo != null) {
				// 접속한 회원이 해당 재능기부에 참여한 참여번호
				entryVO = joinService.findEntryByIdAndJpno(jpNo, uvo.getId());
			}
		}
		// 재능기부 게시물 번호에 따른 상세 내용
		JoinPostVO donationVO = joinService.readDonationDetail(jpNo);
		// 해당 재능기부 게시물의 응원메시지 목록
		List<ActivityVO> activityList = joinService.readCheerUpMessageList(jpNo);
		// 해당 재능기부 게시물의 후기 목록
		List<ReviewVO> reviewList = joinService.readReviewList(jpNo);
		
		// 재능기부 게시물 번호에 따른 상세 내용
		model.addAttribute("donationVO", donationVO);
		// 해당 재능기부에 참여한 남자 회원의 수
		model.addAttribute("maleEntry", joinService.getDonationMaleEntry(jpNo));
		// 해당 재능기부에 참여한 여자 회원의 수
		model.addAttribute("femaleEntry", joinService.getDonationFemaleEntry(jpNo));
		// 접속한 회원이 해당 재능기부에 참여했는지 여부
		model.addAttribute("entryVO", entryVO);
		// 해당 재능기부 게시물의 응원메시지 목록
		model.addAttribute("activityList", activityList);
		// 해당 재능기부 게시물의 후기 목록
		model.addAttribute("reviewList", reviewList);
		
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
	@RequestMapping(method = RequestMethod.POST, value = "addUserActivity.do")
	public String addUserActivity(ActivityVO activityVO, String jpNo, String id, String name, String gender, String jpGroupNo) {
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
		
		//응원메시지를 입력하지 않았을 때 null로 강제 입력
		if (activityVO.getCheerUpMessage().equals("") || activityVO.getCheerUpMessage() == null) {
			activityVO.setCheerUpMessage(null);
		}
		
		// 참여하기 기능
		joinService.addUserActivity(activityVO);
		
		if(jpGroupNo.equals("1")) {
			return "redirect:donation/readDonationDetail.do?jpNo=" + jpNo;
		}else if(jpGroupNo.equals("2")){
			return "redirect:taking/readTakingDetail.do?jpNo="+jpNo;
		}else {
			return "redirect:home.do";
		}
		
	}

	/**
	 * 후기 작성하기
	 * 참여한 회원에 한하여 참여한 재능기부에 후기를 작성할 수 있다.
	 * 
	 * @param reviewVO
	 * @param aNo
	 * @param id
	 * @param jpNo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value="addReview.do")
	public String addReview(ReviewVO reviewVO, String aNo, String id, String jpNo) {
		UserVO userVO = new UserVO();
		JoinPostVO joinPostVO = new JoinPostVO();
		ActivityVO activityVO = new ActivityVO();
		
		// userVO setting
		userVO.setId(id);
		
		// joinPostVO setting
		joinPostVO.setJpNo(Integer.parseInt(jpNo));
		
		// activityVO setting
		activityVO.setaNo(Integer.parseInt(aNo));
		activityVO.setUserVO(userVO);
		activityVO.setJoinPostVO(joinPostVO);
		
		//reviewVO setting
		reviewVO.setActivityVO(activityVO);
		
		joinService.addReview(reviewVO);
		
		return "redirect:donation/readDonationDetail.do?jpNo=" + jpNo;
	}
	
	/**
	 * 테이킹 목록
	 * 신청된 재능기부 중 승인이 된 재능기부에 대한 목록을 볼 수 있다.
	 * 
	 * @author 조민경
	 * @param nowPage
	 * @return
	 * 
	 */
	@RequestMapping("taking/readTakingList.do")
	public String readTakingList(int nowPage, Model model) {
		JoinPostListVO takingList = joinService.readTakingList(nowPage);
		model.addAttribute("takingList", takingList);
		return "taking/readTakingList.tiles";
	}
	
	/**
	 * 테이킹 상세
	 * 테이킹 목록에서 선택한 테이킹에 대한 상세 내용을 볼 수 있다.
	 * @param jpNo
	 * @param model
	 * @return
	 */
	@RequestMapping("taking/readTakingDetail.do")
	public String readTakingDetail(int jpNo, Model model) {
		// 해당 테이킹에 대한 상세 내용
		JoinPostVO takingVO = joinService.readTakingDetail(jpNo);
		// 해당 테이킹 게시물의 응원메시지 목록
		List<ActivityVO> activityList = joinService.readCheerUpMessageList(jpNo);
		// 해당 테이킹에 대한 상세 내용
		model.addAttribute("takingVO", takingVO);
		// 해당 테이킹 게시물의 응원메시지 목록
		model.addAttribute("activityList", activityList);
		
		return "taking/readTakingDetail.tiles";
	}
	
}
