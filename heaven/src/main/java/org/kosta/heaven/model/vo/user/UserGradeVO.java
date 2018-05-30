package org.kosta.heaven.model.vo.user;

public class UserGradeVO {
	private String ugradeNo;
	private String ugradeName;
	
	public UserGradeVO() {
		super();
	}
	public UserGradeVO(String ugradeNo, String ugradeName) {
		super();
		this.ugradeNo = ugradeNo;
		this.ugradeName = ugradeName;
	}
	public String getUgradeNo() {
		return ugradeNo;
	}
	public void setUgradeNo(String ugradeNo) {
		this.ugradeNo = ugradeNo;
	}
	public String getUgradeName() {
		return ugradeName;
	}
	public void setUgradeName(String ugradeName) {
		this.ugradeName = ugradeName;
	}
	@Override
	public String toString() {
		return "UserGradeVO [ugradeNo=" + ugradeNo + ", ugradeName=" + ugradeName + "]";
	}
}
