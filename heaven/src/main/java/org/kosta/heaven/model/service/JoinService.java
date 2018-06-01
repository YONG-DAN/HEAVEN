package org.kosta.heaven.model.service;

import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;

public interface JoinService {

	void application(JoinPostVO joinPostVO);
	
	JoinPostListVO readDonationList(int nowPage);
}
