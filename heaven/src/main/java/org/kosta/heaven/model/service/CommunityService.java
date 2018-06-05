package org.kosta.heaven.model.service;

import java.util.List;

import org.kosta.heaven.model.vo.post.interview.InterviewListVO;
import org.kosta.heaven.model.vo.post.interview.InterviewReplyVO;
import org.kosta.heaven.model.vo.post.interview.InterviewVO;

public interface CommunityService {

	public InterviewListVO communityList(int nowPage);

	public InterviewVO communityDetail(int iNo);

	public void createInterviewReply(InterviewReplyVO irVO);

	public List<InterviewReplyVO> readReplyList(int iNo);

}
