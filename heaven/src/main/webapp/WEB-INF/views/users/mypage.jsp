<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Page Heading -->
<div class="page-heading bg-sub-3-gnt">
	<h4 class="py-5 text-center">마이페이지</h4>
</div>
<!-- /.Page Heading -->

<!-- Page Content -->
<div class="container my-5">
	<!-- row -->
	<div class="row">
		<div class="col-lg-6 offset-lg-3 mb-1">
			<div class="card-group">
				<div class="card">
					<div class="card-header">
						나의 정보
					</div>
					<div class="card-body">
						<div class="card-text">
							<div class="col-6"></div>
							<p class="small-txt">회원이름 : ${sessionScope.uvo.name}</p>
							<p class="small-txt">생년월일 : ${sessionScope.uvo.birthday}</p>
							<p class="small-txt">이메일 : ${sessionScope.uvo.email}</p>
							<p class="small-txt">주소 : ${sessionScope.uvo.address}</p>
							<p class="small-txt">회원 등급 : ${sessionScope.uvo.userGradeVO.ugradeName}</p>
							
						</div>
						<a href="#" class="btn btn-sub-2 btn-sm">수정</a>
					</div>
				</div>
				<div class="card">
                  <div class="card-header">
                     	비밀번호 변경
                  </div>
                  <div class="card-body">
                     <div class="card-text"></div>
                     <a href="${pageContext.request.contextPath }/users/updateMyPassword.do" class="btn btn-sub-2 btn-sm">변경</a>
                  </div>
                   <div class="card-header" id="memberDelet">
                     	회원 탈퇴
                  </div>
                  <div class="card-body">
                     <div class="card-text"></div>
                     <!-- <a href="#" class="btn btn-sub-2-gnt btn-sm memberDelet">탈퇴</a> -->
                      <div class="card-body">
                     <div class="card-text"></div>
                     <a href="${pageContext.request.contextPath}/users/deleteUser.do" class="btn btn-sub-2 btn-sm">회원탈퇴</a>
                  	</div>
                  </div>
               </div>
			</div>
		</div>

	</div>
	<!-- /.row -->
	<!-- row -->
	<div class="row">
		<div class="col-lg-6 offset-lg-3">
			<div class="card-group">
				<div class="card">
					<div class="card-header">마일리지</div>
					<div class="card-body">
						<div class="card-title">마일리지</div>
						<div class="card-text">
							<p>보유 마일리지</p>
						</div>
						<a href="#" class="btn btn-sub-2 btn-sm">충전/환전/내역</a>
					</div>
				</div>
				<div class="card">
					<div class="card-header">기부 참여내역</div>
					<div class="card-body">
						<div class="card-text">
							<p>참여한 기부 10건</p>
						</div>
						<a href="#" class="btn btn-sub-2 btn-sm">조회하기</a>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->