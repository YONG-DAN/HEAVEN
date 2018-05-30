package org.kosta.heaven.model.vo.post.mileage;

import org.kosta.heaven.model.vo.user.UserVO;

public class MileageTradeVO {
	private int mtNo;
	private int mtVolume;
	private String mtRegdate;
	private MileageUseGroupVO mugVO;
	private UserVO userVO;
	
	public MileageTradeVO() {
		super();
	}
	public MileageTradeVO(int mtNo, int mtVolume, String mtRegdate, MileageUseGroupVO mugVO, UserVO userVO) {
		super();
		this.mtNo = mtNo;
		this.mtVolume = mtVolume;
		this.mtRegdate = mtRegdate;
		this.mugVO = mugVO;
		this.userVO = userVO;
	}
	public int getMtNo() {
		return mtNo;
	}
	public void setMtNo(int mtNo) {
		this.mtNo = mtNo;
	}
	public int getMtVolume() {
		return mtVolume;
	}
	public void setMtVolume(int mtVolume) {
		this.mtVolume = mtVolume;
	}
	public String getMtRegdate() {
		return mtRegdate;
	}
	public void setMtRegdate(String mtRegdate) {
		this.mtRegdate = mtRegdate;
	}
	public MileageUseGroupVO getMugVO() {
		return mugVO;
	}
	public void setMugVO(MileageUseGroupVO mugVO) {
		this.mugVO = mugVO;
	}
	public UserVO getuserVO() {
		return userVO;
	}
	public void setuserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	@Override
	public String toString() {
		return "MileageTradeVO [mtNo=" + mtNo + ", mtVolume=" + mtVolume + ", mtRegdate=" + mtRegdate + ", mugVO="
				+ mugVO + ", UserVO=" + userVO + "]";
	}
}
