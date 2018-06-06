<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
$(document).ready(function(){
	$("#entryBtn").submit(function(){
		//사용할 마일리지를 적지 않았을 경우
		if($("#aMileage").val() == "" || $("#aMileage").val() == null){
			alert("사용할 마일리지 액수를 적어주세요");
			return false;
		// 입력한 마일리지가 0 인 경우
		}if(parseInt($("#aMileage").val())==0){
			alert("마일리지 0 이상부터 가능합니다.")
			return false;
		// 입력한 마일리지 액수가 보유 마일리지 액수보다 클 경우
		}else if(parseInt($("#aMileage").val()) > parseInt($("#userMileage").text())){
			alert("보유하고 있는 마일리지 액수를 초과하였습니다.");
			return false;
		}else if(!$('input:checkbox[id="entryAgree"]').is(":checked")){
			alert("상기 내용에 동의하지 않으셨습니다. 동의해주세요.");
			return false;
		}
	});	
});
</script>
<!-- 재능기부 정보 -->
<div class="container my-5">
	<div class="row">
		<div class="col-md-7">
			<img class="img-fluid" src="${donationVO.jpImgDirect }" alt="${donationVO.jpTitle }">
		</div>
		<div class="col-md-5">
			<h3 class="mb-3">${donationVO.jpTitle }</h3>
			<p>${donationVO.jpSummary }</p>
			<ul class="jumbotron list-unstyled py-4">
				<li class="mb-2"><i class="far fa-calendar-alt"></i>신청기간 ${donationVO.jpAppStartDate } - ${donationVO.jpAppEndDate }</li>
				<li class="mb-2"><i class="far fa-calendar-alt"></i>모임일자 ${donationVO.jpEventStartDate } - ${donationVO.jpEventEndDate }</li>
				<li class="mb-2"><i class="fas fa-users"></i>현재 참여자 수 ${donationVO.totalEntry }명 / 목표 참여자 수 ${donationVO.goalEntry }명</li>
				<li class="mb-2"><i class="fas fa-male"></i>${maleEntry }명 / <i class="fas fa-female"></i>${femaleEntry }명</li>
			</ul>
			<c:choose>
				<c:when test="${sessionScope.uvo==null }">
					<button class="btn btn-point btn-lg btn-block" > 로그인 후 참여가 가능합니다 </button>	
				</c:when>
				<c:when test="${sessionScope.uvo.id==donationVO.userVO.id }">
					<button class="btn btn-point btn-lg btn-block" > 재능기부자는 참여 할 수 없습니다. </button>	
				</c:when>
				<c:when test="${sessionScope.uvo.userGroupVO.ugroupNo != 1}">
					<button class="btn btn-point btn-lg btn-block" > 개인회원만 참여 가능합니다. </button>	
				</c:when>
				<c:when test="${entryVO != null}">
					<button class="btn btn-point btn-lg btn-block" > 참여는 한번만 가능합니다. </button>	
				</c:when>
				<c:otherwise>
					<button class="btn btn-point btn-lg btn-block" data-toggle="modal" data-target="#entryModal">참여하기</button>	
				</c:otherwise>
			</c:choose>
			
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
			<form action="${pageContext.request.contextPath }/addUserActivity.do" method="post" id="entryBtn">
			<div class="modal-body">
				<input type="hidden" name="jpNo" value="${donationVO.jpNo }">
				<input type="hidden" name="id" value="${sessionScope.uvo.id }">
				<input type="hidden" name="name" value="${sessionScope.uvo.name }">
				<ul class="jumbotron list-unstyled py-4">
					<li class="mb-2">${donationVO.jpTitle }</li>
					<li class="mb-2"><i class="far fa-calendar-alt"></i>모임기간 ${donationVO.jpEventStartDate } - ${donationVO.jpEventEndDate }</li>
					<li class="mb-2"><i class="fas fa-map-marker-alt"></i>모임 장소 ${donationVO.jpPlace }</li>
				</ul>
				<div class="mb-3">
					<label for="jpSummary">응원메시지</label>
					<small class="text-muted">재능기부자에게 따뜻한 응원메시지를 남겨보세요</small>
					<input type="text" class="form-control" name="cheerUpMessage" id="cheerUpMessage">
				</div>
				<div class="mb-3">
					<label for="jpSummary">감사 마일리지</label>
					<small class="text-muted">재능기부에 대한 감사의 마음을 마일리지로 전해보세요</small>
					<input type="number" class="form-control" name="aMileage" id="aMileage">
					<small class="text-muted">보유 마일리지 : <span id="userMileage">${sessionScope.uvo.mileage }</span></small>
				</div>
				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" id="entryAgree">
					<label class="custom-control-label" for="entryAgree">상기 내역에 동의합니다.</label>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-point">참여하기</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
			</form>
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
				<a class="nav-link sub-1-txt" href="${pageContext.request.contextPath }/donation/readCheerUpMessageList.do?jpNo=${donationVO.jpNo }">응원메시지</a>
			</li>	
			<li class="nav-item">
				<a class="nav-link sub-1-txt" href="${pageContext.request.contextPath }/donation/readReviewList.do?jpNo=${donationVO.jpNo }">후기</a>
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
				  <div id="map" style="width:100%; height:200px;"></div>
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