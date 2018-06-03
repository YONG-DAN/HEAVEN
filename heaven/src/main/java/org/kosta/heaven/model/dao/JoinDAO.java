package org.kosta.heaven.model.dao;

import java.util.List;

import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;

public interface JoinDAO {

	public void application(JoinPostVO joinPostVO);
	
	public JoinPostListVO readDonationList(int nowPage);
	
	public JoinPostVO readDonationDetail(int jpNo);
	
	public void addUserActivity(ActivityVO activityVO);
	
	public void updateDonationMileageAndTotalEntry(ActivityVO activityVO);
	
	public List<ActivityVO> readCheerUpMessageList(int jpNo);
	
	public List<ReviewVO> readReviewList(int jpNo);
	
}
