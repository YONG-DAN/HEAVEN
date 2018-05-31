package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.activity.ActivityVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public UserVO checkId(String id) {
		return template.selectOne("user.checkId", id);
	}
	
	@Override
	public void updatePassword(UserVO vo) {
		template.update("user.updatePassword", vo);
	}
	@Override
	public void updateUser(UserVO vo) {
		template.update("user.updateUser",vo);
	}
	@Override
	public void deleteUser(String id) {
		template.update("user.deleteUser",id);
	}

	@Override
	public void registerUser(UserVO vo) {
		template.insert("user.registerUser", vo);
	}
	
		@Override
	public ActivityListVO readMyActivityList(String id,int nowPage) {
		PagingBeanFive pbf=null;
		int totalMyActivityCount=template.selectOne("user.readMyActivityCount",id);
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalMyActivityCount);
		}else {
			pbf=new PagingBeanFive(totalMyActivityCount,nowPage);
		}
		pbf.setId(id);
		System.out.println(pbf.getStartRowNumber());
		List<ActivityVO> aList=template.selectList("user.readMyActivityList", pbf);
		ActivityListVO aListVO= new ActivityListVO(aList, pbf);
		return aListVO ;
	}

	@Override
	public JoinPostListVO readMyApplicationList(String id, int nowPage) {
		PagingBeanFive pbf=null;
		int totalMyApplicationCount=template.selectOne("user.readMyApplicationCount",id);
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalMyApplicationCount);
		}else {
			pbf=new PagingBeanFive(totalMyApplicationCount,nowPage);
		}
		pbf.setId(id);
		List<JoinPostVO> jpList=template.selectList("user.readMyApplicationList", pbf);
		JoinPostListVO jpListVO= new JoinPostListVO(jpList, pbf);
		return jpListVO;
	}
}
