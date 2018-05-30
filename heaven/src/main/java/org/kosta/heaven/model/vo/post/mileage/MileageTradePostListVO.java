package org.kosta.heaven.model.vo.post.mileage;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanTen;

public class MileageTradePostListVO {
	private List<MileageTradeVO> list;
	private PagingBeanTen pbt;
	
	public MileageTradePostListVO() {
		super();
	}
	public MileageTradePostListVO(List<MileageTradeVO> list, PagingBeanTen pbt) {
		super();
		this.list = list;
		this.pbt = pbt;
	}
	public List<MileageTradeVO> getlist() {
		return list;
	}
	public void setlist(List<MileageTradeVO> list) {
		this.list = list;
	}
	public PagingBeanTen getpbt() {
		return pbt;
	}
	public void setpbt(PagingBeanTen pbt) {
		this.pbt = pbt;
	}
	@Override
	public String toString() {
		return "MileageTradePostListVO [list=" + list + ", pbt=" + pbt + "]";
	}
}
