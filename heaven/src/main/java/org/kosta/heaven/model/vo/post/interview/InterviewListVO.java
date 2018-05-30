package org.kosta.heaven.model.vo.post.interview;

import java.util.List;

import org.kosta.heaven.model.vo.post.PagingBeanFive;

public class InterviewListVO {
	private List<InterviewVO> list;
	private PagingBeanFive pbf;
	
	public InterviewListVO() {
		super();
	}

	public InterviewListVO(List<InterviewVO> list, PagingBeanFive pbf) {
		super();
		this.list = list;
		this.pbf = pbf;
	}

	public List<InterviewVO> getList() {
		return list;
	}

	public void setList(List<InterviewVO> list) {
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
		return "InterviewListVO [list=" + list + ", pbf=" + pbf + "]";
	}
	
}
