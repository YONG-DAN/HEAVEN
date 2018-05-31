package org.kosta.heaven.model.dao;

import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.user.UserVO;

public interface UserDAO {

	public void updatePassword(UserVO vo);

	public void updateUser(UserVO vo);

	public void deleteUser(String id);
	
	public UserVO checkId(String id);

	public ActivityListVO readMyActivityList(String id, int nowPage);

	public JoinPostListVO readMyApplicationList(String id, int nowPage);

}
