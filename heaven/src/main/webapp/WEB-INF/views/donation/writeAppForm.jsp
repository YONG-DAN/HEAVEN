<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(document).ready(function(){
	alert("동작");
});
</script>
<div class="container">
	<div class="row">
		<div class="col-md-8 offset-md-2 order-md-1">
			<h4 class="mb-3">재능기부 신청서</h4>
			<h4 class="mb-3">taking 신청서</h4>
			<form action="${pageContext.request.contextPath }/application.do" method="post">
				<input type="hidden" name="jpGroupNo" value="${uvo.userGroupVO.ugroupNo }">
				<!-- 이름 -->
				<div class="mb-3">
					<label for="jpTitle">재능기부명</label>
					<small class="text-muted">재능기부의 주제가 드러나는 제목을 써주세요</small>
					<input type="text" class="form-control" name="jpTitle" required>
				</div>
				<!-- 요약 -->	
				<div class="mb-3">
					<label for="jpSummary">재능기부 요약</label>
					<small class="text-muted">본 재능기부를 간략하게 소개해 주세요</small>
					<input type="text" class="form-control" name="jpSummary" required>
				</div>
				<!-- 재능기부 참여 신청(모집)기간 -->
				<div class="mb-3">
					<label for="">신청기간</label>
					<small class="text-muted">재능기부 참여를 신청 받을 기간을 선택하세요</small>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="jpAppStartDate" class="text-muted">신청 시작 날짜</label>
							<input type="date" class="form-control" name="jpAppStartDate" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="jpAppEndDate" class="text-muted">신청 마감 날짜</label>
							<input type="date" class="form-control" name="jpAppEndDate" required>
						</div>
					</div>
				</div>
				<!-- 재능기부 모임 기간 -->
				<div class="mb-3">
					<label for="">모임기간</label>
						<small class="text-muted">재능기부 모임 기간을 선택하세요</small>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="jpEventStartDate" class="text-muted">모임 시작 날짜</label>
							<input type="date" class="form-control" name="jpEventStartDate" required>
						</div>
						<div class="col-md-6 mb-3">
							<label for="jpEventEndDate" class="text-muted">모임 마감 날짜</label>
							<input type="date" class="form-control" name="jpEventEndDate" required>
						</div>
					</div>
				</div>
				<!-- 모임 장소 -->
				<div class="mb-3">
					<label for="jpTitle">모임 장소</label>
					<small class="text-muted">모일 장소를 검색하세요</small>
					<div class="input-group">
						<input type="text" class="form-control" name="jpPlace" aria-describedby="basic-addon2"/>
						<div class="input-group-append">
							<button type="button" class="btn btn-sub-2" onclick="execPostCode()"><i class="fa fa-search"></i></button>
						</div>
					</div>
				</div>
				<!-- 대표이미지 -->
				<div class="mb-3">
					<label for="jpImgDirect">대표이미지</label>
					<small class="text-muted">재능기부 목록과 상세화면에서 보여지는 대표 이미지를 등록하세요</small>
					<input type="file" class="form-control" name="jpImgDirect" required>
				</div>
				<!-- 목표 참여자수 -->
				<div class="mb-3">
					<label for="goalEntry">목표 참여자 수</label>
					<small class="text-muted">최소 10명이상 선택하세요</small>
					<input type="number" class="form-control" name="goalEntry" min="10" required>
				</div>
				<!-- 목표 마일리지 -->
				<div class="mb-3">
					<label for="goalMileage">목표 마일리지</label>
					<small class="text-muted">최소 100마일리지 이상 설정하세요</small>
					<input type="number" class="form-control" name="goalMileage" min="100" required>
				</div>
				<!-- 내용 -->
				<div class="mb-3">
					<label for="jpContents">재능기부 내용</label>
					<small class="text-muted">본 재능기부를 설명해주세요</small>
					<textarea class="form-control" name="jpContents" required></textarea>
				</div>
				
				<button type="submit" class="btn btn-block btn-point">신청</button>
				
			</form>
			
		</div>
	</div>
</div>