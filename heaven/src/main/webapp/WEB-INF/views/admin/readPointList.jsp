<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <script type="text/javascript">
	function givePoint(id,mileage,tdNo){
		var conResult = confirm(id+"님에게 "+mileage+"포인트를 지급하시겠습니까?");
		if(conResult){
			location.href="${pageContext.request.contextPath}/givePoint.do?id="+id+"&mileage="+mileage+"&tdNo="+tdNo;
		}else{
			return false;
		}
	}
</script> -->
<div class="page-heading">
	<h4 class="py-5 text-center sub2-txt">포인트 지급 관리</h4>
</div>
<div class="container">
	<div class="col-10 offset-lg-1">
	</div>
	<div class="row">
		<div class="col-10 offset-lg-1 my-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>종류</th>
						<th>프로그램</th>
						<th>아이디</th>
						<th>이름</th>
						<th>모금 마일리지</th>
						<th>지급</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${jpListVO.list}" var="jpVO">
							<tr>
								<td>${jpVO.joinPostGroupVO.jpGroupName}</td>
								<td>${jpVO.jpTitle}</td>
								<td>${jpVO.userVO.id}</td>
								<td>${jpVO.userVO.name}</td>
								<td>${jpVO.totalMileage} P</td>
								<td>
								<input type="button" value="지급" class="btn btn-block-point">
<%-- 								<input type="button" value="지급" 
									onclick="return givePoint('${tdpVO.donationPostVO.memberVO.id}','${tdpVO.tdMileage}',${tdpVO.tdNo})"
									class="btn btn-block tradePointBtn"> --%>
								</td> 
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<hr>
	
	<ul class="pagination justify-content-center mt-5">
		<c:if test="${jpListVO.pbf.previousPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/admin/readPointList.do?nowPage=${jpListVO.pbf.startPageOfPageGroup-1}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
					<span class="sr-only">
						Previous
					</span>
				</a>
			</li>
		</c:if>
		<c:forEach var="page" begin="${jpListVO.pbf.startPageOfPageGroup}" end="${jpListVO.pbf.endPageOfPageGroup}">
			<c:choose>
				<c:when test="${jpListVO.pbf.nowPage!=page}">
					<li class="page-item">
						<a class="page-link"  href="${pageContext.request.contextPath}/admin/readPointList.do?nowPage=${page}">${page}</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link"  href="#">${page}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${jpListVO.pbf.nextPageGroup }">
			<li class="page-item">
				<a class="page-link" href="${pageContext.request.contextPath}/readTradePoint.do?nowPage=${jpListVO.pbf.endPageOfPageGroup+1}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</li>
		</c:if>
	</ul>

</div>