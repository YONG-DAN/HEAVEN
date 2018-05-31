package org.kosta.heaven.model.service;

import javax.annotation.Resource;
import org.kosta.heaven.model.dao.UserDAO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDAO userDAO;

	@Override
	public void updatePassword(UserVO vo) {
		userDAO.updatePassword(vo);
	}
	
	@Override
	public UserVO checkId(String id) {
		return userDAO.checkId(id);
	}

	@Override
	public void deleteMember(String id) {
		userDAO.deleteUser(id);
	}

	@Override
	public void registerUser(UserVO vo) {
		userDAO.registerUser(vo);
	}
	
		@Override
	public ActivityListVO readMyActivityList(String id, int nowPage) {
		return userDAO.readMyActivityList(id, nowPage);
	}

	@Override
	public JoinPostListVO readMyApplicationList(String id, int nowPage) {
		return userDAO.readMyApplicationList(id,nowPage);
	}
}
