package org.kosta.heaven.model.vo.post.review;

import org.kosta.heaven.model.vo.post.activity.ActivityVO;

public class ReviewVO {
	private int rNo;
	private String rTitle;
	private String rContents;
	private String rRegdate;
	private int rRate;
	private ActivityVO activityVO;
	
	public ReviewVO() {
		super();
	}

	public ReviewVO(int rNo, String rTitle, String rContents, String rRegdate, int rRate, ActivityVO activityVO) {
		super();
		this.rNo = rNo;
		this.rTitle = rTitle;
		this.rContents = rContents;
		this.rRegdate = rRegdate;
		this.rRate = rRate;
		this.activityVO = activityVO;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContents() {
		return rContents;
	}

	public void setrContents(String rContents) {
		this.rContents = rContents;
	}

	public String getrRegdate() {
		return rRegdate;
	}

	public void setrRegdate(String rRegdate) {
		this.rRegdate = rRegdate;
	}

	public int getrRate() {
		return rRate;
	}

	public void setrRate(int rRate) {
		this.rRate = rRate;
	}

	public ActivityVO getActivityVO() {
		return activityVO;
	}

	public void setActivityVO(ActivityVO activityVO) {
		this.activityVO = activityVO;
	}

	@Override
	public String toString() {
		return "ReviewVO [rNo=" + rNo + ", rTitle=" + rTitle + ", rContents=" + rContents + ", rRegdate=" + rRegdate
				+ ", rRate=" + rRate + ", activityVO=" + activityVO + "]";
	}
}
