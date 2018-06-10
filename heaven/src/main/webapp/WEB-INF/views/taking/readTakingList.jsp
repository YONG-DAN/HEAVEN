<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- taking title -->
<div class="container">
	<h1 class="mt-4 mb-4">Taking</h1>
	<div class="breadcrumb bg-sub-1">
		<div class="row ml-2">
			<c:choose>
				<c:when test="${uvo.userGroupVO.ugroupNo=='2' }">					
					<span class="text-white border-right mr-1 pr-2">당신의 마음을 나눠주세요</span>
					<a href="${pageContext.request.contextPath }/donation/writeAppForm.do" class="text-white">taking 신청하기<i class="far fa-edit"></i></a>
				</c:when>
				<c:otherwise>
					<span class="text-white border-right mr-2 pr-2">다양한 후원에 참여해 보세요!</span>
					<a href="#entryList" class="text-white">참여하기<i class="fas fa-hand-point-down"></i></a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>

<!-- taking list -->
<div class="container mt-4">
	<div class="row">
		<c:forEach items="${takingList.list }" var="list">
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="${pageContext.request.contextPath }/taking/readTakingDetail.do?jpNo=${list.jpNo}">
					<img class="card-img-top" src="${list.jpImgDirect }" alt="${list.jpTitle}">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="${pageContext.request.contextPath }/taking/readTakingDetail.do?jpNo=${list.jpNo}" class="sub-1-txt">${list.jpTitle }</a>
					</h4>
					<p class="card-text">${list.jpSummary }</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>

<!-- Pagination -->
	<c:set var="pb" value="${takingList.pbf}" />
	<ul class="pagination justify-content-center mt-5">
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/taking/readTakingList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/taking/readTakingList.do?nowPage=${i}">${i}</a>
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
				<a class="page-link" href="${pageContext.request.contextPath}//taking/readTakingList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>