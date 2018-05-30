package org.kosta.heaven.model.service;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.UserDAO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDAO userDAO;

	@Override
	public UserVO checkId(String id) {
		System.out.println(id);
		return userDAO.checkId(id);
	}
	
}
