<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<!-- 로그인 아이디 비밀번호 확인 : 아이디 중복체크, 아이디 길이확인, 비밀번호 일치여부 -->
	$(document).ready(function(){
		var checkResultId="";
			
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
				$("#updateForm").submit(function(){
					if (checkResultPassword=="") {
						alert("비밀번호를 확인하세요!");
						return false;
					}
				});//submit
			});//ready
		</script>
<div class="container" id="updateForm">
      <form class="contact-us form-horizontal" method="post" action="${pageContext.request.contextPath}/users/updatePassword.do">
        <h3>비밀번호 변경</h3>       
        <div class="control-group">
            <label class="control-label">현재 비밀번호</label>
            <div class="controls">
                <div class="input-prepend">
                    <input type="password" id="insertPassword" class="input-xlarge" name="nowPassword" required placeholder="현재 비밀번호" >
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">새 비밀번호</label>
            <div class="controls">
                <div class="input-prepend">
                    <input type="password" class="input-xlarge" id="password" name="newPassword" placeholder="새 비밀번호" required="required">
                </div>
            </div>    
        </div>
        <div class="control-group">
            <label class="control-label">새 비밀번호 확인</label>
            <div class="controls">
                <div class="input-prepend">
                    <input type="password" class="input-xlarge" id="passwordCon" name="newPasswordCon" placeholder="새 비밀번호 확인" required="required">
                	<span id="checkPasswordView"></span>
                </div>
            </div>    
        </div>
        <div class="control-group">
          <div class="controls">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn btn-cancel">Cancel</button>
          </div>    
        </div>
      </form>
</div>