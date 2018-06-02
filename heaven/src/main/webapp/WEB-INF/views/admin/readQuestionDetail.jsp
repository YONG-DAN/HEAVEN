<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">�� ���� ����</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<!-- Contact Form -->
	<!-- In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0">
			<h3 class="my-3 px-3">${qVO.qTitle}</h3>
			<p class="border border-left-0 border-right-0 py-3 px-3"> �ۼ���: ${qVO.userVO.name}
			&nbsp;&nbsp; �ۼ���: ${qVO.qRegdate}</p>
			<div class="content">
			<!--�۳���-->
				<div class="jumbotron">
					${qVO.qContents }
				</div>
			</div>
			
		</div>
		
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1">
			<div class="d-flex align-items-end">
				<a href="${pageContext.request.contextPath }/admin/readAllQuestionList.do?nowPage=1" class="btn btn-sub-2 ml-auto mr-1 ">���</a>
					<c:if test="${sessionScope.uvo.userGroupVO.ugroupNo=='4' && qVO.qStatus=='ó����'}">
							<a href="${pageContext.request.contextPath}/admin/createQuestionAnswerForm.do?qNo=${qVO.qNo}" class="btn btn-sub-3 mr-1">�亯����</a>
					</c:if>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->