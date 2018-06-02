<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 재능기부 참여 상위3개 -->
<div class="jumbotron mb-0">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="${pageContext.request.contextPath }/donation/detail_donation.do">Project One</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Amet numquam aspernatur eum quasi sapiente
							nesciunt? Voluptatibus sit, repellat sequi itaque deserunt,
							dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Project Two</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipiscing elit. Nam viverra euismod odio, gravida pellentesque
							urna varius vitae.</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<a href="#"><img class="card-img-top"
						src="http://placehold.it/700x400" alt=""></a>
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">Project Three</a>
						</h4>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Quos quisquam, error quod sed cumque, odio
							distinctio velit nostrum temporibus necessitatibus et facere atque
							iure perspiciatis mollitia recusandae vero vel quam!</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 재능기부 신청하기 -->
<div class="bg-sub-1 py-3 mb-5">
	<div class="container">
		<div class="row">
			<div class="col-12">
			<c:choose>
				<c:when test="${uvo.userGroupVO.ugroupNo=='1' }">					
					<span class="text-white border-right mr-1 pr-2">당신의 재능을 많은 사람들과 나누어 보세요</span>
					<a href="${pageContext.request.contextPath }/donation/writeAppForm.do" class="text-white">재능기부 신청하기<i class="far fa-edit"></i></a>
				</c:when>
				<c:otherwise>
					<span class="text-white border-right mr-1 pr-2">다양한 재능기부에 참여해 보세요!</span>
					<a href="#entryList" class="text-white">재능기부 참여하기<i class="far fa-hand-point-up"></i></a>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</div>
</div> 



<!-- 재능기부 list -->
<div id="entryList" class="container">
	<!-- Project One -->
	<c:forEach items="${donationList.list }" var="list">
	<div class="row my-5">
		<div class="col-md-7">
			<a href="#"> <img class="img-fluid rounded mb-3 mb-md-0"
				src="${list.jpImgDirect }" alt="${list.jpTitle }">
			</a>
		</div>
		<div class="col-md-5">
			<h3>${list.jpTitle }</h3>
			<p>${list.jpSummary }</p>
			<p>${list.jpAppStartDate }-${list.jpAppEndDate }</p>
			<p>${list.totalEntry}/${list.goalEntry }</p>
			<a class="btn btn-point btn-sm" href="${pageContext.request.contextPath }/donation/readDonationDetail.do?jpNo=${list.jpNo}">View Project <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<hr>
	
	</c:forEach>
	<!-- /.row -->
	
	<!-- Pagination -->
	<c:set var="pb" value="${donationList.pbf}"></c:set>
	<ul class="pagination justify-content-center mt-5">
		<c:if test="${pb.previousPageGroup}">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationList.do?nowPage=${pb.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">Previous</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${pb.nowPage!=i}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationList.do?nowPage=${i}">${i}</a>
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
				<a class="page-link" href="${pageContext.request.contextPath}/donation/readDonationList.do?nowPage=${pb.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>

</div>
<!-- /.container -->