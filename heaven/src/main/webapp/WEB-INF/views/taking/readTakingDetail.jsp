<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

${takingVO }
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
			<img class="img-fluid" src="${takingVO.jpImgDirect }" alt="${takingVO.jpTitle }">
		</div>
		<div class="col-md-5">
			<h3 class="mb-3">${takingVO.jpTitle }</h3>
			<p>${takingVO.jpSummary }</p>
			<ul class="jumbotron list-unstyled py-4">
				<li class="mb-2"><i class="far fa-calendar-alt"></i>신청기간 ${takingVO.jpAppStartDate } - ${takingVO.jpAppEndDate }</li>
				<li class="mb-2"><i class="fas fa-users"></i>현재 참여자 수 ${takingVO.totalEntry }명 </li>				
				<li class="mb-2">모금 마일리지 ${takingVO.totalMileage} / 목표 마일리지 ${takingVO.goalMileage }</li>
				<li class="mb-2"><h3 class="mt-3 sub-1-txt-gnt">${(takingVO.totalMileage/takingVO.goalMileage)*100 }%</h3></li>
				<li class="progress bg-white mb-3">
					<div class="progress-bar bg-sub-3" role="progressbar" style="width:${(takingVO.totalMileage/takingVO.goalMileage)*100 }%" aria-valuenow="${(takingVO.totalMileage/takingVO.goalMileage)*100 }" aria-valuemin="0" aria-valuemax="100"></div>
				</li>
			</ul>
			<c:choose>
				<c:when test="${sessionScope.uvo==null }">
					<a class="btn bg-sub-1 btn-lg btn-block" href="${pageContext.request.contextPath }/users/loginForm.do"> 로그인 후 참여가 가능합니다 </a>	
				</c:when>
				<c:when test="${sessionScope.uvo.id==takingVO.userVO.id }">
					<button class="btn bg-sub-1 btn-lg btn-block" > taking 주최자는 참여 할 수 없습니다. </button>	
				</c:when>
				<c:when test="${sessionScope.uvo.userGroupVO.ugroupNo != 1}">
					<button class="btn bg-sub-1 btn-lg btn-block" > 개인회원만 참여 가능합니다. </button>	
				</c:when>
				<c:otherwise>
					<button class="btn bg-sub-1 btn-lg btn-block" data-toggle="modal" data-target="#entryModal">참여하기</button>	
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
				<input type="hidden" name="jpNo" value="${takingVO.jpNo }">
				<input type="hidden" name="id" value="${sessionScope.uvo.id }">
				<input type="hidden" name="name" value="${sessionScope.uvo.name }">
				<input type="hidden" name="jpGroupNo" value="${takingVO.joinPostGroupVO.jpGroupNo}">
				<ul class="jumbotron list-unstyled py-4">
					<li class="mb-2">${takingVO.jpTitle }</li>
					<li class="mb-2"><i class="far fa-calendar-alt"></i>모임기간 ${takingVO.jpAppStartDate } - ${takingVO.jpAppEndDate }</li>
				</ul>
				<div class="mb-3">
					<label for="jpSummary">응원메시지</label>
					<small class="text-muted">따뜻한 응원메시지를 남겨보세요</small>
					<input type="text" class="form-control" name="cheerUpMessage" id="cheerUpMessage">
				</div>
				<div class="mb-3">
					<label for="jpSummary">모금 마일리지</label>
					<small class="text-muted">마일리지로 전해보세요</small>
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
		<ul class="nav nav-pills" id="pills-tab" role="tablist">
			<li class="nav-item">
				<a class="nav-link active" id="info-tab" data-toggle="pill" href="#info" role="tab" aria-controls="info" aria-selected="true">taking 소개</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" id="msg-tab" data-toggle="pill" href="#msg" role="tab" aria-controls="msg" aria-selected="false">응원메시지</a>
			</li>
		</ul>
	</div>
</nav>

<div class="container">
	<div class="row">
		<div class="col-lg-8">
			<div class="tab-content" id="pills-tabContent">
				<!-- 해당 재능기부 소개  -->
				<div class="tab-pane fade show active" id="info" role="tabpanel" aria-labelledby="info-tab">
					<div class="card my-4">
						<div class="card-header">재능기부 소개</div>
						<div class="card-body">
							${takingVO.jpContents }
						</div>
					</div>
				</div>
				<!-- 응원 메시지 -->
				<div class="tab-pane fade" id="msg" role="tabpanel" aria-labelledby="msg-tab">
					<div class="card my-4">
						<div class="card-header">응원메시지</div>
						<div class="card-body">
							<table class="table table-hover">
								<tbody>
									<c:choose>
										<c:when test="${fn:length(activityList)==0}">
											<div class="mt-3 mb-3">여러분의 참여를 기다립니다.</div>
										</c:when>
										<c:otherwise>
											<c:forEach items="${activityList }" var="list">
												<tr>
													<td><img alt="default_img" src="${pageContext.request.contextPath }/resources/img/default_img.png" class="" ></td>
													<td>${list.cheerUpMessage }</td>
													<td>${list.aMileage } 마일리지</td>
													<td>${list.userVO.name }</td>
													<td>${list.aRegdate }</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>			
		</div>
		<!-- 재능기부 기부자 정보 등 -->
		<div class="col-lg-4 col-mb-4">
			<div class="card my-4">
				<h6 class="card-header">taking 주최자 소개</h6>
				<div class="card-body">
					<p><i class="fas fa-user-circle"></i>${takingVO.userVO.name }</p>
					<p><i class="fas fa-at"></i>${takingVO.userVO.email }</p>
					<p><i class="fas fa-id-badge"></i>${takingVO.userVO.userGroupVO.ugroupName } / ${takingVO.userVO.userGradeVO.ugradeName }</p>
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
