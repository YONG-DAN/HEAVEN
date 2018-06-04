package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.interview.InterviewListVO;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;

public interface CommunityService {

	/*void createInterviewReply(InterviewReplyVO irVO);*/

	public InterviewListVO communityList(int nowPage);

	public InterviewVO communityDetail(int iNo);

}
