<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(document).ready(function(){
		// 최소 질문/답 수
		var minField = 1;
		// 최대 질문/답 수
		var maxField = 10;
		// 질문/답을 감싸고 있는 wrapper
		var wrapper = $("#qnaListForm");
		// +누르면 추가될 html
		var qnaForm = '<div id="qnaForm" class="border rounded p-3 mt-1"><div id="removeQNAbtn" class="text-right"><i class="fas fa-minus-circle text-secondary"></i></div>'+
						'<div class="mb-3"><label for="question">질문</label><input type="text" name="question" class="form-control" placeholder="질문을 입력하세요" required></div>'+
						'<div class="mb-3"><label for="answer">답변</label><input type="text" name="answer" class="form-control" placeholder="답변을 입력하세요" required></div>';
		
		// 현재 질문/답 form의 수를 체크할 변수
		var i = 1;
		
		// +(추가)버튼을 누를 때
		$("#createQNAbtn>i").click(function(){ 
			// 질문/답 form이 10개 이하이면
			if(i < maxField){
				i++;
				// 추가
				$(wrapper).append(qnaForm);
			}
			// 질문/답 form이 10개 초과이면
			if(i > maxField){
				//경고창
				alert("질문과 답은 10개까지 가능합니다.");
			}
		});
		// -(삭제)버튼을 누를 때
		$(wrapper).on("click","#removeQNAbtn>i", function(){
			// 질문/답 form이 1개보다 크면
			if(minField < i){
				// #qnaForm 포함 이하에 html을 삭제
				$(this).parentsUntil('#qnaListForm').remove();
				i--;
			}
		})
	});
</script>
<!-- page heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">이달의 기부자 글쓰기</h4>
</div>

<div class="container">
	<div class="row">
		<div class="col-md-8 offset-md-2 order-md-1 my-4">
			<form action="${pageContext.request.contextPath }/community/createCoummnityPost.do" method="post">
				<div class="mb-3">
					<label for="iTitle">제목</label>
					<input type="text" name="iTitle" id="iTitle" class="form-control" placeholder="제목을 입력하세요"/>
				</div>
				<div class="mb-3">
					<label for="iTitle">대표이미지</label>
					<input type="text" name="iImgDirectory" id="iImgDirectory" class="form-control" value="img"/>
				</div>
				<div id="qnaListForm">
					<div id="qnaForm" class="border rounded p-3">
						<div class="mb-3">
							<label for="question">질문</label>
							<input type="text" name="question" class="form-control" placeholder="질문을 입력하세요" required>
						</div>
						<div class="mb-3">
							<label for="answer">답변</label>
							<input type="text" name="answer" class="form-control" placeholder="답변을 입력하세요" required>
						</div>						
					</div>
				</div>				
				<div id="createQNAbtn" class="text-center">
					<i class="fas fa-plus-circle sub-3-txt fa-5x my-5"></i>
				</div>
				<button type="submit" class="btn btn-sub-2 btn-block" id="#">글쓰기</button>
			</form>
		</div>
	</div>
</div>

	