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
	public int totalGibuJoinPostCount() {
		return template.selectOne("admin.totalGibuJoinPostCount");
	}
	@Override
	public List<JoinPostVO> totalGibuJoinPostList(PagingBeanFive pbf) {
		
		return template.selectList("admin.totalGibuJoinPostList", pbf);
	}
	@Override
	public int totalTakingJoinPostCount() {
		return template.selectOne("admin.totalTakingJoinPostCount");
	}

	@Override
	public List<JoinPostVO> totalTakingJoinPostList(PagingBeanFive pbf) {
		return template.selectList("admin.totalTakingJoinPostList", pbf);
	}
	@Override
	public int approvalGibuJoinPostCount() {
		return template.selectOne("admin.approvalGibuJoinPostCount");
	}
	@Override
	public List<JoinPostVO> approvalGibuJoinPostList(PagingBeanFive pbf) {
		return template.selectList("admin.approvalGibuJoinPostList", pbf);
	}
	@Override
	public int approvalTakingJoinPostCount(){
		return template.selectOne("admin.approvalTakingJoinPostCount");
	}
	@Override
	public List<JoinPostVO> approvalTakingJoinPostList(PagingBeanFive pbf) {
		return template.selectList("admin.approvalTakingJoinPostList", pbf);
	}
	@Override
	public int unapprovalGibuJoinPostCount() {
		return template.selectOne("admin.unapprovalGibuJoinPostCount");
	}
	@Override
	public List<JoinPostVO> unapprovalGibuJoinPostList(PagingBeanFive pbf){
		return template.selectList("admin.unapprovalGibuJoinPostList", pbf);
	}
	@Override
	public int unapprovalTakingJoinPostCount() {
		return template.selectOne("admin.unapprovalTakingJoinPostCount");
	}
	@Override
	public List<JoinPostVO> unapprovalTakingJoinPostList(PagingBeanFive pbf){
		return template.selectList("admin.unapprovalTakingJoinPostList", pbf);
	}
	@Override
	public int refusalGibuJoinPostCount() {
		return template.selectOne("admin.refusalGibuJoinPostCount");
	}
	@Override
	public List<JoinPostVO> refusalGibuJoinPostList(PagingBeanFive pbf){
		return template.selectList("admin.refusalGibuJoinPostList", pbf);
	}
	@Override
	public int refusalTakingJoinPostCount() {
		return template.selectOne("admin.refusalTakingJoinPostCount");
	}
	@Override
	public List<JoinPostVO> refusalTakingJoinPostList(PagingBeanFive pbf){
		return template.selectList("admin.refusalTakingJoinPostList", pbf);
	}
	
	@Override
	public List<JoinPostVO> readPointList(PagingBeanFive pagingBean) {
		return template.selectList("admin.readPointList", pagingBean);
	}

	@Override
	public int getTotalPointContentCount() {
		return template.selectOne("admin.getTotalPointContentCount");
	}

	@Override
	public void changeTheStatus(int jpNo) {
		template.update("admin.changeTheStatus", jpNo);
	}
	
}
