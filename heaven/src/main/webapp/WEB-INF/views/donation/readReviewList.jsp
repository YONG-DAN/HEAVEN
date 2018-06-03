<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
		<h3 class="mb-3">후기</h3>
		<small class="text-muted">참여하신 재능기부에 대한 후기를 남겨주세요 <a href="#" class="border-left ml-1 pl-1" data-toggle="modal" data-target="#entryReviewModal">후기 작성하기</a></small>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reviewList }" var="list" varStatus="i">
					<tr>
						<td><a href="#" data-toggle="modal" data-target="#entryReviewDetail${i.index}">${list.rTitle }</a></td>
						<td>${list.activityVO.userVO.name }</td>
						<td>${list.rRegdate }</td>
					</tr>
					<!-- 후기 상세 Modal -->
					<div class="modal fade" id="entryReviewDetail${i.index }" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header bg-point white-txt">
									<h5 class="modal-title" id="exampleModalLabel">후기</h5>
									<button type="button" class="close white-txt" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<div class="mb-3">
										<h4>${list.rTitle }</h4>
									</div>
									<div class="mb-3 row">
										<label for="rTitle" class="col-sm-2 col-form-label">작성자</label>
										<div class="col-sm-10">
											<input type="text" class="form-control-plaintext" name="name" id="name" value="${list.activityVO.userVO.name }" readonly="readonly">
										</div>
									</div>
									<div class="mb-3">
										<label for="rContents">내용</label>
										<div class="jumbotron">
											<pre>${list.rContents }</pre>
										</div>
									</div>
								</div>								
								<div class="modal-footer">
									<button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>	
				<!-- /.후기 상세 modal -->				
			</tbody>
		</table>
	</div>
</div>
<!-- /.container -->

<!-- 후기작성 modal -->
<!-- Modal -->
<div class="modal fade" id="entryReviewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header bg-point white-txt">
				<h5 class="modal-title" id="exampleModalLabel">후기 작성</h5>
				<button type="button" class="close white-txt" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="${pageContext.request.contextPath }/addReview.do" method="post">
			<div class="modal-body">
				<input type="hidden" name="id" value="${sessionScope.uvo.id }">
				<ul class="jumbotron list-unstyled py-4">
					<li class="mb-2">${donationVO.jpTitle }</li>
					<li class="mb-2"><i class="far fa-calendar-alt"></i>모임기간 ${donationVO.jpEventStartDate } - ${donationVO.jpEventEndDate }</li>
					<li class="mb-2"><i class="fas fa-map-marker-alt"></i>모임 장소 ${donationVO.jpPlace }</li>
				</ul>
				<div class="mb-3">
					<label for="rTitle">작성자</label>
					<input type="text" class="form-control" name="name" id="name" value="${sessionScope.uvo.name }" readonly="readonly">
				</div>
				
				<div class="mb-3">
					<label for="rTitle">제목</label>
					<small class="text-muted">재능기부자에게 따뜻한 응원메시지를 남겨보세요</small>
					<input type="text" class="form-control" name="rTitle" id="rTitle">
				</div>
				<div class="mb-3">
					<label for="rRate">평점</label>
					<input type="number" class="form-control" name="rRate" id="rRate" min="0" max="5"/>
				</div>
				<div class="mb-3">
					<label for="rContents">내용</label>
					<textarea class="form-control" name="rContents" id="rContents"></textarea>
				</div>
				
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-point">작성하기</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
			</form>
		</div>
	</div>
</div>