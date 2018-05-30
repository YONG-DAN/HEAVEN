<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- page heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">게시판</h4>
</div>

<!-- list -->
<div class="container mt-5">
	<div class="row">
		<div class="col-12">
			<div class="d-flex align-items-end">
				<a href="${pageContext.request.contextPath }/board/write_board.do" class="btn btn-sub-2 ml-auto mr-1 " id="#">글쓰기</a>
			</div>
		</div>
	</div>
	<div class="row">
		<!-- Sidebar Column -->
		<div class="col-lg-3 mb-4">
			<div class="list-group">
				<a href="index.html" class="list-group-item">Home</a>
				<a href="about.html" class="list-group-item">About</a>
				<a href="services.html" class="list-group-item">Services</a>
			</div>
		</div>
		<!-- Content Column -->
		<div class="col-lg-9 mb-4">
			<h2 class="mb-5">Section Heading</h2>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>3</td>
						<td><a href="${pageContext.request.contextPath }/board/read_board.do">글제목입니다</a></td>
						<td>작성자</td>
						<td>작성일시</td>
					</tr>
					<tr>
						<td>2</td>
						<td>글제목입니다</td>
						<td>작성자</td>
						<td>작성일시</td>
					</tr>
					<tr>
						<td>1</td>
						<td>글제목입니다</td>
						<td>작성자</td>
						<td>작성일시</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- Pagination -->
<ul class="pagination justify-content-center">
	<li class="page-item">
		<a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			<span class="sr-only">Previous</span>
		</a>
	</li>
	<li class="page-item"><a class="page-link" href="#">1</a></li>
	<li class="page-item"><a class="page-link" href="#">2</a></li>
	<li class="page-item"><a class="page-link" href="#">3</a></li>
	<li class="page-item">
		<a class="page-link" href="#" aria-label="Next">
			<span aria-hidden="true">&raquo;</span>
			<span class="sr-only">Next</span>
		</a>
	</li>
</ul>