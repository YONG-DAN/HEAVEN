<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	/* $(document).ready(function(){
		$("#deleteMyActivity").click(function(){
			confirm("");
		});
	}); */
</script>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">마이페이지</h4>
</div>

<!-- /.Page Heading -->

<!-- Page Content -->
   <div class="container my-5">

	<div class="row">

		<div class="col-lg-3">
			<div class="list-group">
			<c:if test="${sessionScope.uvo.userGroupVO.ugroupNo=='1' }">
				<a href="${pageContext.request.contextPath }/users/readMyActivityList.do?nowPage=1" class="list-group-item active">재능기부 참여내역</a>
				<a href="${pageContext.request.contextPath }/users/readMyApplicationList.do?nowPage=1" class="list-group-item">재능기부 신청내역</a>
			</c:if>
			<c:if test="${sessionScope.uvo.userGroupVO.ugroupNo=='2' }">
				<a href="${pageContext.request.contextPath }/users/readMyTakingList.do?nowPage=1" class="list-group-item active">테이킹 내역</a>
			</c:if>	
			</div>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<c:if test="${sessionScope.uvo.userGroupVO.ugroupNo=='1' }">
				<h4 class="mb-4">재능기부 참여내역</h4>
				<table class="table table-hover myList">
				<thead>
					<tr>
						<th>#</th>
						<th>기부 프로젝트명</th>
						<th>참여 마일리지</th>
						<th>참여일</th>
						<th>취소신청</th>
					</tr>
				</thead>
				<tbody>			
					<c:forEach var="avo" items="${requestScope.aListVO.list}">	
					<tr>
						<td>${avo.aNo}</td>
						<td>${avo.joinPostVO.jpTitle}</td>
						<td>${avo.aMileage}</td>
						<td>${avo.aRegdate}</td>
						<td><a href="${pageContext.request.contextPath}/users/deleteMyActivity.do?rNo=${avo.aNo}" class="btn btn-sub-3 mr-1" id="deleteMyActivity">신청취소</a></td>
					</tr>
					</c:forEach>	
				</tbody>
			</table>
			</c:if>
			<c:if test="${sessionScope.uvo.userGroupVO.ugroupNo=='2'}">
				<h4 class="mb-4">테이킹 신청내역</h4>
				<table class="table table-hover myList">
				<thead>
					<tr>
						<th>#</th>
						<th>테이킹 프로젝트명</th>
						<th>신청 날짜</th>
						<th>후원 기간</th>
						<th>상세보기</th>
					</tr>
				</thead>
				<tbody>			
					<c:forEach var="jvo" items="${requestScope.jpList.list}">	
					<tr>
						<td>${jvo.jpNo}</td>
						<td>${jvo.jpTitle}</td>
						<td>${jvo.jpRegdate}</td>
						<td>${jvo.jpAppStartDate} ~ ${jvo.jpAppEndDate}</td>
						<td><a href="#" class="btn btn-sub-3 mr-1" id="deleteMyActivity">상세보기</a></td>
					</tr>
					</c:forEach>	
				</tbody>
			</table>
			</c:if>
			
			<c:if test="${sessionScope.uvo.userGroupVO.ugroupNo=='1' }">
	<!-- Pagination -->
	<c:set var="pb" value="${requestScope.aListVO.pbf}"></c:set>
	<ul class="pagination justify-content-center mt-5">
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/users/readMyReviewPostList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/users/readMyReviewPostList.do?nowPage=${i}">${i}</a>
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
				<a class="page-link" href="${pageContext.request.contextPath}/users/readMyReviewPostList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>
	</c:if>
	<c:if test="${sessionScope.uvo.userGroupVO.ugroupNo=='2' }">
	<!-- Pagination2 -->
	<c:set var="pb" value="${requestScope.jpList.pbf}"></c:set>
	<ul class="pagination justify-content-center mt-5">
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/users/readMyTakingList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/users/readMyTakingList.do?nowPage=${i}">${i}</a>
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
				<a class="page-link" href="${pageContext.request.contextPath}/users/readMyTakingList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>
	</c:if>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	
</div>