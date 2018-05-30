package org.kosta.heaven.model.vo.post.join;

import org.kosta.heaven.model.vo.user.UserVO;

public class JoinPostVO {
	private int jpNo;
	private String jpTitle;
	private String jpContents;
	private String jpSummary;
	private String jpPlace;
	private String jpAppStartDate;
	private String jpAppEndDate;
	private String jpEventStartDate;
	private String jpEventEndDate;
	private String jpImgDirect;
	private String jpRegdate;
	private int goalMileage;
	private int totalMileage;
	private int goalEntry;
	private int totalEntry;
	private String jpStatus;
	private UserVO userVO;
	private JoinPostGroupVO joinPostGroupVO;
	private JoinPostStatusVO joinPostStatusVO;
	
	public JoinPostVO() {
		super();
	}

	public JoinPostVO(int jpNo, String jpTitle, String jpContents, String jpSummary, String jpPlace,
			String jpAppStartDate, String jpAppEndDate, String jpEventStartDate, String jpEventEndDate,
			String jpImgDirect, String jpRegdate, int goalMileage, int totalMileage, int goalEntry, int totalEntry,
			String jpStatus, UserVO userVO, JoinPostGroupVO joinPostGroupVO, JoinPostStatusVO joinPostStatusVO) {
		super();
		this.jpNo = jpNo;
		this.jpTitle = jpTitle;
		this.jpContents = jpContents;
		this.jpSummary = jpSummary;
		this.jpPlace = jpPlace;
		this.jpAppStartDate = jpAppStartDate;
		this.jpAppEndDate = jpAppEndDate;
		this.jpEventStartDate = jpEventStartDate;
		this.jpEventEndDate = jpEventEndDate;
		this.jpImgDirect = jpImgDirect;
		this.jpRegdate = jpRegdate;
		this.goalMileage = goalMileage;
		this.totalMileage = totalMileage;
		this.goalEntry = goalEntry;
		this.totalEntry = totalEntry;
		this.jpStatus = jpStatus;
		this.userVO = userVO;
		this.joinPostGroupVO = joinPostGroupVO;
		this.joinPostStatusVO = joinPostStatusVO;
	}

	public int getJpNo() {
		return jpNo;
	}

	public void setJpNo(int jpNo) {
		this.jpNo = jpNo;
	}

	public String getJpTitle() {
		return jpTitle;
	}

	public void setJpTitle(String jpTitle) {
		this.jpTitle = jpTitle;
	}

	public String getJpContents() {
		return jpContents;
	}

	public void setJpContents(String jpContents) {
		this.jpContents = jpContents;
	}

	public String getJpSummary() {
		return jpSummary;
	}

	public void setJpSummary(String jpSummary) {
		this.jpSummary = jpSummary;
	}

	public String getJpPlace() {
		return jpPlace;
	}

	public void setJpPlace(String jpPlace) {
		this.jpPlace = jpPlace;
	}

	public String getJpAppStartDate() {
		return jpAppStartDate;
	}

	public void setJpAppStartDate(String jpAppStartDate) {
		this.jpAppStartDate = jpAppStartDate;
	}

	public String getJpAppEndDate() {
		return jpAppEndDate;
	}

	public void setJpAppEndDate(String jpAppEndDate) {
		this.jpAppEndDate = jpAppEndDate;
	}

	public String getJpEventStartDate() {
		return jpEventStartDate;
	}

	public void setJpEventStartDate(String jpEventStartDate) {
		this.jpEventStartDate = jpEventStartDate;
	}

	public String getJpEventEndDate() {
		return jpEventEndDate;
	}

	public void setJpEventEndDate(String jpEventEndDate) {
		this.jpEventEndDate = jpEventEndDate;
	}

	public String getJpImgDirect() {
		return jpImgDirect;
	}

	public void setJpImgDirect(String jpImgDirect) {
		this.jpImgDirect = jpImgDirect;
	}

	public String getJpRegdate() {
		return jpRegdate;
	}

	public void setJpRegdate(String jpRegdate) {
		this.jpRegdate = jpRegdate;
	}

	public int getGoalMileage() {
		return goalMileage;
	}

	public void setGoalMileage(int goalMileage) {
		this.goalMileage = goalMileage;
	}

	public int getTotalMileage() {
		return totalMileage;
	}

	public void setTotalMileage(int totalMileage) {
		this.totalMileage = totalMileage;
	}

	public int getGoalEntry() {
		return goalEntry;
	}

	public void setGoalEntry(int goalEntry) {
		this.goalEntry = goalEntry;
	}

	public int getTotalEntry() {
		return totalEntry;
	}

	public void setTotalEntry(int totalEntry) {
		this.totalEntry = totalEntry;
	}

	public String getJpStatus() {
		return jpStatus;
	}

	public void setJpStatus(String jpStatus) {
		this.jpStatus = jpStatus;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public JoinPostGroupVO getJoinPostGroupVO() {
		return joinPostGroupVO;
	}

	public void setJoinPostGroupVO(JoinPostGroupVO joinPostGroupVO) {
		this.joinPostGroupVO = joinPostGroupVO;
	}

	public JoinPostStatusVO getJoinPostStatusVO() {
		return joinPostStatusVO;
	}

	public void setJoinPostStatusVO(JoinPostStatusVO joinPostStatusVO) {
		this.joinPostStatusVO = joinPostStatusVO;
	}

	@Override
	public String toString() {
		return "JoinPostVO [jpNo=" + jpNo + ", jpTitle=" + jpTitle + ", jpContents=" + jpContents + ", jpSummary="
				+ jpSummary + ", jpPlace=" + jpPlace + ", jpAppStartDate=" + jpAppStartDate + ", jpAppEndDate="
				+ jpAppEndDate + ", jpEventStartDate=" + jpEventStartDate + ", jpEventEndDate=" + jpEventEndDate
				+ ", jpImgDirect=" + jpImgDirect + ", jpRegdate=" + jpRegdate + ", goalMileage=" + goalMileage
				+ ", totalMileage=" + totalMileage + ", goalEntry=" + goalEntry + ", totalEntry=" + totalEntry
				+ ", jpStatus=" + jpStatus + ", userVO=" + userVO + ", joinPostGroupVO=" + joinPostGroupVO
				+ ", joinPostStatusVO=" + joinPostStatusVO + "]";
	}
	
}
