<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">관리자 페이지</h4>
</div>
<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container my-5">
	<!-- row -->
	<div class="row">
		<div class="col-lg-12 mb-1">
			<div class="card-group adminPage">
				<div class="col-lg-3 card text-center adminHover"
					onclick="location.href='${pageContext.request.contextPath}/admin/readTotalJoinPostList.do?nowPage=1'">
					<div class="card-body">
						<i class="fas fa-pencil-alt fa-3x"></i> <br> <br>
						<h5 class="card-title">신청서 관리</h5>
						<br>
						<p class="card-text">
							<span><b style="font-size: 40px"> ${qCount} </b></span>
							<small>총 신청&nbsp;건</small><br>
							<small>미처리 신청&nbsp;건</small>
							
						</p>
					</div>
				</div>
				<div class="col-lg-3 card text-center adminHover"
					onclick="location.href='${pageContext.request.contextPath}/admin/readAllQuestionList.do?nowPage=1'">
					<div class="card-body">
						<i class="fas fa-question fa-3x"></i> <br> <br>
						<h5 class="card-title">문의 게시판</h5>
						<br>
						<p class="card-text">
							미답변<span><b style="font-size: 40px"> ${qCount} </b></span>&nbsp;건
						</p>
					</div>
				</div>
				<div class="col-lg-3 card text-center adminHover"
					onclick="location.href='${pageContext.request.contextPath}/readTradePoint.do?nowPage=1'">
					<div class="card-body">
						<i class="fas fa-users fa-3x"></i> <br> <br>
						<h5 class="card-title">회원 관리</h5>
						<br>
						<p class="card-text">
							<span>총 회원 수 <b style="font-size: 40px">
									${memberCount} </b></span>&nbsp;명
						</p>
					</div>
				</div>
				<div class="col-lg-3 card text-center adminHover"
					onclick="location.href='${pageContext.request.contextPath}/admin/readPointList.do?nowPage=1'">
					<div class="card-body">
						<i class="fas fa-hand-holding-usd fa-3x"></i> <br> <br>
						<h5 class="card-title">포인트 지급</h5>
						<br>
						<p class="card-text">
							<span> 지급 예정 <b style="font-size: 40px">
									${tradePointCount} </b></span>&nbsp;건
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.container -->