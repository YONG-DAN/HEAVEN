package org.kosta.heaven.model.vo.post.join;

import java.util.List;

import org.kosta.heaven.model.vo.post.PagingBeanFive;

public class JoinPostListVO {
	private List<JoinPostVO> list;
	private PagingBeanFive pbf;
	
	public JoinPostListVO() {
		super();
	}
	public JoinPostListVO(List<JoinPostVO> list, PagingBeanFive pbf) {
		super();
		this.list = list;
		this.pbf = pbf;
	}
	public List<JoinPostVO> getList() {
		return list;
	}
	public void setList(List<JoinPostVO> list) {
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
		return "JoinPostListVO [list=" + list + ", pbf=" + pbf + "]";
	}
}
