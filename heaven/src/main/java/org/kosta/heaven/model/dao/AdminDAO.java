package org.kosta.heaven.model.dao;

import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;

public interface AdminDAO {

	public QuestionPostListVO readQuestionList(int nowPage);

}
