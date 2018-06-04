<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- page heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">이달의 기부자</h4>
</div>

<!-- list -->
<div class="container mt-5">
	<div class="row">
		<div class="col-12">
			<div class="d-flex align-items-end">
			<!-- 글쓰기 폼은 아직 구현하지 않았습니다 -->
				<a href="${pageContext.request.contextPath }/community/createCommunityPost.do" class="btn btn-sub-2 ml-auto mr-1 " id="#">글쓰기</a>
			</div>
		</div>
	</div>
	<div class="row">
		<!-- Content Column -->
		<div class="col-lg-12 mb-4">
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>글제목</th>
						<th>작성일시</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ivo" items="${iListVO.list}">	
					<tr>
						<td>${ivo.iNo}</td>
						<td><a href="${pageContext.request.contextPath }/community/communityDetail.do?iNo=${ivo.iNo}">${ivo.iTitle}</a></td>
						<td>${ivo.iRegdate}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

	<!-- Pagination -->
	<ul class="pagination justify-content-center mt-5">
		<c:set var="pb" value="${iListVO.pbf}"></c:set>
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item"><a class="page-link"
				href="${pageContext.request.contextPath}/users/readMyQuestionList.do?nowPage=${pb.startPageOfPageGroup-1}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only"> Previous </span>
			</a></li>
		</c:if>
		<c:forEach var="page" begin="${pb.startPageOfPageGroup}"
			end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=page}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/users/readMyQuestionList.do?nowPage=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item active"><a class="page-link" href="#">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pb.nextPageGroup}">
			<li class="page-item"><a class="page-link"
				href="${pageContext.request.contextPath}/users/readMyQuestionList.do?nowPage=${pb.endPageOfPageGroup+1}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span> 
				<span class="sr-only">Next</span>
			</a></li>
		</c:if>
	</ul>