package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.user.UserVO;

public interface UserService {

	public void updatePassword(UserVO vo);
	
	public UserVO checkId(String id);

	public void deleteMember(String id);

	public void registerUser(UserVO vo);

}
