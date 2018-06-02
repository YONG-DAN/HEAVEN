package org.kosta.heaven.model.service;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.AdminDAO;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminDAO adminDAO;

	@Override
	public QuestionPostListVO readAllQuestionList(int nowPage) {
		//목록에 보여 줄 전체 문의 내역 수를 가져옴
		int totalCount= adminDAO.getTotalQuestionContentCount();
		//페이징빈 생성
		PagingBeanTen pagingBean=null;
		if(nowPage==0) {
			pagingBean=new PagingBeanTen(totalCount);
		}
		else {
			pagingBean=new PagingBeanTen(totalCount, nowPage);
		}
		return new QuestionPostListVO(adminDAO.readAllQuestionList(pagingBean),pagingBean);
	}

	@Override
	public QuestionPostVO readQuestionDetail(int qNo) {
		return adminDAO.readQuestionDetail(qNo);
	}
	
}
