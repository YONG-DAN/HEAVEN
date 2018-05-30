package org.kosta.heaven.model.vo.post.interview;

public class InterviewQAVO {
	private int qaNo;
	private String answer;
	private String question;
	private InterviewVO interviewVO;
	
	public InterviewQAVO() {
		super();
	}
	public InterviewQAVO(int qaNo, String answer, String question, InterviewVO interviewVO) {
		super();
		this.qaNo = qaNo;
		this.answer = answer;
		this.question = question;
		this.interviewVO = interviewVO;
	}
	public int getQaNo() {
		return qaNo;
	}
	public void setQaNo(int qaNo) {
		this.qaNo = qaNo;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public InterviewVO getInterviewVO() {
		return interviewVO;
	}
	public void setInterviewVO(InterviewVO interviewVO) {
		this.interviewVO = interviewVO;
	}
	@Override
	public String toString() {
		return "InterviewQAVO [qaNo=" + qaNo + ", answer=" + answer + ", question=" + question + ", interviewVO="
				+ interviewVO + "]";
	}
}
