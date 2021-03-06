<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>    
<script type="text/javascript">
	$(document).ready(function(){
		$('.btn-primary').click(function(){
			alert("회원정보가 수정되었습니다.");
		});
		$('.btn-cancel').click(function(){
			location.href="${pageContext.request.contextPath }/users/mypage.do";
		});
	});
</script>
<div class="container" id="updateForm">
      <form class="contact-us form-horizontal" method="post" action="updateUserInfoForm.do">
        <h3>회원정보 수정</h3>       
         <div class="control-group">
            <label class="control-label">ID</label>&nbsp;--------------&nbsp;${sessionScope.uvo.id}
            <input type="hidden" name="id" value="${sessionScope.uvo.id}">
        </div>
        <div class="control-group">
            <label class="control-label">Name</label>&nbsp;---------&nbsp;${sessionScope.uvo.name}
        </div>
        <div class="control-group">
            <label class="control-label">Address</label>
            <div class="controls">
                    <button type="button" class="btn btn-sub-2-gnt" onclick="execPostCode();">
					<i class="fa fa-search"></i> 주소 찾기
					</button>
                <div class="input-prepend">
                    <input type="text" class="input-xlarge" name="jpPlace" id="jpPlace" value="${sessionScope.uvo.address}">
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">Email</label>
            <div class="controls">
                <div class="input-prepend">
                    <input type="text" class="input-xlarge" name="email" value="${sessionScope.uvo.email}">
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