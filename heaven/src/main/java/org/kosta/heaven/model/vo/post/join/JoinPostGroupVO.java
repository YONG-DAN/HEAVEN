package org.kosta.heaven.model.vo.post.join;

public class JoinPostGroupVO {
	private String jpGroupNo;
	private String jpGroupName;
	
	public JoinPostGroupVO() {
		super();
	}

	public JoinPostGroupVO(String jpGroupNo, String jpGroupName) {
		super();
		this.jpGroupNo = jpGroupNo;
		this.jpGroupName = jpGroupName;
	}

	public String getJpGroupNo() {
		return jpGroupNo;
	}

	public void setJpGroupNo(String jpGroupNo) {
		this.jpGroupNo = jpGroupNo;
	}

	public String getJpGroupName() {
		return jpGroupName;
	}

	public void setJpGroupName(String jpGroupName) {
		this.jpGroupName = jpGroupName;
	}

	@Override
	public String toString() {
		return "JoinPostGroupVO [jpGroupNo=" + jpGroupNo + ", jpGroupName=" + jpGroupName + "]";
	}
	
	
}
