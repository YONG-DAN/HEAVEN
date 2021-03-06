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
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public UserVO checkId(String id) {
		return template.selectOne("user.checkId", id);
	}
	
	@Override
	public void updatePassword(UserVO vo) {
		template.update("user.updatePassword", vo);
	}
	@Override
	public void updateUser(UserVO vo) {
		template.update("user.updateUser",vo);
	}
	@Override
	public void deleteUser(String id) {
		template.update("user.deleteUser",id);
	}

	@Override
	public void registerUser(UserVO vo) {
		template.insert("user.registerUser", vo);
	}
	
		@Override
	public ActivityListVO readMyActivityList(String id,int nowPage) {
		PagingBeanFive pbf=null;
		int totalMyActivityCount=template.selectOne("user.readMyActivityCount",id);
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalMyActivityCount);
		}else {
			pbf=new PagingBeanFive(totalMyActivityCount,nowPage);
		}
		pbf.setId(id);
		System.out.println(pbf.getStartRowNumber());
		List<ActivityVO> aList=template.selectList("user.readMyActivityList", pbf);
		ActivityListVO aListVO= new ActivityListVO(aList, pbf);
		return aListVO;
	}

	@Override
	public JoinPostListVO readMyApplicationList(String id, int nowPage) {
		PagingBeanFive pbf=null;
		int totalMyApplicationCount=template.selectOne("user.readMyApplicationCount",id);
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalMyApplicationCount);
		}else {
			pbf=new PagingBeanFive(totalMyApplicationCount,nowPage);
		}
		pbf.setId(id);
		List<JoinPostVO> jpList=template.selectList("user.readMyApplicationList", pbf);
		JoinPostListVO jpListVO= new JoinPostListVO(jpList, pbf);
		return jpListVO;
	}
	
	@Override
	public void updateUserInfo(UserVO vo) {
		template.update("user.updateUserInfo",vo);
	}
	
	@Override
	public ReviewListVO readMyReviewList(String id, int nowPage) {
		PagingBeanFive pbf=null;
		//나의 후기글 목록의 수를 가져온다.
		int totalMyReviewCount=template.selectOne("user.readMyReviewCount",id);
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalMyReviewCount);
		}else {
			pbf=new PagingBeanFive(totalMyReviewCount,nowPage);
		}
		pbf.setId(id);
		List<ReviewVO> rList=template.selectList("user.readMyReviewList", pbf);
		ReviewListVO rListVO=new ReviewListVO(rList, pbf);
		return rListVO;
	}
	
	@Override
	public ReviewVO readMyReviewDetail(int rNo) {
		ReviewVO reviewVO=template.selectOne("user.readMyReviewDetail", rNo);
		return reviewVO;
	}
	
	@Override
	public void addMileage(MileageTradeVO mileageTradeVO) {
		template.update("user.addMileage", mileageTradeVO);
	}

	@Override
	public void exchangeMileage(MileageTradeVO mileageTradeVO) {
		template.update("user.exchangeMileage", mileageTradeVO);
	}


	@Override
	public ReviewVO readMyReviewDetail(String rNo) {
		return template.selectOne("user.readMyReviewDetail", rNo);
	}

	@Override
	public void updateMyReviewDetail(ReviewVO rVO) {
		template.update("user.updateMyReviewDetail", rVO);
	}

	@Override
	public void deleteMyReview(int rNo) {
		template.delete("user.deleteMyReview",rNo);
	}
	@Override
	public JoinPostVO selectMyJoinDate(int rNo) {
		return template.selectOne("user.selectMyJoinDate", rNo);
	}

	@Override
	public void deleteMyActivity(int rNo) {
		template.delete("user.deleteMyActivity",rNo);
	}
	@Override
	public void createQuestion(QuestionPostVO qpVO) {
		template.insert("user.createQuestion", qpVO);
	}

	@Override
	public int getTotalQuestionContentCount(String id) {
		return template.selectOne("user.getTotalQuestionContentCount", id);
	}

	@Override
	public QuestionPostVO readMyQuestionDetail(int qNo) {
		return template.selectOne("user.readMyQuestionDetail", qNo);
	}

	@Override
	public List<QuestionPostVO> readMyQuestionList(PagingBeanTen pagingBean) {
		return template.selectList("user.readMyQuestionList", pagingBean);
	}

	@Override
	public QuestionPostVO readQuestionAnswer(int qNo) {
		return template.selectOne("user.readQuestionAnswer", qNo);
	}

	@Override
	public void updateQuestion(QuestionPostVO qVO) {
		template.update("user.updateQuestion", qVO);
	}

	@Override
	public void deleteQuestion(int qNo) {
		template.delete("user.deleteQuestion", qNo);
	}

	@Override
	public void updateUserMileage(ActivityVO activityVO) {
		template.update("user.updateUserMileage", activityVO);		
	}

	@Override
	public int getTotalMyTakingContentCount(String id) {
		return template.selectOne("user.getTotalMyTakingContentCount", id);
	}

	@Override
	public List<JoinPostVO> readMyTakingList(PagingBeanFive pagingBean) {
		return template.selectList("user.readMyTakingList", pagingBean);
	}
	
	
}
