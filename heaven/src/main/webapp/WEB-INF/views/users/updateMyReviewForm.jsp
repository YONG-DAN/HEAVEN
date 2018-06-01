<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script type="text/javascript">
$(document).ready(function(){
	$("#reviewForm").submit(function(){
		alert("�ıⰡ �����Ǿ����ϴ�.");
	});//click
}); //ready
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
	<form id="reviewForm" action="${pageContext.request.contextPath}/users/updateMyReviewDetail.do" method="post" novalidate>
	<input type="hidden" name="rNo" value="${reviewVO.rNo}">
	<div class="row">
		<div class="col-10 offset-lg-1 my-4 border border-left-0 border-right-0 updateMyReview">
			<p class="my-3 px-3">#${reviewVO.rNo}
			  �� ���� : </p>
			<input type="text" class=" form-control rTitleInputTitle" name="rTitle" placeholder="����" value="${reviewVO.rTitle}">

			<p class="border border-left-0 border-right-0 py-3 px-3">
			<span>���� ���Ȱ�� : ${reviewVO.activityVO.joinPostVO.jpTitle} &nbsp; 	&#5;</span>
			&nbsp;�ۼ����� : ${reviewVO.rRegdate} &#5;
			</p>
			<div class="lastDiv">
			<p class="my-3 px-3 lastP">���� ���� :</p>
			<input type="text" class="form-control rTitleInputRate" name="rRate" placeholder="����" value="${reviewVO.rRate}">	
			</div>
			<!--�۳���-->
				<div class="jumbotron">
					<textarea rows="10" cols="100" class="form-control" name="rContents" maxlength="999" style="resize:none" placeholder="����">${reviewVO.rContents}</textarea>
				</div>
		</div>
	</div>
		<button type="submit" class="btn btn-sub-2 btn-block col-10" id="sendMessageButton">�����ϱ�</button>
	</form>
	</div>

	<!-- /.row -->

<!-- /.container -->