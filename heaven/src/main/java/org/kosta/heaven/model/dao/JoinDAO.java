package org.kosta.heaven.model.dao;

import java.util.List;

import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;

public interface JoinDAO {

	void application(JoinPostVO joinPostVO);
	
	JoinPostListVO readDonationList(int nowPage);
	
	JoinPostVO readDonationDetail(int jpNo);
	
	void addUserActivity(ActivityVO activityVO);
	
	void updateDonationMileageAndTotalEntry(ActivityVO activityVO);
	
	List<ActivityVO> readCheerUpMessageList(int jpNo);
	
	List<ReviewVO> readReviewList(int jpNo);

	int getDonationMaleEntry(int jpNo);

	int getDonationFemaleEntry(int jpNo);

	ActivityVO findEntryByIdAndJpno(ActivityVO activityVO);
	
}
