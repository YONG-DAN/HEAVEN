<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<!-- 로그인 아이디 비밀번호 확인 : 아이디 중복체크, 아이디 길이확인, 비밀번호 일치여부 -->
	$(document).ready(function(){
		var checkResultId="";
			$("#id").keyup(function(){
				var id=$(this).val().trim();
				if(id.length<3 || id.length>10){
					$("#checkIdView").html("아이디는 3자이상 10자 이하여야 합니다.").css("color","#edbf71");
					checkResultId="";
					return;
				}
				else 
					$("#checkIdView").html("");
					$.ajax({
						type:"get",
						url:"checkId.do",				
						data:"id="+id,	
						success:function(data){	
							if(data=="fail"){
								$("#checkIdView").html(id+"은 이미 존재하는 아이디입니다.").css("color","#f35b56");
								checkResultId="";
							}else{					
								$("#checkIdView").html(id+"는 사용 가능한 아이디입니다.").css("color","#1e878d");		
								checkResultId=id;
							}					
						}//success		
					});//ajax
				});//keyup	
				$("#password").keyup(function(){
					var passwordCon = $("#passwordCon").val();
					var password = $("#password").val();
					var checkResultPassword="";
					if(passwordCon!="" && password != passwordCon) {//비밀번호와 비밀번호 확인이 일치하지 않는 경우
						$("#checkPasswordView").html("패스워드와 일치하지 않습니다").css("color","#f35b56");
						checkResultPassword="";
					}else if (passwordCon=="") {
						$("#checkPasswordView").html("");
						checkResultPassword="";
					}else {//비밀번호와 비밀번호 확인이 일치하여 진행 가능한 경우
						$("#checkPasswordView").html("패스워드와 일치합니다").css("color","#1e878d");
						checkResultPassword=password;
					}
				});//keyup
				$("#passwordCon").keyup(function(){
					var passwordCon = $("#passwordCon").val();
					var password = $("#password").val();
					if(passwordCon!="" && password != passwordCon) {//비밀번호와 비밀번호 확인이 일치하지 않는 경우
						$("#checkPasswordView").html("패스워드와 일치하지 않습니다").css("color","#f35b56");
						checkResultPassword="";
					}else if (passwordCon=="") {
						$("#checkPasswordView").html("");
						checkResultPassword="";
					}else {//비밀번호와 비밀번호 확인이 일치하여 진행 가능한 경우
						$("#checkPasswordView").html("패스워드와 일치합니다").css("color","#1e878d");
						checkResultPassword=password;
					}
				});//keyup
				$("#registerForm").submit(function(){
					if(checkResultId==""){
						alert("아이디를 확인하세요!");
						return false;
					}
					else if (checkResultPassword=="") {
						alert("비밀번호를 확인하세요!");
						return false;
					}
					else if ($("#gender option:selected").val()=="default") {
						alert("성별을 선택하세요!");
						return false;
					}
				});//submit
			});//ready
		</script>
		
<div class="container mt-5 mb-5">
	<div class="row">
		<div class="offset-2 offset-xs-3 offset-sm-3 offset-md-3 col-md-6 p-5 border">
			<div class="login-panel panel panel-default">
				<div class="card-body">
					<!-- 회원가입 폼 -->
					<form action="registerUser.do" method="post" id="registerForm">
					<input type="hidden" name="uGroupNo" value="1">
					<input type="hidden" name="uGradeNo" value="1">
						<div class="form-group">
							<input type="text" class="form-control" name="id" id="id"
								placeholder="ID" required="required"> <span
								id="checkIdView"></span>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="PASSWORD" required="required">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="passwordCon"
								id="passwordCon" placeholder="CONFIRM PASSWORD"
								required="required"> <span id="checkPasswordView"></span>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								placeholder="NAME" required="required">
						</div>
						<div class="form-group">
							<select class="custom-select" name="gender" id="gender">
								<option value="default" selected>--GENDER--</option>
								<option value="F">FEMALE</option>
								<option value="M">MALE</option>
							</select>
						</div>
						<div class="form-group">
							<input type="date" class="form-control" name="birthday" id="birthday" 
							min="1900-01-01" max="${today}" required="required">
						</div>
						<div class="form-group">
							<div class="input-group mb-3">
								<input type="text" class="form-control" name="jpPlace" id="jpPlace"
									placeholder="ADDRESS" required="required">
								<div class="input-group-append">
									<button type="button" class="btn btn-sub-2-gnt"
										onclick="execPostCode();">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" name="email"
								placeholder="E-MAIL" required="required">
						</div>
						<button type="submit" class="btn btn-point btn-block">회원가입</button>
					</form>
				</div>
				<div class="card-body text-center">
					<div class="divider"></div>
					<span class="small-txt desc-color mr-1">이미 기부앤테이크 계정이 있으신가요?</span><a
						class="small-txt point-txt-gnt"
						href="${pageContext.request.contextPath }/users/loginForm.do">로그인</a>
				</div>
			</div>
		</div>
	</div>
</div>