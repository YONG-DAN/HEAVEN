package org.kosta.heaven.model.vo.post.interview;

import org.kosta.heaven.model.vo.user.UserVO;

public class InterviewReply {
	private int irNo;
	private String irContents;
	private String irRegdate;
	private UserVO userVO;
	private InterviewVO interviewVO;
	
	public InterviewReply() {
		super();
	}

	public InterviewReply(int irNo, String irContents, String irRegdate, UserVO userVO, InterviewVO interviewVO) {
		super();
		this.irNo = irNo;
		this.irContents = irContents;
		this.irRegdate = irRegdate;
		this.userVO = userVO;
		this.interviewVO = interviewVO;
	}

	public int getIrNo() {
		return irNo;
	}

	public void setIrNo(int irNo) {
		this.irNo = irNo;
	}

	public String getIrContents() {
		return irContents;
	}

	public void setIrContents(String irContents) {
		this.irContents = irContents;
	}

	public String getIrRegdate() {
		return irRegdate;
	}

	public void setIrRegdate(String irRegdate) {
		this.irRegdate = irRegdate;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public InterviewVO getInterviewVO() {
		return interviewVO;
	}

	public void setInterviewVO(InterviewVO interviewVO) {
		this.interviewVO = interviewVO;
	}

	@Override
	public String toString() {
		return "InterviewReply [irNo=" + irNo + ", irContents=" + irContents + ", irRegdate=" + irRegdate + ", userVO="
				+ userVO + ", interviewVO=" + interviewVO + "]";
	}
	
}
