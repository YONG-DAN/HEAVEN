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
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.totalGibuJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.totalGibuJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.totalGibuJoinPostList(map),pbf);
	}

	@Override
	public JoinPostListVO totalTakingJoinPostList(int nowPage) {
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.totalTakingJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.totalTakingJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.totalTakingJoinPostList(map),pbf);
	}
	@Override
	public JoinPostListVO approvalGibuJoinPostList(int nowPage) {
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.approvalGibuJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.approvalGibuJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.approvalGibuJoinPostList(map),pbf);
	}
	@Override
	public JoinPostListVO approvalTakingJoinPostList(int nowPage) {
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.approvalTakingJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.approvalTakingJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.approvalTakingJoinPostList(map),pbf);
	}
	@Override
	public JoinPostListVO unapprovalGibuJoinPostList(int nowPage) {
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.unapprovalGibuJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.unapprovalGibuJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.unapprovalGibuJoinPostList(map),pbf);
	}
	@Override
	public JoinPostListVO unapprovalTakingJoinPostList(int nowPage) {
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.unapprovalTakingJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.unapprovalTakingJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.unapprovalTakingJoinPostList(map),pbf);
	}
	@Override
	public JoinPostListVO refusalGibuJoinPostList(int nowPage) {
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.refusalGibuJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.refusalGibuJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.refusalGibuJoinPostList(map),pbf);
	}
	@Override
	public JoinPostListVO refusalTakingJoinPostList(int nowPage) {
		PagingBeanFive pbf = null;
		if(nowPage==0) {
			pbf=new PagingBeanFive(adminDAO.refusalTakingJoinPostCount(nowPage));
		}else {
			pbf = new PagingBeanFive(adminDAO.refusalTakingJoinPostCount(nowPage));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pbf", pbf);
		return new JoinPostListVO(adminDAO.refusalTakingJoinPostList(map),pbf);
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
