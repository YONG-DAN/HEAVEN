package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;

public interface AdminService {

	public QuestionPostListVO readAllQuestionList(int nowPage);

	public QuestionPostVO readQuestionDetail(int qNo);

	public void createQuestionAnswer(QuestionPostVO qVO);

	public JoinPostListVO totalGibuJoinPostList(int nowPage);

	public JoinPostListVO totalTakingJoinPostList(int nowPage);

	public JoinPostListVO approvalTakingJoinPostList(int nowPage);

	public JoinPostListVO approvalGibuJoinPostList(int nowPage);

	public JoinPostListVO unapprovalGibuJoinPostList(int nowPage);

	public JoinPostListVO unapprovalTakingJoinPostList(int nowPage);

	public JoinPostListVO refusalGibuJoinPostList(int nowPage);

	public JoinPostListVO refusalTakingJoinPostList(int nowPage);
	
	public JoinPostListVO readPointList(int nowPage);

}
