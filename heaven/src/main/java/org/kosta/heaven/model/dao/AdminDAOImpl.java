package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<QuestionPostVO> readAllQuestionList(PagingBeanTen pagingBean) {
		return template.selectList("admin.readAllQuestionList", pagingBean);
	}

	@Override
	public int getTotalQuestionContentCount() {
		return template.selectOne("admin.getTotalQuestionContentCount");
	}

	@Override
	public QuestionPostVO readQuestionDetail(int qNo) {
		return template.selectOne("admin.readQuestionDetail", qNo);
	}

	@Override
	public void createQuestionAnswer(QuestionPostVO qVO) {
		template.insert("admin.createQuestionAnswer", qVO);
	}

	@Override
	public void updateQuestionStatus(QuestionPostVO qVO) {
		template.update("admin.updateQuestionStatus", qVO);
	}

	@Override
	public List<JoinPostVO> readPointList(PagingBeanFive pagingBean) {
		return template.selectList("admin.readPointList", pagingBean);
	}

	@Override
	public int getTotalPointContentCount() {
		return template.selectOne("admin.getTotalPointContentCount");
	}
	
}
