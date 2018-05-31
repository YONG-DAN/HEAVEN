package org.kosta.heaven.model.dao;

import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.review.ReviewListVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.kosta.heaven.model.vo.user.UserVO;

public interface UserDAO {

	public void updatePassword(UserVO vo);

	public void updateUser(UserVO vo);

	public void deleteUser(String id);
	
	public UserVO checkId(String id);

	public void registerUser(UserVO vo);
	
	public ActivityListVO readMyActivityList(String id, int nowPage);

	public JoinPostListVO readMyApplicationList(String id, int nowPage);

	public void updateUserInfo(UserVO vo);

	public ReviewListVO readMyReviewList(String id, int nowPage);

	public ReviewVO readMyReviewDetail(int rNo);

	

}
