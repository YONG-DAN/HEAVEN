<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Page Heading -->
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">고객 문의 목록</h4>
</div>
<!-- /.Page Heading -->
<!-- Page Content -->
<div class="container">
	<div class="col-10 offset-lg-1"></div>
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th>작성일</th>
						<th>상태</th>
<%-- 			thead에 드롭박스로 미처리 문의 글만 모아보기
				<th class="dropdown">
                   <a href="#" data-toggle="dropdown" class="dropdown-toggle">상태<b class="caret"></b></a>
                   <ul class="dropdown-menu">
                      <li><a href="${pageContext.request.contextPath}/admin/readUnansweredQuestionDetail.do">처리중</a></li>
                      <li><a href="#">답변완료</a></li>
                   </ul>
                </th> --%>
					</tr>
				</thead>
				<tbody>
					<c:set value="${qListVO.list}" var="qPostVO" />
					<c:forEach items="${qPostVO}" var="qPostVO" varStatus="count">
							<td>${qPostVO.qNo}</td>
							<c:choose>
								<c:when test="${!qPostVO.answer}">
									<td><a href="${pageContext.request.contextPath}/admin/readQuestionDetail.do?qNo=${qPostVO.qNo}" class="pl-4"><span style="color:#f35b56">⇒ Re: </span>${qPostVO.qTitle}</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="${pageContext.request.contextPath}/admin/readQuestionDetail.do?qNo=${qPostVO.qNo}">${qPostVO.qTitle}</a></td>
								</c:otherwise>
							</c:choose>
							<td>${qPostVO.qRegdate}</td>
							<c:choose>
								<c:when test="${qPostVO.qStatus=='처리중'}">
									<td><span class="label label-warning">${qPostVO.qStatus}</span></td>
								</c:when>
								<c:when test="${qPostVO.qStatus=='답변'}">
									<td></td>
								</c:when>
								<c:otherwise>
									<td><span class="label label-danger">${qPostVO.qStatus}</span></td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.row -->

	<hr>

	<!-- Pagination -->
	<ul class="pagination justify-content-center mt-5">
		<c:set var="pb" value="${qListVO.pbt}"></c:set>
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item"><a class="page-link"
				href="${pageContext.request.contextPath}/admin/readAllQuestionList.do?nowPage=${pb.startPageOfPageGroup-1}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only"> Previous </span>
			</a></li>
		</c:if>
		<c:forEach var="page" begin="${pb.startPageOfPageGroup}"
			end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=page}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/admin/readAllQuestionList.do?nowPage=${page}">${page}</a>
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
				href="${pageContext.request.contextPath}/admin/readAllQuestionList.do?nowPage=${pb.endPageOfPageGroup+1}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span> 
				<span class="sr-only">Next</span>
			</a></li>
		</c:if>
	</ul>

</div>
<!-- /.container -->