package org.kosta.heaven.model.vo.post.question;

import org.kosta.heaven.model.vo.user.UserVO;

public class QuestionPostVO {
	private int qNo;
	private int thread;
	private String qTitle;
	private String qContents;
	private String qRegdate;
	private String qParentNo;
	private String qStatus;
	private UserVO userVO;
	
	public boolean isAnswer() { 
		int num=this.thread%100;
		if(num==0) { //답변이 아님
			return true;
		}else { //답변임
			return false;
		}
	}

	public QuestionPostVO() {
		super();
	}

	public QuestionPostVO(int qNo, int thread, String qTitle, String qContents, String qRegdate, String qParentNo,
			String qStatus, UserVO userVO) {
		super();
		this.qNo = qNo;
		this.thread = thread;
		this.qTitle = qTitle;
		this.qContents = qContents;
		this.qRegdate = qRegdate;
		this.qParentNo = qParentNo;
		this.qStatus = qStatus;
		this.userVO = userVO;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public int getThread() {
		return thread;
	}

	public void setThread(int thread) {
		this.thread = thread;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContents() {
		return qContents;
	}

	public void setqContents(String qContents) {
		this.qContents = qContents;
	}

	public String getqRegdate() {
		return qRegdate;
	}

	public void setqRegdate(String qRegdate) {
		this.qRegdate = qRegdate;
	}

	public String getqParentNo() {
		return qParentNo;
	}

	public void setqParentNo(String qParentNo) {
		this.qParentNo = qParentNo;
	}

	public String getqStatus() {
		return qStatus;
	}

	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	@Override
	public String toString() {
		return "QuestionPostVO [qNo=" + qNo + ", thread=" + thread + ", qTitle=" + qTitle + ", qContents=" + qContents
				+ ", qRegdate=" + qRegdate + ", qParentNo=" + qParentNo + ", qStatus=" + qStatus + ", userVO=" + userVO
				+ "]";
	}
	
}
