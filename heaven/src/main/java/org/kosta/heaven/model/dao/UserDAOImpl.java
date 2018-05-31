package org.kosta.heaven.model.dao;

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
}
