package org.kosta.heaven.model.vo.post.question;

import java.util.List;
import org.kosta.heaven.model.vo.post.PagingBeanTen;

public class QuestionPostListVO {
	private List<QuestionPostVO> list;
	private PagingBeanTen pbt;
	
	public QuestionPostListVO() {
		super();
	}
	
	public QuestionPostListVO(List<QuestionPostVO> list, PagingBeanTen pbt) {
		super();
		this.list = list;
		this.pbt = pbt;
	}
	
	public List<QuestionPostVO> getlist() {
		return list;
	}
	
	public void setlist(List<QuestionPostVO> list) {
		this.list = list;
	}
	
	public PagingBeanTen getpbt() {
		return pbt;
	}
	
	public void setpbt(PagingBeanTen pbt) {
		this.pbt = pbt;
	}
	
	@Override
	public String toString() {
		return "QuestionPostListVO [list=" + list + ", pbt=" + pbt + "]";
	}
	
}
