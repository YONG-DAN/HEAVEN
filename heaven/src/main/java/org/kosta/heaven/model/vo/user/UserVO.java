package org.kosta.heaven.model.vo.user;

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String birthday;
	private String gender;
	private String address;
	private String email;
	private String companyNo;
	private int mileage;
	private int totalUseMileage;
	private UserGroupVO userGroupVO;
	private UserGradeVO userGradeVO;
	
	public UserVO() {
		super();
	}

	public UserVO(String id, String password, String name, String birthday, String gender, String address, String email,
			String companyNo, int mileage, int totalUseMileage, UserGroupVO userGroupVO, UserGradeVO userGradeVO) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.companyNo = companyNo;
		this.mileage = mileage;
		this.totalUseMileage = totalUseMileage;
		this.userGroupVO = userGroupVO;
		this.userGradeVO = userGradeVO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getTotalUseMileage() {
		return totalUseMileage;
	}

	public void setTotalUseMileage(int totalUseMileage) {
		this.totalUseMileage = totalUseMileage;
	}

	public UserGroupVO getUserGroupVO() {
		return userGroupVO;
	}

	public void setUserGroupVO(UserGroupVO userGroupVO) {
		this.userGroupVO = userGroupVO;
	}

	public UserGradeVO getUserGradeVO() {
		return userGradeVO;
	}

	public void setUserGradeVO(UserGradeVO userGradeVO) {
		this.userGradeVO = userGradeVO;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", birthday=" + birthday + ", gender="
				+ gender + ", address=" + address + ", email=" + email + ", companyNo=" + companyNo + ", mileage="
				+ mileage + ", totalUseMileage=" + totalUseMileage + ", userGroupVO=" + userGroupVO + ", userGradeVO="
				+ userGradeVO + "]";
	}
	
	
}
