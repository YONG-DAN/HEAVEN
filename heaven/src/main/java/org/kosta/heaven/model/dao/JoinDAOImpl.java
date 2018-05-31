package org.kosta.heaven.model.dao;

import javax.annotation.Resource;

import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JoinDAOImpl implements JoinDAO {

	@Resource
	private SqlSessionTemplate template;

	@Override
	public void application(JoinPostVO joinPostVO) {
		template.insert("join.application", joinPostVO);
	}

}
