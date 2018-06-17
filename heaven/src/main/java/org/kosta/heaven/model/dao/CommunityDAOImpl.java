package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.interview.InterviewQAVO;
import org.kosta.heaven.model.vo.post.interview.InterviewReplyVO;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityDAOImpl implements CommunityDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void createInterviewReply(InterviewReplyVO irVO) {
		template.insert("community.createInterviewReply", irVO);
	}

	@Override
	public int getTotalCommunityContentCount() {
		return template.selectOne("community.getTotalCommunityContentCount");
	}

	@Override
	public List<InterviewVO> communityList(PagingBeanFive pagingBean) {
		return template.selectList("community.communityList", pagingBean);
	}

	@Override
	public InterviewVO communityDetail(int iNo) {
		return template.selectOne("community.communityDetail", iNo);
	}

	@Override
	public List<InterviewReplyVO> readReplyList(int iNo) {
		return template.selectList("community.readReplyList", iNo);
	}

	@Override
	public InterviewVO createCommunityPost(InterviewVO interviewVO) {
		template.insert("community.createCommunityPost",interviewVO);
		return interviewVO;
	}

	@Override
	public void createCommunityQNA(InterviewQAVO interviewQAVO) {
		template.insert("community.createCommunityQNA", interviewQAVO);	
	}

	@Override
	public List<InterviewQAVO> communityDetailQNA(int iNo) {
		return template.selectList("community.communityDetailQNA",iNo);
	}
}