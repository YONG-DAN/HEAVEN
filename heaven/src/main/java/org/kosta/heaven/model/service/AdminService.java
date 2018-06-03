package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;

public interface AdminService {

	public QuestionPostListVO readAllQuestionList(int nowPage);

	public QuestionPostVO readQuestionDetail(int qNo);

	public void createQuestionAnswer(QuestionPostVO qVO);

	public JoinPostListVO readPointList(int nowPage);

}
