package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewListVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
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

	public ReviewVO readMyReviewDetail(String rNo);

	public void updateMyReviewDetail(ReviewVO rVO);

	public void deleteMyReview(int rNo);
	
	public void createQuestion(QuestionPostVO qpVO);

	public QuestionPostListVO readMyQuestionList(String id, int nowPage);

	public QuestionPostVO readMyQuestionDetail(int qNo);
	
	public JoinPostVO selectMyJoinDate(int rNo);

	public void deleteMyActivity(int rNo);

	public QuestionPostVO readQuestionAnswer(int qNo);

	public void updateQuestion(QuestionPostVO qVO);

	public void deleteQuestion(int qNo);

	public JoinPostListVO readMyTakingList(String id, int nowPage);

}
