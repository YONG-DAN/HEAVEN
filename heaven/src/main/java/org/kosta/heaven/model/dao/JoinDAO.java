package org.kosta.heaven.model.dao;

import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;

public interface JoinDAO {

	void application(JoinPostVO joinPostVO);
	
	JoinPostListVO readDonationList(int nowPage);

}
