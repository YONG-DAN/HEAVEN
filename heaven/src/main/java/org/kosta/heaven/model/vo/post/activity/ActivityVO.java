package org.kosta.heaven.model.vo.post.activity;

import org.kosta.heaven.model.vo.post.join.JoinPostVO;
import org.kosta.heaven.model.vo.user.UserVO;

public class ActivityVO {
	private int aNO;
	private String aRegdate;
	private int aMileage;
	private String cheerUpMessage;
	private UserVO userVO;
	private JoinPostVO joinPostVO;
	
	public ActivityVO() {
		super();
	}

	public ActivityVO(int aNO, String aRegdate, int aMileage, String cheerUpMessage, UserVO userVO,
			JoinPostVO joinPostVO) {
		super();
		this.aNO = aNO;
		this.aRegdate = aRegdate;
		this.aMileage = aMileage;
		this.cheerUpMessage = cheerUpMessage;
		this.userVO = userVO;
		this.joinPostVO = joinPostVO;
	}

	public int getaNO() {
		return aNO;
	}

	public void setaNO(int aNO) {
		this.aNO = aNO;
	}

	public String getaRegdate() {
		return aRegdate;
	}

	public void setaRegdate(String aRegdate) {
		this.aRegdate = aRegdate;
	}

	public int getaMileage() {
		return aMileage;
	}

	public void setaMileage(int aMileage) {
		this.aMileage = aMileage;
	}

	public String getCheerUpMessage() {
		return cheerUpMessage;
	}

	public void setCheerUpMessage(String cheerUpMessage) {
		this.cheerUpMessage = cheerUpMessage;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public JoinPostVO getJoinPostVO() {
		return joinPostVO;
	}

	public void setJoinPostVO(JoinPostVO joinPostVO) {
		this.joinPostVO = joinPostVO;
	}

	@Override
	public String toString() {
		return "ActivityVO [aNO=" + aNO + ", aRegdate=" + aRegdate + ", aMileage=" + aMileage + ", cheerUpMessage="
				+ cheerUpMessage + ", userVO=" + userVO + ", joinPostVO=" + joinPostVO + "]";
	}
}
