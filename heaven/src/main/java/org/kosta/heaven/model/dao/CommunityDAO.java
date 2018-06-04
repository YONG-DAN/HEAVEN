package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;

public interface CommunityDAO {

/*	public void createInterviewReply(InterviewReplyVO irVO);*/

	public int getTotalCommunityContentCount();

	public List<InterviewVO> communityList(PagingBeanFive pagingBean);

	public InterviewVO communityDetail(int iNo);

}
