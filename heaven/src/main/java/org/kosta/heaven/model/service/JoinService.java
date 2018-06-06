package org.kosta.heaven.model.service;

import java.util.List;

import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

public interface JoinService {

	void application(JoinPostVO joinPostVO);
	
	JoinPostListVO readDonationList(int nowPage);
	
	JoinPostVO readDonationDetail(int jpNo);
	
	void addUserActivity(ActivityVO activityVO);
	
	List<ActivityVO> readCheerUpMessageList(int jpNo);
	
	List<ReviewVO> readReviewList(int jpNo);

	int getDonationMaleEntry(int jpNo);

	int getDonationFemaleEntry(int jpNo);

	ActivityVO findEntryByIdAndJpno(int jpNo, String id);

	String file_upload_save(MultipartFile uploadfile, ModelMap modelMap);
	
	void addReview(ReviewVO reviewVO);
}
