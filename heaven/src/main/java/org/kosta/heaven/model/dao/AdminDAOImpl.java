package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public QuestionPostListVO readQuestionList(int nowPage) {
		PagingBeanTen pbt = null;
		int totalWebQuestionCount=template.selectOne("admin.totalWebQuestionCount");
		if(nowPage==0) {
			pbt = new PagingBeanTen(totalWebQuestionCount);
		}else {
			pbt = new PagingBeanTen(totalWebQuestionCount, nowPage);
		}
		List<QuestionPostVO> wqList=template.selectList("admin.readWebQuestionList", pbt);
		QuestionPostListVO wqListVO = new QuestionPostListVO(wqList, pbt);
		return wqListVO;
	}
	
}
