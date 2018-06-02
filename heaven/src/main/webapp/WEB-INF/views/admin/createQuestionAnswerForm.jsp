<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">문의 글 답변쓰기</h4>
</div>
<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-6 offset-lg-3 my-4">
		<form action="${pageContext.request.contextPath}/admin/createQuestionAnswer.do" method="post" novalidate>
				<div class="control-group form-group">
					<div class="controls">
						<input type="text" class="form-control" name="qTitle" value="${qVO.qTitle}" placeholder="제목">
						<input type="hidden" name="userVO.id" value="${sessionScope.uvo.id}">
						<input type="hidden" name="qNo" value="${qNo}">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group form-group">
					<div class="controls">
						<textarea rows="10" cols="100" class="form-control" name="qContents" maxlength="999" style="resize:none" placeholder="내용"></textarea>
					</div>
<!-- 					<div class="control-group form-group">
					스마트 에디터
					<div class="controls">
						<textarea name="qContents" id="appContents" rows="10" cols="100"
							style="width:636px; height:412px;"></textarea>
					</div>
					</div> -->
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="submit" id="savebutton" class="btn btn-sub-2 btn-block">작성</button>
			</form>
		</div>

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->