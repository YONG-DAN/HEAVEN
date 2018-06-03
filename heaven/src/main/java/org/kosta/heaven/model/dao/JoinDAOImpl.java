package org.kosta.heaven.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.review.ReviewVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JoinDAOImpl implements JoinDAO {

	@Resource
	private SqlSessionTemplate template;

	// 신청하기
	@Override
	public void application(JoinPostVO joinPostVO) {
		template.insert("join.application", joinPostVO);
	}

	// 재능기부 목록
	@Override
	public JoinPostListVO readDonationList(int nowPage) {
		PagingBeanFive pbf = null;
		int totalDonationCount = template.selectOne("join.readDonationCount");
		if (nowPage == 0) {
			pbf = new PagingBeanFive(totalDonationCount);
		} else {
			pbf = new PagingBeanFive(totalDonationCount, nowPage);
		}
		List<JoinPostVO> donationList = template.selectList("join.readDonationList", pbf);
		JoinPostListVO donationListVO = new JoinPostListVO(donationList, pbf);

		return donationListVO;
	}

	// 재능기부 상세
	@Override
	public JoinPostVO readDonationDetail(int jpNo) {
		return template.selectOne("join.readDonationDetail", jpNo);
	}

	// 재능기부 참여하기
	@Override
	public void addUserActivity(ActivityVO activityVO) {
		template.insert("join.addUserActivity", activityVO);
	}

	// 참여한 재능기부에 모금 마일리지, 총 재능기부 참여자 수 수정
	@Override
	public void updateDonationMileageAndTotalEntry(ActivityVO activityVO) {
		template.update("join.updateDonationMileageAndTotalEntry", activityVO);

	}

	// 해당 재능기부에 대한 응원메시지 목록
	@Override
	public List<ActivityVO> readCheerUpMessageList(int jpNo) {
		return template.selectList("join.readCheerUpMessageList", jpNo);
	}

	// 해당 재능기부에 대한 후기 목록
	@Override
	public List<ReviewVO> readReviewList(int jpNo) {
		return template.selectList("join.readReviewList", jpNo);
	}

	// 성별이 남자인 참여자의 수
	@Override
	public int getDonationMaleEntry(int jpNo) {
		return template.selectOne("join.getDonationMaleEntry", jpNo);
	}

	// 성별이 남자인 참여자의 수
	@Override
	public int getDonationFemaleEntry(int jpNo) {
		return template.selectOne("join.getDonationFemaleEntry", jpNo);
	}
	
	// 로그인한 회원의 참여 여부
	@Override
	public ActivityVO findEntryByIdAndJpno(ActivityVO activityVO) {
		return template.selectOne("join.findEntryByIdAndJpno", activityVO);
	}

}
