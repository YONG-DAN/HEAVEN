package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MileageDAOImpl implements MileageDAO {
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void addMileage(MileageTradeVO mileageTradeVO) {
		template.insert("mileage.addMileage", mileageTradeVO);
	}

	@Override
	public void tradeMileage(MileageTradeVO mtVO) {
		template.insert("mileage.tradeMileage", mtVO);
	}

	@Override
	public void exchangeMileage(MileageTradeVO mileageTradeVO) {
		template.update("mileage.exchangeMileage", mileageTradeVO);
	}

	@Override
	public List<MileageTradeVO> readMyMileageTradeList(PagingBeanTen pagingBean) {
		return template.selectList("mileage.readMyMileageTradeList", pagingBean);
	}

	@Override
	public int getTotalContentCount(String id) {
		return template.selectOne("mileage.getTotalContentCount", id);
	}

	@Override
	public void saveMileage(MileageTradeVO mileageTradeVO) {
		template.insert("mileage.saveMileage", mileageTradeVO);
	}

	@Override
	public void giveMileage(MileageTradeVO mileageTradeVO) {
		template.insert("mileage.giveMileage", mileageTradeVO);
	}
}
