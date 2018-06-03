<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">신청서 목록</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
   <div class="container my-5">

	<div class="row">
		<div class="col-lg-3">
			<div class="list-group">
				<a href="${pageContext.request.contextPath }/admin/readTotalJoinPostList.do?nowPage=1" class="list-group-item active">전체 신청서</a>
				<a href="${pageContext.request.contextPath }/admin/readApprovalJoinPostList.do?nowPage=1" class="list-group-item active">승인 신청서</a>
				<a href="${pageContext.request.contextPath }/admin/readUnapprovalJoinPostList.do?nowPage=1" class="list-group-item active">미처리 신청서</a>
				<a href="${pageContext.request.contextPath }/admin/readRefusalApprovalJoinPostList.do?nowPage=1" class="list-group-item">거절처리 신청서</a>
			</div>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9 adminJoinList">
			<h4 class="mb-4">거절처리 재능기부 신청서</h4>
			<table class="table table-hover myList">
				<thead>
					<tr>
						<th>#</th>
						<th>기부 프로젝트명</th>
						<th>신청일</th>
						<th>신청자</th>
						<th>승인처리</th>
					</tr>
				</thead>
				<tbody>						
					<c:forEach var="jpgvo" items="${requestScope.jpgListVO.list}">	
					<tr>
						<td>${jpgvo.jpNo}</td>
						<td><a href="#opret-produkt" data-toggle="collapse" data-parent="#help-accordion-1">${jpgvo.jpTitle}</a></td>
						<td>${jpgvo.jpRegdate}</td>
						<td>${jpgvo.userVO.id}</td>
						<td>거절</td>
					</tr>
					</c:forEach>	
				</tbody>
			</table>
			<!-- Pagination -->
	<c:set var="pb" value="${requestScope.jpgListVO.pbf}"></c:set>
	<ul class="pagination justify-content-center">
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/admin/readRefusalApprovalJoinPostList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/admin/readRefusalApprovalJoinPostList.do?nowPage=${i}">${i}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="#">${i}</a>
					</li>
				</c:otherwise>
			</c:choose>
			&nbsp;
		</c:forEach>
		<c:if test="${pb.nextPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/admin/readRefusalApprovalJoinPostList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	
	
	<!-- 테이킹 신청 목록 -->
	<div class="row">
		<div class="col-lg-3"></div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9 adminJoinList">
			<h4 class="mb-4">거절처리 테이킹 신청서</h4>
			<table class="table table-hover myList">
				<thead>
					<tr>
						<th>#</th>
						<th>기부 프로젝트명</th>
						<th>신청일</th>
						<th>신청자</th>
						<th>승인처리</th>
					</tr>
				</thead>
				<tbody>						
					<c:forEach var="jptvo" items="${requestScope.jptListVO.list}">	
					<tr>
						<td>${jptvo.jpNo}</td>
						<td><a href="#opret-produkt" data-toggle="collapse" data-parent="#help-accordion-1">${jptvo.jpTitle}</a></td>
						<td>${jptvo.jpRegdate}</td>
						<td>${jptvo.userVO.id}</td>
						<td>거절</td>
					</tr>
					</c:forEach>	
				</tbody>
			</table>
			<!-- /.col-lg-9 -->
			<!-- Pagination -->
	<c:set var="pb" value="${requestScope.jptListVO.pbf}"></c:set>
	<ul class="pagination justify-content-center">
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/admin/readRefusalApprovalJoinPostList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/admin/readRefusalApprovalJoinPostList.do?nowPage=${i}">${i}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="#">${i}</a>
					</li>
				</c:otherwise>
			</c:choose>
			&nbsp;
		</c:forEach>
		<c:if test="${pb.nextPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/admin/readRefusalApprovalJoinPostList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>
		</div>
		
	</div>

</div>
<!-- /.container -->