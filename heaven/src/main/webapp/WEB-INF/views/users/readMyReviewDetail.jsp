<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#deleteBtn").click(function() {
		var result = confirm("후기를 삭제하시겠습니까?")
		if(result)
			location.href="${pageContext.request.contextPath}/users/deleteMyReview.do?rNo=${reviewVO.rNo}";
	});//click
});//ready
</script>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">나의 후기글 보기</h4>
</div>

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h4 class="my-3 px-3">#${reviewVO.rNo} 글 제목 : ${reviewVO.rTitle}</h4>
			<p class="border border-left-0 border-right-0 py-3 px-3">
			<span>참여 기부활동 : ${reviewVO.activityVO.joinPostVO.jpTitle} &nbsp; 	&#5;</span>
			&nbsp;나의 평점 : ${reviewVO.rRate} 점 &nbsp; 	&#5;
			작성일자 : ${reviewVO.rRegdate}</p>
			<!--글내용-->
				<div class="jumbotron">
					${reviewVO.rContents}
				</div> 
		</div>
			
		</div>
	</div>
	<div class="row">
		<div class="col-9 offset-lg-1">
			<div class="d-flex align-items-end">
				<a href="${pageContext.request.contextPath}/users/readMyReviewList.do?nowPage=1" class="btn btn-sub-2 ml-auto mr-1 " id="#" >목록</a>
				<a href="${pageContext.request.contextPath }/users/updateMyReviewForm.do?rNo=${reviewVO.rNo}" class="btn btn-sub-3 mr-1" id="#">수정</a>
				<a href="${pageContext.request.contextPath }/users/deleteMyReview.do?rNo=${reviewVO.rNo}" class="btn btn-sub-4" id="deleteBtn">삭제</a>
			</div>
		</div>
	</div>
	<!-- /.row -->

<!-- /.container -->