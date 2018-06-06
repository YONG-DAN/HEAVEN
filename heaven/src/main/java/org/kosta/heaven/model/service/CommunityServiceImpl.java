package org.kosta.heaven.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.CommunityDAO;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.interview.InterviewListVO;
import org.kosta.heaven.model.vo.post.interview.InterviewReplyVO;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Resource
	private CommunityDAO communityDAO;

	@Override
	@Transactional
	public InterviewListVO communityList(int nowPage) {
		//목록에 보여 줄 커뮤니티 컨텐츠 수를 가져옴
		int totalCount= communityDAO.getTotalCommunityContentCount();
		//페이징빈 생성
		PagingBeanFive pagingBean=null;
		if(nowPage==0) {
			pagingBean=new PagingBeanFive(totalCount);
		}
		else {
			pagingBean=new PagingBeanFive(totalCount, nowPage);
		}
		return new InterviewListVO(communityDAO.communityList(pagingBean),pagingBean);
	}

	@Override
	public InterviewVO communityDetail(int iNo) {
		return communityDAO.communityDetail(iNo);
	}

	@Override
	public void createInterviewReply(InterviewReplyVO irVO) {
		communityDAO.createInterviewReply(irVO);
	}

	@Override
	public List<InterviewReplyVO> readReplyList(int iNo) {
		return communityDAO.readReplyList(iNo);
	}
}
