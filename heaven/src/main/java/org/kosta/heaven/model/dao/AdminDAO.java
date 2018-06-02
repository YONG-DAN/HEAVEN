package org.kosta.heaven.model.dao;

import java.util.List;
import java.util.Map;

import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;

public interface AdminDAO {

	public QuestionPostListVO readQuestionList(int nowPage);
	
	public int totalGibuJoinPostCount(int nowPage);

	public List<JoinPostVO> totalGibuJoinPostList(Map<String, Object> map);
	
	public int totalTakingJoinPostCount(int nowPage);

	public List<JoinPostVO> totalTakingJoinPostList(Map<String, Object> map);

	public int approvalGibuJoinPostCount(int nowPage);

	public List<JoinPostVO> approvalGibuJoinPostList(Map<String, Object> map);

	public int approvalTakingJoinPostCount(int nowPage);

	public List<JoinPostVO> approvalTakingJoinPostList(Map<String, Object> map);

	public int unapprovalGibuJoinPostCount(int nowPage);

	public List<JoinPostVO> unapprovalGibuJoinPostList(Map<String, Object> map);

	public int unapprovalTakingJoinPostCount(int nowPage);

	public List<JoinPostVO> unapprovalTakingJoinPostList(Map<String, Object> map);

	public int refusalGibuJoinPostCount(int nowPage);

	public List<JoinPostVO> refusalGibuJoinPostList(Map<String, Object> map);

	public int refusalTakingJoinPostCount(int nowPage);

	public List<JoinPostVO> refusalTakingJoinPostList(Map<String, Object> map);



	

	

}
