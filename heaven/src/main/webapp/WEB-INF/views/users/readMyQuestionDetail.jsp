<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">내 문의 글 보기</h4>
</div>
<!-- 답변 여부에 따른 수정/검색 제한 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var result = ${qPostVO.qStatus=='답변완료'}
	$("#questionUpdateBtn").click(function(){
		if(result) 
			alert("답변이 완료된 문의는 수정할 수 없습니다")
		else 
			location.href="${pageContext.request.contextPath }/users/updateQuestionForm.do?qNo=${qPostVO.qNo}"
	});//click 
	$("#questionDeleteBtn").click(function(){
		if(result) 
				alert("답변이 완료된 문의는 삭제할 수 없습니다")
		else {
			var confirmResult = confirm("문의를 삭제하시겠습니까?")
			if(confirmResult) {
				location.href="${pageContext.request.contextPath }/users/deleteQuestion.do?qNo=${qPostVO.qNo}"	
			}
		}//else
		});//click
});//ready
</script>
<!-- Page Content -->
<div class="container">
	<!-- 문의 내용 -->
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h3 class="my-3 px-3">${qPostVO.qTitle}</h3>
			<p class="border border-left-0 border-right-0 py-3 px-3">글 번호: ${qPostVO.qNo} &nbsp;&nbsp;&nbsp; 작성 시간: ${qPostVO.qRegdate}
			&nbsp;&nbsp;&nbsp; 
			<c:choose>
			<c:when test="${qPostVO.qStatus=='처리중'}">
			<td><span class="label label-warning">${qPostVO.qStatus}</span></td>
			</c:when>
			<c:otherwise>
			<td><span class="label label-danger">${qPostVO.qStatus}</span></td>
			</c:otherwise>
			</c:choose></p>
			<div class="content">
			<!--글내용-->
				<div class="jumbotron">
					${qPostVO.qContents} <br><br><br>
				</div>
				
				<c:if test="${qPostVO.qStatus=='답변완료'}">
				<!--답변 부분-->
						<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h3 class="my-3 px-3">RE: &nbsp;${qAnswerVO.qTitle}</h3>
			<p class="border border-left-0 border-right-0 py-3 px-3">글 번호: ${qAnswerVO.qNo} &nbsp;&nbsp;&nbsp; 작성 시간: ${wqPostVO.wqRegdate}
			&nbsp;&nbsp;&nbsp; 
			<div class="content">
			<!--답변 내용-->
				<div class="jumbotron">
					${qAnswerVO.qContents} <br><br><br>
				</div>
				</div>
				</div>
				</c:if>
			</div>	
		</div>
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1">
			<div class="d-flex align-items-end">
					<a href="#" class="btn btn-sub-3 mr-1" id="questionUpdateBtn">수정</a>
					<a href="#" class="btn btn-sub-4" id="questionDeleteBtn">삭제</a>
					<a href="${pageContext.request.contextPath}/users/readMyQuestionList.do?nowPage=1" class="btn btn-sub-2 ml-auto mr-1">목록</a>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->