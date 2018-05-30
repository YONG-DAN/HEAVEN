package org.kosta.heaven.model.vo.post.join;

public class JoinPostStatusVO {
	private String jpStuatusNo;
	private String jpStuatusName;
	
	public JoinPostStatusVO() {
		super();
	}

	public JoinPostStatusVO(String jpStuatusNo, String jpStuatusName) {
		super();
		this.jpStuatusNo = jpStuatusNo;
		this.jpStuatusName = jpStuatusName;
	}

	public String getJpStuatusNo() {
		return jpStuatusNo;
	}

	public void setJpStuatusNo(String jpStuatusNo) {
		this.jpStuatusNo = jpStuatusNo;
	}

	public String getJpStuatusName() {
		return jpStuatusName;
	}

	public void setJpStuatusName(String jpStuatusName) {
		this.jpStuatusName = jpStuatusName;
	}

	@Override
	public String toString() {
		return "JoinPostStatusVO [jpStuatusNo=" + jpStuatusNo + ", jpStuatusName=" + jpStuatusName + "]";
	}
	
}
