package org.kosta.heaven.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.heaven.model.service.MileageService;
import org.kosta.heaven.model.service.UserService;
import org.kosta.heaven.model.vo.post.mileage.MileageTradePostListVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.post.mileage.MileageUseGroupVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MileageController {
	
	@Resource
	private MileageService mileageService;
	
	@Resource
	private UserService userService;
	
	/**
	* 마일리지 충전
	* 
	* mileage 거래량을 받아서 저장시키는 용도
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="users/addMileage.do")
	public String addMileage(String mugNo, String id, MileageTradeVO mileageTradeVO, HttpServletRequest request) {
		//session 정보를 확인
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("uvo")==null){
				return "users/loginForm.tiles";
		}
		else{ //login 상태면 uvo를 받아와서 UserVO에 넣어줌
			UserVO uvo=(UserVO) session.getAttribute("uvo");
			mileageTradeVO.setUserVO(uvo);	
		//MileageUseGroupVO에 mugNo를 넣어 거래 종류를 저장하고
		//mileageTradeVO에 넣어줌
		MileageUseGroupVO mugVO = new MileageUseGroupVO(mugNo, null);
		mileageTradeVO.setMugVO(mugVO);
		//mileageTradeVO에 정보를 저장시켜 addMileage시킴
		mileageService.addMileage(mileageTradeVO);
		//addMileage된 내용을 UserVO의 mileage에 업데이트 시킴
		mileageTradeVO.getUserVO().setMileage(mileageTradeVO.getMtVolume());
		userService.addMileage(mileageTradeVO);
		request.getSession().setAttribute("uvo", userService.checkId(mileageTradeVO.getUserVO().getId()));
		return "redirect:/users/readMyMileageTradeList.do?nowPage=1";
		}
	}

	/**
	* 마일리지 환전
	* 
	* @author 용다은
	*/
	@RequestMapping(method=RequestMethod.POST, value="users/exchangeMileage.do")
	public String exchangeMileage(String mugNo, String id, MileageTradeVO mileageTradeVO, HttpServletRequest request) {
		//session 정보를 확인
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("uvo")==null){
				return "users/loginForm.tiles";
			}
		else{ //login 상태면 uvo를 받아와서 UserVO에 넣어줌
			UserVO uvo=(UserVO) session.getAttribute("uvo");
			mileageTradeVO.setUserVO(uvo);		
		//MileageUseGroupVO에 mugNo를 넣어 거래 종류를 저장하고
		//mileageTradeVO에 넣어줌
		MileageUseGroupVO mugVO = new MileageUseGroupVO(mugNo, null);
		mileageTradeVO.setMugVO(mugVO);
		//mileageTradeVO에 정보를 저장시켜 addMileage시킴
		mileageService.exchangeMileage(mileageTradeVO);
		//addMileage된 내용을 UserVO의 mileage에 업데이트 시킴
		mileageTradeVO.getUserVO().setMileage(mileageTradeVO.getMtVolume());
		userService.exchangeMileage(mileageTradeVO);
		request.getSession().setAttribute("uvo", userService.checkId(mileageTradeVO.getUserVO().getId()));
		return "redirect:/users/readMyMileageTradeList.do?nowPage=1";
		}
	}
	
	/**
	* 마일리지 사용내역을 가져와서 보여주는 메서드
	* 
	* @author 용다은
	*/
	@RequestMapping("users/readMyMileageTradeList.do")
	public ModelAndView readMyMileageTradeList(HttpServletRequest request, int nowPage) {
		//session 정보를 확인
		HttpSession session=request.getSession(false);
			if(session!=null){ //login 상태면 uvo를 받아와서 UserVO에 넣어줌
				UserVO uvo=(UserVO) session.getAttribute("uvo");
				MileageTradePostListVO listVO = mileageService.readMyMileageTradeList(uvo.getId(), nowPage); 
				return new ModelAndView("users/readMyMileageTradeList.tiles","listVO", listVO);
			}
			else
				return null; //session==null 일 때 ModelAndView 어찌함?
	}
}
