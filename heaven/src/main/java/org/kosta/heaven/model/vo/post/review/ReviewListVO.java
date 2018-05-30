package org.kosta.heaven.model.vo.post.review;

import java.util.List;

import org.kosta.heaven.model.vo.post.PagingBeanFive;

public class ReviewListVO {
	private List<ReviewVO> list;
	private PagingBeanFive pbf;
	
	public ReviewListVO() {
		super();
	}

	public ReviewListVO(List<ReviewVO> list, PagingBeanFive pbf) {
		super();
		this.list = list;
		this.pbf = pbf;
	}

	public List<ReviewVO> getList() {
		return list;
	}

	public void setList(List<ReviewVO> list) {
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
		return "ReviewListVO [list=" + list + ", pbf=" + pbf + "]";
	}
}
