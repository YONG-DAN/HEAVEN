package org.kosta.heaven.model.service;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.AdminDAO;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
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

	@Override
	public void createQuestionAnswer(QuestionPostVO qVO) {
		//답변을 작성하기
		adminDAO.createQuestionAnswer(qVO);
		//문의글의 진행 상태 변경하기
		adminDAO.updateQuestionStatus(qVO);
	}

	@Override
	public JoinPostListVO readPointList(int nowPage) {
		//목록에 보여 줄 전체 포인트 지급 내역 수를 가져옴
		int totalCount= adminDAO.getTotalPointContentCount();
		//페이징빈 생성
		PagingBeanFive pagingBean=null;
		if(nowPage==0) {
			pagingBean=new PagingBeanFive(totalCount);
		}
		else {
			pagingBean=new PagingBeanFive(totalCount, nowPage);
		}
		return new JoinPostListVO(adminDAO.readPointList(pagingBean),pagingBean);
	}
	
}
