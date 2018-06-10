<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(document).ready(function(){
		var minField = 1;
		var maxField = 10;
		var wrapper = $("#qnaListForm");
		var qnaForm = '<div id="qnaForm" class="border rounded p-3 mt-1"><div id="removeQNAbtn" class="text-right"><i class="fas fa-minus-circle text-secondary"></i></div>'+
						'<div class="mb-3"><label for="">질문</label><input type="text" name="" class="form-control" placeholder="질문을 입력하세요"></div>'+
						'<div class="mb-3"><label for="">답변</label><input type="text" name="" class="form-control" placeholder="답변을 입력하세요"></div>';
		
		var i = 1;
		$("#createQNAbtn>i").click(function(){
			if(i < maxField){
				i++;
				$(wrapper).append(qnaForm);
			}
			if(i > maxField){
				alert("질문과 답은 10개까지 가능합니다.");
			}
		});
		$(wrapper).on("click","#removeQNAbtn>i", function(){
			if(minField < i){
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
			<form action="/createCoummnityPost.do" method="post">
				<div id="qnaListForm">
					<div id="qnaForm" class="border rounded p-3">
						<div class="mb-3">
							<label for="">질문</label>
							<input type="text" name="" class="form-control" placeholder="질문을 입력하세요">
						</div>
						<div class="mb-3">
							<label for="">답변</label>
							<input type="text" name="" class="form-control" placeholder="답변을 입력하세요">
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

	