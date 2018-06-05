<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- main slide img -->
<header>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<!-- Slide One - Set the background image for this slide in the line below -->
			<div class="carousel-item active"
				style="background-image:url('${pageContext.request.contextPath}/resources/img/main_img01.jpg')">
				<div class="carousel-caption d-none d-md-block">
					<h3>GIBU AND TAKE</h3>
					<p>봉사활동을 더 가치있게 만드는 새로운 사회공헌 플랫폼입니다</p>
				</div>
			</div>
			<!-- Slide Two - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background-image: url(${pageContext.request.contextPath}/resources/img/main_img02.jpg)">
				<div class="carousel-caption d-none d-md-block">
					<h3>A gift in season is a double favor to the needy.</h3>
					<p>- Good fences makes good neighbors -</p>
				</div>
			</div>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item"
				style="background: url(${pageContext.request.contextPath}/resources/img/main_img03.png) center top">
				<div class="carousel-caption d-none d-md-block">
					<h3>GIBU AND TAKE</h3>
					<p>The die is cast.</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</header>

<div class="container mt-5">
	<!-- main 재능기부 list -->
	<div class="row">
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project One</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Amet numquam aspernatur eum quasi sapiente
						nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores
						in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Two</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Three</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Quos quisquam, error quod sed cumque, odio
						distinctio velit nostrum temporibus necessitatibus et facere atque
						iure perspiciatis mollitia recusandae vero vel quam!</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Four</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
	</div>
	
	<!-- main 테이킹 list -->
	<div class="row">
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Five</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Six</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Itaque earum nostrum suscipit ducimus nihil
						provident, perferendis rem illo, voluptate atque, sit eius in
						voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Seven</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Eight</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Eius adipisci dicta dignissimos neque animi ea,
						veritatis, provident hic consequatur ut esse! Commodi ea
						consequatur accusantium, beatae qui deserunt tenetur ipsa.</p>
				</div>
			</div>
		</div>
	</div>
	
	<!-- main 이달의 기부자 list -->
	<div class="row">
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Five</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Six</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Itaque earum nostrum suscipit ducimus nihil
						provident, perferendis rem illo, voluptate atque, sit eius in
						voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Seven</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top"
					src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Eight</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Eius adipisci dicta dignissimos neque animi ea,
						veritatis, provident hic consequatur ut esse! Commodi ea
						consequatur accusantium, beatae qui deserunt tenetur ipsa....</p>
				</div>
			</div>
		</div>
	</div>
</div>
