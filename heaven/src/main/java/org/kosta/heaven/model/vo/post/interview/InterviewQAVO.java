package org.kosta.heaven.model.vo.post.interview;

public class InterviewQAVO {
	private int qaNo;
	private String question;
	private String answer;
	private InterviewVO interviewVO;

	public InterviewQAVO() {
		super();
	}

	public InterviewQAVO(int qaNo, String question, String answer, InterviewVO interviewVO) {
		super();
		this.qaNo = qaNo;
		this.question = question;
		this.answer = answer;
		this.interviewVO = interviewVO;
	}

	public int getQaNo() {
		return qaNo;
	}

	public void setQaNo(int qaNo) {
		this.qaNo = qaNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public InterviewVO getInterviewVO() {
		return interviewVO;
	}

	public void setInterviewVO(InterviewVO interviewVO) {
		this.interviewVO = interviewVO;
	}

	@Override
	public String toString() {
		return "InterviewQAVO [qaNo=" + qaNo + ", question=" + question + ", answer=" + answer + ", interviewVO="
				+ interviewVO + "]";
	}

}