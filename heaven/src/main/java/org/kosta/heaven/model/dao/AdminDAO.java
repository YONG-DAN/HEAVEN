package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;

public interface AdminDAO {

	public List<QuestionPostVO> readAllQuestionList(PagingBeanTen pagingBean);

	public int getTotalQuestionContentCount();

	public QuestionPostVO readQuestionDetail(int qNo);

}
