package org.kosta.heaven.model.vo.user;

public class UserGroupVO {
	private String ugroupNo;
	private String ugroupName;
	
	public UserGroupVO(String ugroupNo, String ugroupName) {
		super();
		this.ugroupNo = ugroupNo;
		this.ugroupName = ugroupName;
	}

	public UserGroupVO() {
		super();
	}

	public String getUgroupNo() {
		return ugroupNo;
	}

	public void setUgroupNo(String ugroupNo) {
		this.ugroupNo = ugroupNo;
	}

	public String getUgroupName() {
		return ugroupName;
	}

	public void setUgroupName(String ugroupName) {
		this.ugroupName = ugroupName;
	}

	@Override
	public String toString() {
		return "UserGroupVO [ugroupNo=" + ugroupNo + ", ugroupName=" + ugroupName + "]";
	}
	
}
