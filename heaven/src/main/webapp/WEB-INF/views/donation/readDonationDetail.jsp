<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 재능기부 정보 -->	
<div class="container my-5">
	<div class="row">
		<div class="col-md-7">
			<img class="img-fluid" src="http://placehold.it/750x500" alt="">
		</div>
		<div class="col-md-5">
			<h3 class="mb-3">${donationVO.jpTitle }</h3>
			<p>${donationVO.jpSummary }</p>
			<ul class="jumbotron list-unstyled">
				<li class="mb-2"><i class="far fa-calendar-alt"></i>신청기간 ${donationVO.jpAppStartDate } - ${donationVO.jpAppEndDate }</li>
				<li class="mb-2"><i class="far fa-calendar-alt"></i>모임일자 ${donationVO.jpEventStartDate } - ${donationVO.jpEventEndDate }</li>
				<li class="mb-2"><i class="fas fa-users"></i>현재 참여자 수 ${donationVO.totalEntry }명</li>
				<li class="mb-2"><i class="fas fa-male"></i> / <i class="fas fa-female"></i></li>
			</ul>
			<button class="btn btn-point btn-lg btn-block" data-toggle="modal" data-target="#entryModal">참여하기</button>
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.container -->

<!-- 참여하기 modal -->
<!-- Modal -->
<div class="modal fade" id="entryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header bg-point white-txt">
				<h5 class="modal-title" id="exampleModalLabel">참여하기</h5>
				<button type="button" class="close white-txt" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="jumbotron">
					<input type="hidden" name="jpNo" value="${donationVO.jpNo }">
					<p>${donationVO.jpTitle }</p>
					<p>${donationVO.jpEventStartDate } - ${donationVO.jpEventEndDate }</p>
					<p>${donationVO.jpPlace }</p>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-point">참여하기</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<!-- menu -->
<nav class="mt-5 border-top border-bottom">
	<div class="container border-left border-right">
		<ul class="nav nav-pills">	
			<li class="nav-item">
				<a class="nav-link sub-1-txt" href="#">재능기부 소개</a>
			</li>
			<li class="nav-item">
				<a class="nav-link sub-1-txt" href="#">응원메시지</a>
			</li>	
			<li class="nav-item">
				<a class="nav-link sub-1-txt" href="#">후기</a>
			</li>
			
		</ul>
	</div>
</nav>

<!-- sidebar detail -->
<div class="container">
	<div class="row">
		<!-- 재능기부 설명 - editor -->
		<div class="col-lg-8">
			<div class="card my-4">
				<div class="card-body">
					${donationVO.jpContents }
				</div>
			</div>
		</div>
		
		<!-- 재능기부 기부자 정보 등 -->
		<div class="col-lg-4 col-mb-4">
			<div class="card my-4">
				<h6 class="card-header">모임장소</h6>
				<div class="card-body">
				  <p><i class="fas fa-map-marker-alt"></i>${donationVO.jpPlace }</p>
				  <div id="map"></div>
				</div>
			</div>
			<div class="card my-4">
				<h6 class="card-header">재능기부자 소개</h6>
				<div class="card-body">
					<p><i class="fas fa-user-circle"></i>${donationVO.userVO.name }</p>
					<p><i class="fas fa-at"></i>${donationVO.userVO.email }</p>
					<p><i class="fas fa-id-badge"></i>${donationVO.userVO.userGroupVO.ugroupName } / ${donationVO.userVO.userGradeVO.ugradeName }</p>
					<p></p>				  
				</div>
			</div>
			
			<!-- <div class="card my-4">
				<h6 class="card-header">Side Widget</h6>
				<div class="card-body">
				  You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
				</div>
			</div> -->
		</div>
	</div>
</div>