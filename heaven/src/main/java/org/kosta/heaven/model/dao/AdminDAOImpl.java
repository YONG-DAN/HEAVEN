package org.kosta.heaven.model.dao;

import java.util.List;
import java.util.Map;

import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
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
	@Override
	public int totalGibuJoinPostCount(int nowPage) {
		return template.selectOne("admin.totalGibuJoinPostCount", nowPage);
	}
	@Override
	public List<JoinPostVO> totalGibuJoinPostList(Map<String,Object> map) {
		return template.selectList("admin.totalGibuJoinPostList", map);
	}
	@Override
	public int totalTakingJoinPostCount(int nowPage) {
		return template.selectOne("admin.totalTakingJoinPostCount", nowPage);
	}

	@Override
	public List<JoinPostVO> totalTakingJoinPostList(Map<String,Object> map) {
		return template.selectList("admin.totalTakingJoinPostList", map);
	}
	@Override
	public int approvalGibuJoinPostCount(int nowPage) {
		return template.selectOne("admin.approvalGibuJoinPostCount", nowPage);
	}
	@Override
	public List<JoinPostVO> approvalGibuJoinPostList(Map<String, Object> map) {
		return template.selectList("admin.approvalGibuJoinPostList", map);
	}
	@Override
	public int approvalTakingJoinPostCount(int nowPage){
		return template.selectOne("admin.approvalTakingJoinPostCount", nowPage);
	}
	@Override
	public List<JoinPostVO> approvalTakingJoinPostList(Map<String, Object> map) {
		return template.selectList("admin.approvalTakingJoinPostList", map);
	}
	@Override
	public int unapprovalGibuJoinPostCount(int nowPage) {
		return template.selectOne("admin.unapprovalGibuJoinPostCount", nowPage);
	}
	@Override
	public List<JoinPostVO> unapprovalGibuJoinPostList(Map<String, Object> map){
		return template.selectList("admin.unapprovalGibuJoinPostList", map);
	}
	@Override
	public int unapprovalTakingJoinPostCount(int nowPage) {
		return template.selectOne("admin.unapprovalTakingJoinPostCount", nowPage);
	}
	@Override
	public List<JoinPostVO> unapprovalTakingJoinPostList(Map<String, Object> map){
		return template.selectList("admin.unapprovalTakingJoinPostList", map);
	}
	@Override
	public int refusalGibuJoinPostCount(int nowPage) {
		return template.selectOne("admin.refusalGibuJoinPostCount", nowPage);
	}
	@Override
	public List<JoinPostVO> refusalGibuJoinPostList(Map<String, Object> map){
		return template.selectList("admin.refusalGibuJoinPostList", map);
	}
	@Override
	public int refusalTakingJoinPostCount(int nowPage) {
		return template.selectOne("admin.refusalTakingJoinPostCount", nowPage);
	}
	@Override
	public List<JoinPostVO> refusalTakingJoinPostList(Map<String, Object> map){
		return template.selectList("admin.refusalTakingJoinPostList", map);
	}
}
