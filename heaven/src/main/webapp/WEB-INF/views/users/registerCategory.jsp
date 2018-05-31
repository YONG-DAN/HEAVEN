<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container mt-5 mb-5">
	<div class="row">
		<div
			class="offset-2 offset-xs-3 offset-sm-3 offset-md-3 col-md-6 p-5 border">
			<div class="login-panel panel panel-default">
				<div class="card-body">
					<div class="card text-center" onclick="location.href='${pageContext.request.contextPath }/users/registerNormalForm.do'">
						<div class="card-body">
						<i class="fas fa-user-alt fa-3x"></i>
						<br><br>
							<h5 class="card-title">일반회원</h5>
							<br>
							<p class="card-text">개인회원으로 기부앤테이크의 재능을 기부하거나<br>
												  재능 기부 프로그램에 직접 참여할 수 있어요.</p>
						</div>
					</div>
					<div class="card text-center" onclick="location.href='${pageContext.request.contextPath }/users/registerGroupForm.do'">
						<div class="card-body">
						<i class="fas fa-users fa-3x"></i>
						<br><br>
							<h5 class="card-title">단체회원</h5>
							<br>
							<p class="card-text">단체회원으로 기부앤테이크에서 <br>
												 후원을 신청할 수 있어요.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>