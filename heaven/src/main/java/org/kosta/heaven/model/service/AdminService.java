package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;

public interface AdminService {

	public QuestionPostListVO readQuestionList(int nowPage);

}
