package org.kosta.heaven.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.join.JoinPostListVO;
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

	@Override
	public JoinPostListVO readDonationList(int nowPage) {
		PagingBeanFive pbf=null;
		int totalDonationCount=template.selectOne("join.readDonationCount");
		if(nowPage==0) {
			pbf=new PagingBeanFive(totalDonationCount);
		}else {
			pbf=new PagingBeanFive(totalDonationCount,nowPage);
		}
		List<JoinPostVO> donationList=template.selectList("join.readDonationList", pbf);
		JoinPostListVO donationListVO= new JoinPostListVO(donationList, pbf);
		
		return donationListVO;
	}

}
