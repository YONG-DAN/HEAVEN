package org.kosta.heaven.model.dao;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanTen;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;

public interface MileageDAO {

	public void addMileage(MileageTradeVO mileageTradeVO);

	public void tradeMileage(MileageTradeVO mtVO);

	public void exchangeMileage(MileageTradeVO mileageTradeVO);

	public List<MileageTradeVO> readMyMileageTradeList(PagingBeanTen pagingBean);

	public int getTotalContentCount(String id);

	public void saveMileage(MileageTradeVO mileageTradeVO);
	
}
