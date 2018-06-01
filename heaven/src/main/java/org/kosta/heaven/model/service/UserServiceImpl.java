package org.kosta.heaven.model.service;

import javax.annotation.Resource;
import org.kosta.heaven.model.dao.UserDAO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.kosta.heaven.model.vo.post.review.ReviewListVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDAO userDAO;

	@Override
	public void updatePassword(UserVO vo) {
		userDAO.updatePassword(vo);
	}
	
	@Override
	public UserVO checkId(String id) {
		return userDAO.checkId(id);
	}

	@Override
	public void deleteMember(String id) {
		userDAO.deleteUser(id);
	}

	@Override
	public void registerUser(UserVO vo) {
		userDAO.registerUser(vo);
	}
	
	@Override
	public ActivityListVO readMyActivityList(String id, int nowPage) {
		return userDAO.readMyActivityList(id, nowPage);
	}

	@Override
	public JoinPostListVO readMyApplicationList(String id, int nowPage) {
		return userDAO.readMyApplicationList(id,nowPage);
	}

	@Override
	public void updateUserInfoForm(UserVO vo) {
		userDAO.updateUserInfo(vo);
	}

	@Override
	public ReviewListVO readMyReviewPostList(String id, int nowPage) {
		return userDAO.readMyReviewList(id, nowPage);
	}
	
	@Override
	@Transactional
	public void addMileage(MileageTradeVO mileageTradeVO) {
		userDAO.addMileage(mileageTradeVO);
	}

	@Override
	@Transactional
	public void exchangeMileage(MileageTradeVO mileageTradeVO) {
		userDAO.exchangeMileage(mileageTradeVO);
	}

	@Override
	public ReviewVO readMyReviewDetail(String rNo) {
		return userDAO.readMyReviewDetail(rNo);
	}

	@Override
	public void updateMyReviewDetail(ReviewVO rVO) {
		userDAO.updateMyReviewDetail(rVO);
	}

	@Override
	public void deleteMyReview(int rNo) {
		userDAO.deleteMyReview(rNo);
	}

}
