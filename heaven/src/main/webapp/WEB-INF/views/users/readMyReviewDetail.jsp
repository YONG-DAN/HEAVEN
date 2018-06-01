<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#questionUpdateBtn").click(function(){
			alert(${rPostVO.rpNo});
			location.href="${pageContext.request.contextPath }/member/updatMyReviewForm.do?rpNo=${rPostVO.rpNo}"
	});//click 
	$("#deleteBtn").click(function() {
		var result = confirm("�ı⸦ �����Ͻðڽ��ϱ�?")
		if(result)
			location.href="${pageContext.request.contextPath}/member/deleteMyReview.do?rpNo=${reviewPostVO.rpNo}";
	});//click
});//ready
</script>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">�� ����</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h4 class="my-3 px-3">#${reviewPostVO.rpNo} �� ���� : ${reviewPostVO.rpTitle}</h4>
			<p class="border border-left-0 border-right-0 py-3 px-3">
			<span>���� ���Ȱ�� : ${reviewPostVO.dpVO.dpTitle} &nbsp; 	&#5;</span>
			&nbsp;���� ���� : ${reviewPostVO.rpRate} �� &nbsp; 	&#5;
			�ۼ����� : ${reviewPostVO.rpRegdate}</p>
			<!--�۳���-->
				<div class="jumbotron">
					${reviewPostVO.rpContents}
				</div>
			</div>
			
		</div>
		
	</div>
	<div class="row">
		<div class="col-9 offset-lg-1">
			<div class="d-flex align-items-end">
				<a href="${pageContext.request.contextPath}/users/readMyReviewList.do?nowPage=1" class="btn btn-sub-2-gnt ml-auto mr-1 " id="#" >���</a>
				<a href="${pageContext.request.contextPath }/users/updateMyReviewForm.do?rpNo=${reviewPostVO.rpNo}" class="btn btn-sub-3-gnt mr-1" id="#">����</a>
				<a href="#" class="btn btn-sub-4-gnt" id="deleteBtn">����</a>
			</div>
		</div>
	</div>
	<!-- /.row -->

<!-- /.container -->