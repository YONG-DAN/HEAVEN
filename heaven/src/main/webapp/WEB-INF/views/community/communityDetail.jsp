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
        <div class="container">
            <div class="row">
                <div class="col-md-10 communityDetail">
                    <table class="table table-condensed">
                        <thead>
                            <tr align="center">
                                <th colspan="2" width="60%">${ivo.iTitle}</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td style="float:right">작성일 ${ivo.iRegdate}</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <p>텍스트내용</p>
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
                            
                                <span class="form-inline" role="form">
                                        <div class="form-group">
                                        	댓글 달기
                                     			
                                        <!-- <button type="button" id="commentParentSubmit" name="commentParentSubmit" class="btn btn-default">확인</button> -->
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </div>
                                        <a id="replySubmitBtn" class="btn btn-sub-2 btn-sm"> 확인</a>
                                        <textarea id="replyText" class="form-control col-lg-12" style="width:100%" rows="4" required="required"></textarea>
                                </span>
                            </td>
                        </tr>
                    </table>
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <td>
                                    <span style='float:right'>
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