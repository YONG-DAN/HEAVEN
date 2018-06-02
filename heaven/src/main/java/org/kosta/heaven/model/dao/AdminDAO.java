package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;

public interface AdminDAO {

	public List<QuestionPostVO> readAllQuestionList(PagingBeanTen pagingBean);

	public int getTotalQuestionContentCount();

	public QuestionPostVO readQuestionDetail(int qNo);

	public void createQuestionAnswer(QuestionPostVO qVO);

	public void updateQuestionStatus(QuestionPostVO qVO);

}
