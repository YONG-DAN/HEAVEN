package org.kosta.heaven.model.service;

import javax.annotation.Resource;
import org.kosta.heaven.model.dao.UserDAO;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
<<<<<<< HEAD
import org.kosta.heaven.model.vo.user.UserVO;
=======
>>>>>>> branch 'master' of https://github.com/YONG-DAN/HEAVEN.git
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
<<<<<<< HEAD
import org.kosta.heaven.model.vo.user.UserVO;
=======
>>>>>>> branch 'master' of https://github.com/YONG-DAN/HEAVEN.git
import org.kosta.heaven.model.vo.post.review.ReviewListVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.kosta.heaven.model.vo.user.UserVO;
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
	
	@Override
	@Transactional
	public void createQuestion(QuestionPostVO qpVO) {
		userDAO.createQuestion(qpVO);
	}

<<<<<<< HEAD
	
	@Override
	@Transactional
	public void createQuestion(QuestionPostVO qpVO) {
		userDAO.createQuestion(qpVO);
	}

	@Override
	@Transactional
	public QuestionPostListVO readMyQuestionList(String id, int nowPage) {
		//목록에 보여 줄 문의 내역 수를 가져옴
				int totalCount= userDAO.getTotalQuestionContentCount(id);
				//페이징빈 생성
				PagingBeanFive pagingBean=null;
				if(nowPage==0) {
					pagingBean=new PagingBeanFive(totalCount);
					pagingBean.setId(id);
				}
				else {
					pagingBean=new PagingBeanFive(totalCount, nowPage);
					pagingBean.setId(id);
				}
				return new QuestionPostListVO(userDAO.readMyQuestionList(pagingBean),pagingBean);
			}
	@Override
	public JoinPostVO selectMyJoinDate(int rNo) {
		return userDAO.selectMyJoinDate(rNo);
	}

	@Override
	public void deleteMyActivity(int rNo) {
		System.out.println("서비스다");
		userDAO.deleteMyActivity(rNo);
	}
=======
	@Override
	@Transactional
	public QuestionPostListVO readMyQuestionList(String id, int nowPage) {
		//목록에 보여 줄 문의 내역 수를 가져옴
				int totalCount= userDAO.getTotalQuestionContentCount(id);
				//페이징빈 생성
				PagingBeanFive pagingBean=null;
				if(nowPage==0) {
					pagingBean=new PagingBeanFive(totalCount);
					pagingBean.setId(id);
				}
				else {
					pagingBean=new PagingBeanFive(totalCount, nowPage);
					pagingBean.setId(id);
				}
				return new QuestionPostListVO(userDAO.readMyQuestionList(pagingBean),pagingBean);
			}

>>>>>>> branch 'master' of https://github.com/YONG-DAN/HEAVEN.git
	@Override
	@Transactional
	public QuestionPostVO readMyQuestionDetail(int qNo) {
		return userDAO.readMyQuestionDetail(qNo);
	}
	
}
