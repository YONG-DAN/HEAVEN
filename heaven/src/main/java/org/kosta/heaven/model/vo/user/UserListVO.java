package org.kosta.heaven.model.vo.user;

import java.util.List;

import org.kosta.heaven.model.vo.post.PagingBeanFive;

public class UserListVO {
	private List<UserVO> list;
	private PagingBeanFive pbf;
	
	public UserListVO() {
		super();
	}

	public UserListVO(List<UserVO> list, PagingBeanFive pbf) {
		super();
		this.list = list;
		this.pbf = pbf;
	}

	public List<UserVO> getlist() {
		return list;
	}

	public void setlist(List<UserVO> list) {
		this.list = list;
	}

	public PagingBeanFive getpbf() {
		return pbf;
	}

	public void setpbf(PagingBeanFive pbf) {
		this.pbf = pbf;
	}

	@Override
	public String toString() {
		return "UserListVO [list=" + list + ", pbf=" + pbf + "]";
	}
	
}
