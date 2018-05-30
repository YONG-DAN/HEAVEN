<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- page heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">게시판</h4>
</div>

<div class="container">
	<div class="row">
		<div class="col-12 my-4">
			<form name="sentMessage" id="contactForm" novalidate>
				<div class="control-group form-group">
					<div class="controls">
						<label>작성자</label>
						<input type="tel" class="form-control" id="name" required data-validation-required-message="Please enter your phone number.">
					</div>
				</div>
			
				<div class="control-group form-group">
					<!-- 스마트 에디터-->
					<div class="controls">
						<textarea rows="10" cols="100" class="form-control" id="#" required data-validation-required-message="Please enter your message" maxlength="999" style="resize:none" placeholder="문의내용"></textarea>
					</div>
				</div>
				<div id="success"></div>
				<!-- For success/fail messages -->
				<button type="submit" class="btn btn-sub-2 btn-block" id="#">글쓰기</button>
			</form>
		</div>
	</div>
</div>