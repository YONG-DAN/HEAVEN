package org.kosta.heaven.model.service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import org.kosta.heaven.model.dao.AdminDAO;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void createQuestionAnswer(QuestionPostVO qVO) {
		//문의글의 진행 상태 변경하기
		adminDAO.updateQuestionStatus(qVO);
		//답변을 작성하기
		adminDAO.createQuestionAnswer(qVO);
	}
	
	@Override
	public JoinPostListVO totalGibuJoinPostList(int nowPage) {
		
		int totalCount=adminDAO.totalGibuJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		return new JoinPostListVO(adminDAO.totalGibuJoinPostList(pbf),pbf);
	}

	@Override
	public JoinPostListVO totalTakingJoinPostList(int nowPage) {
		int totalCount =adminDAO.totalTakingJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.totalTakingJoinPostList(pbf),pbf);
	}
	@Override
	public JoinPostListVO approvalGibuJoinPostList(int nowPage) {
		int totalCount=adminDAO.approvalGibuJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		return new JoinPostListVO(adminDAO.approvalGibuJoinPostList(pbf),pbf);
	}
	@Override
	public JoinPostListVO approvalTakingJoinPostList(int nowPage) {
		int totalCount=adminDAO.approvalTakingJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		return new JoinPostListVO(adminDAO.approvalTakingJoinPostList(pbf),pbf);
	}
	@Override
	public JoinPostListVO unapprovalGibuJoinPostList(int nowPage) {
		int totalCount=adminDAO.unapprovalGibuJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		return new JoinPostListVO(adminDAO.unapprovalGibuJoinPostList(pbf),pbf);
	}
	@Override
	public JoinPostListVO unapprovalTakingJoinPostList(int nowPage) {
		int totalCount=adminDAO.unapprovalGibuJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		return new JoinPostListVO(adminDAO.unapprovalTakingJoinPostList(pbf),pbf);
	}
	@Override
	public JoinPostListVO refusalGibuJoinPostList(int nowPage) {
		int totalCount=adminDAO.refusalGibuJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		return new JoinPostListVO(adminDAO.refusalGibuJoinPostList(pbf),pbf);
	}
	@Override
	public JoinPostListVO refusalTakingJoinPostList(int nowPage) {
		int totalCount=adminDAO.refusalTakingJoinPostCount();
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalCount);
		}else {
			pbf = new PagingBeanFive(totalCount,nowPage);
		}
		return new JoinPostListVO(adminDAO.refusalTakingJoinPostList(pbf),pbf);
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
