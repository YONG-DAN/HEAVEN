package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.interview.InterviewReplyVO;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;

public interface CommunityDAO {

	public int getTotalCommunityContentCount();

	public List<InterviewVO> communityList(PagingBeanFive pagingBean);

	public InterviewVO communityDetail(int iNo);

	public void createInterviewReply(InterviewReplyVO irVO);

	public List<InterviewReplyVO> readReplyList(int iNo);

}
