package org.kosta.heaven.model.dao;

import java.util.List;
import java.util.Map;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;

public interface AdminDAO {

	public List<QuestionPostVO> readAllQuestionList(PagingBeanTen pagingBean);

	public int getTotalQuestionContentCount();

	public QuestionPostVO readQuestionDetail(int qNo);

	public void createQuestionAnswer(QuestionPostVO qVO);

	public void updateQuestionStatus(QuestionPostVO qVO);
	
	public int totalGibuJoinPostCount();

	public List<JoinPostVO> totalGibuJoinPostList(PagingBeanFive pdf);
	
	public int totalTakingJoinPostCount();

	public List<JoinPostVO> totalTakingJoinPostList(PagingBeanFive pdf);

	public int approvalGibuJoinPostCount();

	public List<JoinPostVO> approvalGibuJoinPostList(PagingBeanFive pdf);

	public int approvalTakingJoinPostCount();

	public List<JoinPostVO> approvalTakingJoinPostList(PagingBeanFive pdf);

	public int unapprovalGibuJoinPostCount();

	public List<JoinPostVO> unapprovalGibuJoinPostList(PagingBeanFive pdf);

	public int unapprovalTakingJoinPostCount();

	public List<JoinPostVO> unapprovalTakingJoinPostList(PagingBeanFive pdf);

	public int refusalGibuJoinPostCount();

	public List<JoinPostVO> refusalGibuJoinPostList(PagingBeanFive pdf);

	public int refusalTakingJoinPostCount();

	public List<JoinPostVO> refusalTakingJoinPostList(PagingBeanFive pdf);
	
	public List<JoinPostVO> readPointList(PagingBeanFive pagingBean);

	public int getTotalPointContentCount();

	

	

}
