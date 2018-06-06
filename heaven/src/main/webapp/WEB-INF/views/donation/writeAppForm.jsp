<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/editor/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		// 전역변수
		var obj = [];
		// 스마트에디터 프레임생성
		nhn.husky.EZCreator
				.createInIFrame({
					oAppRef : obj,
					elPlaceHolder : "jpContents",
					sSkinURI : "${pageContext.request.contextPath}/resources/editor/SmartEditor2Skin.html",
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : false,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : false,
					}
				});
		// 전송버튼
		$("#appBtn").click(function() {
			// id가 smarteditor인 textarea에 에디터에서 대입
			obj.getById["jpContents"].exec("UPDATE_CONTENTS_FIELD", []);
			// 폼 submit
			$("#appForm").submit();
		})
	});

	function submitContents() {
		var elClickedObj = $("#jpContents");
		oEditors.getById["jpContents"].exec("UPDATE_CONTENTS_FIELD", []);
		var jpContents = $("#jpContents").val();

		if (jpContents == "" || jpContents == null || jpContents == '&nbsp;'
				|| jpContents == '<p>&nbsp;</p>') {
			alert("내용을 입력하세요.");
			oEditors.getById["jpContents"].exec("FOCUS"); // 포커싱
			return;
		}

		try {
			elClickedObj.submit();
		} catch (e) {
		}
	}
	$("#appBtn").submit(function(){
		if(!$('input:checkbox[id="appAgree"]').is(":checked")){
			alert("상기 내용에 동의하지 않으셨습니다. 동의해주세요.");
			return false;
		}
	});
</script>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">
		<c:choose>
			<c:when test="${uvo.userGroupVO.ugroupNo=='1' }">재능기부 신청서</c:when>
			<c:when test="${uvo.userGroupVO.ugroupNo=='2' }">taking 신청서</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</h4>
</div>
<!-- /.Page Heading -->
<div class="container my-4">
	<div class="row">
		<div class="col-md-8 offset-md-2 order-md-1">
			<form action="${pageContext.request.contextPath }/application.do"
				method="post" id="appForm" enctype="multipart/form-data">
				<input type="hidden" name="jpGroupNo" value="${uvo.userGroupVO.ugroupNo }">
				<!-- 이름 -->
				<div class="mb-3">
					<c:choose>
						<c:when test="${uvo.userGroupVO.ugroupNo=='1' }">
							<label for="jpTitle">재능기부명</label>
							<small class="text-muted">재능기부의 주제가 드러나는 제목을 적어주세요</small>
						</c:when>
						<c:when test="${uvo.userGroupVO.ugroupNo=='2' }">
							<label for="jpTitle">taking명</label>
							<small class="text-muted">taking 제목을 적어주세요</small>
						</c:when>
					</c:choose>
					<input type="text" class="form-control" name="jpTitle" required>
				</div>
				<!-- 요약 -->
				<div class="mb-3">
					<c:choose>
						<c:when test="${uvo.userGroupVO.ugroupNo=='1' }">
							<label for="jpSummary">재능기부 요약</label>
							<small class="text-muted">본 재능기부를 간략하게 소개해 주세요</small>
						</c:when>
						<c:when test="${uvo.userGroupVO.ugroupNo=='2' }">
							<label for="jpTitle">taking 요약</label>
							<small class="text-muted">taking을 간략하게 소개해 주세요</small>
						</c:when>
					</c:choose>
					<input type="text" class="form-control" name="jpSummary" required>
				</div>
				<!-- 재능기부 참여 신청(모집)기간 -->
				<div class="mb-3">
					<label for="">신청기간</label>
					<c:choose>
						<c:when test="${uvo.userGroupVO.ugroupNo=='1' }">
							<small class="text-muted">재능기부 참여를 신청 받을 기간을 선택하세요</small>
						</c:when>
						<c:when test="${uvo.userGroupVO.ugroupNo=='2' }">
							<small class="text-muted">taking을 신청 받을 기간을 선택하세요</small>
						</c:when>
					</c:choose>
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
				<c:if test="${uvo.userGroupVO.ugroupNo=='1' }">
					<div class="mb-3">
						<label for="">모임기간</label> <small class="text-muted">재능기부
							모임 기간을 선택하세요</small>
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
							<input type="text" class="form-control" name="jpPlace" aria-describedby="basic-addon2" />
							<div class="input-group-append">
								<button type="button" class="btn btn-sub-2" onclick="execPostCode()">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</div>
				</c:if>
				<!-- 대표이미지 -->
				<div class="mb-3">
					<label for="jpImgDirect">대표이미지</label>
					<small class="text-muted">재능기부 목록과 상세화면에서 보여지는 대표 이미지를 등록하세요</small>
					<input type="file" class="form-control" name="main_image" required>
				</div>
				<!-- 목표 참여자수 -->
				<c:if test="${uvo.userGroupVO.ugroupNo=='1' }">
					<div class="mb-3">
						<label for="goalEntry">목표 참여자 수</label>
						<small class="text-muted">최소 10명이상 선택하세요</small>
						<input type="number" class="form-control" name="goalEntry" min="10" required>
					</div>
				</c:if>
				<c:if test="${uvo.userGroupVO.ugroupNo=='2' }">
					<!-- 목표 마일리지 -->
					<div class="mb-3">
						<label for="goalMileage">목표 마일리지</label>
						<small class="text-muted">최소 100마일리지 이상 설정하세요</small>
						<input type="number" class="form-control" name="goalMileage" min="100" required>
					</div>
				</c:if>
				<!-- 내용 -->
				<div class="mb-3">
					<c:choose>
						<c:when test="${uvo.userGroupVO.ugroupNo=='1' }">
							<label for="jpContents">재능기부 내용</label>
							<small class="text-muted">본 재능기부를 설명해주세요</small>
						</c:when>
						<c:when test="${uvo.userGroupVO.ugroupNo=='2' }">
							<label for="jpContents">taking 내용</label>
							<small class="text-muted">taking을 설명해주세요</small>
						</c:when>
					</c:choose>
					<!-- <textarea name="jpContents" id="jpContents" rows="10" cols="100"
						style="width: 100%; height: 412px;"></textarea> -->
					<textarea class="form-control" name="jpContents" required></textarea>
				</div>

				<div class="jumbotron mt-5 mb-2 py-4">
					신청하신 내용에 대한 승인은 5일 이내로 처리됩니다.<br> 승인여부에 따른 문의는 '문의하기'로 문의하시기
					바랍니다.
				</div>

				<div class="custom-control custom-checkbox mb-5">
					<input type="checkbox" class="custom-control-input" id="appAgree">
					<label class="custom-control-label" for="appAgree">상기 내역에 동의합니다.</label>
				</div>
				<button type="submit" class="btn btn-block btn-point" id="appBtn">신청</button>

			</form>

		</div>
	</div>
</div>