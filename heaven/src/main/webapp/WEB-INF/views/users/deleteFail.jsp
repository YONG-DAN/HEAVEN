<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	alert("취소가능날짜가 지났습니다.");
	location.href="${pageContext.request.contextPath}/users/readMyActivityList.do?nowPage=1"; 
</script>