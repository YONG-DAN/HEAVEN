<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    //ajax 처리 : 댓글 쓰기
    $("#replySubmitBtn").click(function(){
        var irContents = $("#replyText").val();
        var iNo="${ivo.iNo}"
        var param="irContents="+irContents+"&iNo="+iNo;
        $.ajax({                
            type: "post",
            url: "${pageContext.request.contextPath}/community/createInterviewReply.do",
            data: param,
            success: function(data){
                alert("댓글이 등록이 완료되었습니다.");
                location.reload();
            }//success
        });//ajax
    });//click
   });//ready
</script>
        <!-- 좌우측의 공간 확보 -->
        <div class="container my-5">
            <div class="row">
                <div class="col-md-10 communityDetail">
                    <table class="table">
                        <thead>
                            <tr align="center">
                                <td colspan="2" width="60%" class="py-4"><h3>${ivo.iTitle}</h3></td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="text-right">작성일 ${ivo.iRegdate}</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                	<div class="py-3">                                		
                                		${ivo.iImgDirectory }
                                	</div>
                                	<div class="pt-2">
                                		 <c:forEach var="list" items="${requestScope.iqList }">
	                                   		<div class="border-left-2-sub-4 pl-2 font-weight-bold">${list.question }</div>
	                                    	<div class="jumbotron py-4 mt-2 mb-5">${list.answer }</div>	                                    
	                                    </c:forEach>
                                	</div>
                                   
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table id="commentTable" class="table table-condensed">
                    <tbody>
                    <c:forEach var="list" items="${requestScope.irVO}">
                    <tr>
                    <td>${list.userVO.name}</td>
                    <td>${list.irContents}</td>
                    <td>${list.irRegdate}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                    </table>
                    <table class="table table-condensed">
                        <tr>
                            <td>                            
                                <div class="form-inline" role="form">
                                    <div class="w-100 mb-1">
                                    	댓글 달기
                                    	<span class="float-right">
                                    		<a href="#" id="replySubmitBtn" class="btn btn-sub-2 btn-sm">확인</a>
                                    	</span>
                                    </div>
                                    <textarea id="replyText" class="form-control col-lg-12" style="width:100%" rows="4" required="required"></textarea>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td class="w-100">
                                    <span class="float-right">
                                    	<a href="${pageContext.request.contextPath}/community/communityList.do?nowPage=1" id="list" class="btn btn-sub-2 btn-sm">목록</a>
                                       <!--  <button type="button" id="list" class="btn btn-default">목록</button> -->
                                    </span>
                                </td>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>    