/*package org.kosta.heaven.model.service;

import javax.annotation.Resource;

import org.kosta.heaven.model.dao.MileageDAO;
import org.kosta.heaven.model.dao.UserDAO;
import org.kosta.heaven.model.vo.post.PagingBeanFive;
import org.kosta.heaven.model.vo.post.mileage.MileageTradePostListVO;
import org.kosta.heaven.model.vo.post.mileage.MileageTradeVO;
import org.kosta.heaven.model.vo.user.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MileageServiceImpl implements MileageService {
	@Resource
	private MileageDAO mileageDAO;
	@Resource
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addMileage(MileageTradeVO mileageTradeVO) {
		mileageDAO.addMileage(mileageTradeVO);
	}
	
	@Override
	@Transactional
	public void tradeMileage(MileageTradeVO mtVO) {
		mileageDAO.tradeMileage(mtVO);
	}

	@Override
	public void exchangeMileage(MileageTradeVO mileageTradeVO) {
		mileageDAO.exchangeMileage(mileageTradeVO);
	}

	@Override
	@Transactional
	public MileageTradePostListVO readMyMileageTradeList(String id, int nowPage) {
		//목록에 보여 줄 마일리지 내역 수를 가져옴
		int totalCount=mileageDAO.getTotalContentCount(id);
		//페이징빈 생성
		PagingBeanFive pagingBean=null;
		if(nowPage==0) {
			pagingBean=new PagingBeanFive(totalCount);
			pagingBean.setId(id);
		}
		else {
			pagingBean=new PagingBeanFive(totalCount, nowPage);
			pagingBean.setId(id);
		}
		return new MileageTradePostListVO(mileageDAO.readMyMileageTradeList(pagingBean),pagingBean);
	}

	@Override
	@Transactional
	public void saveMileage(String id, int mileage) {
		MileageTradeVO mileageTradeVO = new MileageTradeVO();
		UserVO mvo = userDAO.checkId(id);
		mileageTradeVO.setMemberVO(mvo);
		mileageTradeVO.setMtVolume(mileage);
		mileageDAO.saveMileage(mileageTradeVO);
	}
}
*/