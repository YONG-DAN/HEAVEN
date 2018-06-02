package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;

public interface AdminService {

	public QuestionPostListVO readQuestionList(int nowPage);

	public JoinPostListVO totalGibuJoinPostList(int nowPage);

	public JoinPostListVO totalTakingJoinPostList(int nowPage);

	public JoinPostListVO approvalTakingJoinPostList(int nowPage);

	public JoinPostListVO approvalGibuJoinPostList(int nowPage);

	public JoinPostListVO unapprovalGibuJoinPostList(int nowPage);

	public JoinPostListVO unapprovalTakingJoinPostList(int nowPage);

	public JoinPostListVO refusalGibuJoinPostList(int nowPage);

	public JoinPostListVO refusalTakingJoinPostList(int nowPage);

}
