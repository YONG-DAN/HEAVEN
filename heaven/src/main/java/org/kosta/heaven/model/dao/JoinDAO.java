package org.kosta.heaven.model.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.heaven.model.vo.post.PhotoVO;
import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

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

	String file_upload_save(MultipartFile uploadfile, ModelMap modelMap);

	String photoUpload(HttpServletRequest request, PhotoVO vo);

	void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response);

	void addReview(ReviewVO reviewVO);

	JoinPostListVO readTakingList(int nowPage);

	JoinPostVO readTakingDetail(int jpNo);
	
}
