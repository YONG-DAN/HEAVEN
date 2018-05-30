<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- page heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">게시판</h4>
</div>

<!-- read form -->
<div class="container mt-5">
	<!-- Sidebar Column -->
	<div class="row">
		<div class="col-lg-3 mb-4">
			<div class="list-group">
				<a href="index.html" class="list-group-item">Home</a>
				<a href="about.html" class="list-group-item">About</a>
				<a href="services.html" class="list-group-item">Services</a>
			</div>
		</div>
		<!-- Content Column -->
		<div class="col-lg-9 mb-4">
			<h3 class="my-3 px-3">글제목</h3>
			<p class="border border-left-0 border-right-0 py-3 px-3">작성자, 작성일자</p>
			<div class="content">
			<!--글내용-->
				<div class="jumbotron">
					글내용
				</div>
			</div>
			
		</div>
		
	</div>
	<div class="row">
		<div class="col-12">
			<div class="d-flex align-items-end">
				<a href="${pageContext.request.contextPath }/board/list_board_left.do" class="btn btn-sub-2 ml-auto mr-1 " id="#">목록</a>
				<a href="${pageContext.request.contextPath }/board/update_board_left.do" class="btn btn-sub-3 mr-1" id="#">수정</a>
				<a href="#" class="btn btn-sub-4" id="#">삭제</a>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /.container -->