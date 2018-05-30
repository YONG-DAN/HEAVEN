<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container mt-5 mb-5">
	<div class="row">
		<div class="offset-2 offset-xs-3 offset-sm-3 offset-md-3 col-md-6 p-5 border">				
			<div class="login-panel panel panel-default">
				<div class="card-body">
					<!-- 일반 로그인 -->
					<form action="" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="id" placeholder="아이디">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="password" placeholder="비밀번호">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="password" placeholder="비밀번호 재확인">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="name" placeholder="이름">
						</div>
						<div class="form-group">
							<label>생년월일</label>
							<input type="date" class="form-control" name="birthday">
						</div>
						<div class="form-group">
							<label>주소</label>
							<button type="" class="btn btn-sm">검색</button>
							<input type="text" class="form-control" name="address">
						</div>
						<button type="submit" class="btn btn-point btn-block">회원가입</button>
					</form>
				</div>
				<div class="card-body text-center">
					<div class="divider"></div>
					<span class="small-txt desc-color mr-1">이미 기부앤테이크 계정이 있으신가요?</span>
					<a class="small-txt point-txt" href="${pageContext.request.contextPath }/users/login.do">로그인</a>
				</div>
			</div>
		</div>
	</div>
</div>