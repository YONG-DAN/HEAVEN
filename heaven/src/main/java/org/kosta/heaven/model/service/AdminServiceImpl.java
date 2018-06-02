package org.kosta.heaven.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.AdminDAO;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.question.QuestionPostListVO;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminDAO adminDAO;

	@Override
	public QuestionPostListVO readQuestionList(int nowPage) {
		return adminDAO.readQuestionList(nowPage);
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
}
