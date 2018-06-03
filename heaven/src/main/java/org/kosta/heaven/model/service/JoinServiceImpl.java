package org.kosta.heaven.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.JoinDAO;
import org.kosta.heaven.model.dao.MileageDAO;
import org.kosta.heaven.model.dao.UserDAO;
import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.post.mileage.MileageUseGroupVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JoinServiceImpl implements JoinService {

	@Resource
	private JoinDAO joinDAO;
	@Resource
	private MileageDAO mileageDAO;
	@Resource
	private UserDAO userDAO;

	// 신청하기
	@Override
	public void application(JoinPostVO joinPostVO) {
		joinDAO.application(joinPostVO);
	}
	
	// 재능기부 목록
	@Override
	public JoinPostListVO readDonationList(int nowPage) {
		return joinDAO.readDonationList(nowPage);
	}

	// 재능기부 상세
	@Override
	public JoinPostVO readDonationDetail(int jpNo) {
		return joinDAO.readDonationDetail(jpNo);
	}

	/**
	 * 재능기부 참여
	 * 
	 * 1. 재능기부 참여
	 * 		- 재능기부 응원메시지 내용(입력안하면 default), 회원id, 재능기부 게시글 번호가 db에 저장
	 * 2. 마일리지 거래
	 * 		- 재능기부 참여 시에 회원이 사용한 
	 * 				마일리지 액수, 회원id, 거래종류 번호를 db에 저장
	 * 3. 회원
	 * 		- 재능기부 참여 시 회원이 사용한 마일리지 액수를 
	 * 				가용 마일리지는 차감, 누적 마일리지는 누적 
	 * 4. 재능기부
	 * 		- 회원이 재능기부 참여 한 후  회원이 사용한 마일리지 액수를
	 * 				모금 마일리지 누적
	 * 		- 참여자 수+1	
	 * 			
	 */
	@Override
	@Transactional
	public void addUserActivity(ActivityVO activityVO) {
		System.out.println("JoinServiceImpl [activityVO]"+activityVO);
		//재능기부 참여
		joinDAO.addUserActivity(activityVO);
		
		// 재능기부 참여에 사용한 마일리지 내역
		MileageTradeVO mtVO = new MileageTradeVO();
		mtVO.setMtVolume(activityVO.getaMileage());
		mtVO.setUserVO(activityVO.getUserVO());
		mtVO.setMugVO(new MileageUseGroupVO("2", null));
		mileageDAO.tradeMileage(mtVO);
		
		// 재능기부에 참여한 회원의 가용 마일리지 차감, 누적 마일리지 누적
		userDAO.updateUserMileage(activityVO);
		
		// 참여한 재능기부에 모금 마일리지, 총 재능기부 참여자 수 수정
		joinDAO.updateDonationMileageAndTotalEntry(activityVO);
		
	}

	// 재능기부 응원메시지
	@Override
	public List<ActivityVO> readCheerUpMessageList(int jpNo) {
		return joinDAO.readCheerUpMessageList(jpNo);
	}

	// 재능기부 후기
	@Override
	public List<ReviewVO> readReviewList(int jpNo) {
		return joinDAO.readReviewList(jpNo);
	}
	
	// 참여한 남자 회원 수
	@Override
	public int getDonationMaleEntry(int jpNo) {
		return joinDAO.getDonationMaleEntry(jpNo);
	}
	
	// 참여한 여자 회원 수
	@Override
	public int getDonationFemaleEntry(int jpNo) {
		return joinDAO.getDonationFemaleEntry(jpNo);
	}

	// 로그인 한 회원의 참여 여부
	@Override
	public ActivityVO findEntryByIdAndJpno(int jpNo, String id) {
		UserVO userVO= new UserVO();
		JoinPostVO joinPostVO = new JoinPostVO();
		ActivityVO activityVO = new ActivityVO();
		userVO.setId(id);
		joinPostVO.setJpNo(jpNo);
		activityVO.setUserVO(userVO);
		activityVO.setJoinPostVO(joinPostVO);
		return joinDAO.findEntryByIdAndJpno(activityVO);
	}
}
