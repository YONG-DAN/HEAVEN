package org.kosta.heaven.model.vo.post.interview;

import org.kosta.heaven.model.vo.user.UserVO;

public class InterviewVO {
	private int iNo;
	private String iTitle;
	private String iRegdate;
	private String iImgDirectory;
	private UserVO userVO;
	
	public InterviewVO() {
		super();
	}

	public InterviewVO(int iNo, String iTitle, String iRegdate, String iImgDirectory, UserVO userVO) {
		super();
		this.iNo = iNo;
		this.iTitle = iTitle;
		this.iRegdate = iRegdate;
		this.iImgDirectory = iImgDirectory;
		this.userVO = userVO;
	}

	public int getiNo() {
		return iNo;
	}

	public void setiNo(int iNo) {
		this.iNo = iNo;
	}

	public String getiTitle() {
		return iTitle;
	}

	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}

	public String getiRegdate() {
		return iRegdate;
	}

	public void setiRegdate(String iRegdate) {
		this.iRegdate = iRegdate;
	}

	public String getiImgDirectory() {
		return iImgDirectory;
	}

	public void setiImgDirectory(String iImgDirectory) {
		this.iImgDirectory = iImgDirectory;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	@Override
	public String toString() {
		return "InterviewVO [iNo=" + iNo + ", iTitle=" + iTitle + ", iRegdate=" + iRegdate + ", iImgDirectory="
				+ iImgDirectory + ", userVO=" + userVO + "]";
	}
	
}
