package org.kosta.heaven.model.dao;

import java.util.List;

import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
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

	public void addMileage(MileageTradeVO mileageTradeVO);

	public void exchangeMileage(MileageTradeVO mileageTradeVO);

	public ReviewVO readMyReviewDetail(String rNo);

	public void updateMyReviewDetail(ReviewVO rVO);

	public void deleteMyReview(int rNo);
	
	public void createQuestion(QuestionPostVO qpVO);

	public int getTotalQuestionContentCount(String id);

	public List<QuestionPostVO> readMyQuestionList(PagingBeanTen pagingBean);

	public QuestionPostVO readMyQuestionDetail(int qNo);

	public JoinPostVO selectMyJoinDate(int rNo);

	public void deleteMyActivity(int rNo);

	public QuestionPostVO readQuestionAnswer(int qNo);

	public void updateQuestion(QuestionPostVO qVO);

	public void deleteQuestion(int qNo);
	
	public void updateUserMileage(ActivityVO activityVO);

	public int getTotalMyTakingContentCount(String id);

	public List<JoinPostVO> readMyTakingList(PagingBeanFive pagingBean);
}
