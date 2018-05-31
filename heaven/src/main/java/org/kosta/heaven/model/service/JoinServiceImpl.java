package org.kosta.heaven.model.service;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.JoinDAO;
import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService{
	
	@Resource
	private JoinDAO joinDAO;
	
	@Override
	public void application(JoinPostVO joinPostVO) {
		joinDAO.application(joinPostVO);
	}
}
