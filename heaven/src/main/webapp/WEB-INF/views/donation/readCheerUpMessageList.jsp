<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">
	<div class="row">
		<h3 class="mb-3">응원메시지</h3>
		<table class="table table-hover">
			<tbody>
				<c:forEach items="${activityList }" var="list">
					<tr>
						<td>${list.cheerUpMessage }</td>
						<td>${list.aMileage } 마일리지</td>
						<td>${list.userVO.name }</td>
						<td>${list.aRegdate }</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</div>