package org.kosta.heaven.model.vo.post.activity;

import java.util.List;

import org.kosta.heaven.model.vo.post.PagingBeanFive;

public class ActivityListVO {
	private List<ActivityVO> list;
	private PagingBeanFive pbf;
	
	public ActivityListVO() {
		super();
	}

	public ActivityListVO(List<ActivityVO> list, PagingBeanFive pbf) {
		super();
		this.list = list;
		this.pbf = pbf;
	}

	public List<ActivityVO> getList() {
		return list;
	}

	public void setList(List<ActivityVO> list) {
		this.list = list;
	}

	public PagingBeanFive getPbf() {
		return pbf;
	}

	public void setPbf(PagingBeanFive pbf) {
		this.pbf = pbf;
	}

	@Override
	public String toString() {
		return "ActivityListVO [list=" + list + ", pbf=" + pbf + "]";
	}
	
}
