package org.kosta.heaven.model.vo.post.question;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanFive;

public class QuestionPostListVO {
	private List<QuestionPostVO> list;
	private PagingBeanFive pbf;
	
	public QuestionPostListVO() {
		super();
	}
	
	public QuestionPostListVO(List<QuestionPostVO> list, PagingBeanFive pbf) {
		super();
		this.list = list;
		this.pbf = pbf;
	}
	
	public List<QuestionPostVO> getlist() {
		return list;
	}
	
	public void setlist(List<QuestionPostVO> list) {
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
		return "QuestionPostListVO [list=" + list + ", pbf=" + pbf + "]";
	}
	
}
