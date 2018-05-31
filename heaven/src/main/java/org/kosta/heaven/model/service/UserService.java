package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.activity.ActivityListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.user.UserVO;

public interface UserService {

	public void updatePassword(UserVO vo);
	
	public UserVO checkId(String id);

	public void deleteMember(String id);

	public ActivityListVO readMyActivityList(String id, int nowPage);

	public JoinPostListVO readMyApplicationList(String id, int nowPage);

}
