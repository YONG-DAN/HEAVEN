package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.review.ReviewListVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.user.UserVO;

public interface UserService {

	public void updatePassword(UserVO vo);
	
	public UserVO checkId(String id);

	public void deleteMember(String id);

	public void registerUser(UserVO vo);
	
	public ActivityListVO readMyActivityList(String id, int nowPage);

	public JoinPostListVO readMyApplicationList(String id, int nowPage);

	public void addMileage(MileageTradeVO mileageTradeVO);

	public void exchangeMileage(MileageTradeVO mileageTradeVO);

	public void updateUserInfoForm(UserVO vo);

	public ReviewListVO readMyReviewPostList(String id, int nowPage);

}
