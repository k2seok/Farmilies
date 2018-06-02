<%@ page session="true"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=UTF-8 pageEncoding="UTF-8"">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>my page</title>
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport">
<meta name="viewport" content="width=device-width">
<link href="bootstrap3/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/gsdk.css" rel="stylesheet">
<link href="assets/css/demo.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="bootstrap3/css/font-awesome.css" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Grand+Hotel"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main">
		<div class="blurred-container">
			<div class="img-src"
				style="background-image: url('assets/img/cover_4.jpg')"></div>
			<div class="img-src blur"
				style="background-image: url('assets/img/cover_4_blur.jpg')"></div>
			<div class="row">
				<div class="col-lg-7 align-self-center text-lg-left text-center">
					<h1 class="mb-0 mt-4 display-4">
						<mark class="title">Farmilies</mark>
					</h1>
					<h2>
						공지사항 table <label></label>
					</h2>
				</div>
				<div class="col-lg-5 p-3">
					<form class="p-4" method="post" action="">
						<h4 class="mb-4 text-center text-primary">
							<label for="create">지금 시작하세요</label> <a class="btn btn-primary"
								id="create" href="signup"> 회원가입 </a>
						</h4>
						<div class="form-group">
							<label>이름</label> <input class="form-control" placeholder="ID"
								type="text">
						</div>
						<div class="form-group">
							<label>비밀번호</label> <input class="form-control" type="text">
						</div>
						<button type="submit"
							class="btn btn-block btn-success mt-4 p-2 shadowed">Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row p-4 bg-info animate-in-down animate-in-done">
			<div class="col-12 center">
				<h2>지금 할 수 있는 일</h2>
				<p class="mb-5">Week #26</p>
				<div class="row">
					<div class="col-md-4">
						<h5>From our lands</h5>
						<ul class="list-unstyled">
							<li class="my-4">Fillet of beef carpaccio, <br>raspberries
								and shaved parmesan <br>[ $12 ]
							</li>
							<li class="my-4">Rabbit stewed with prune, <br>artichokes
								and tomato focaccia <br>[ $24 ]
							</li>
							<li class="my-4">Season vegetables, <br>daily picked
								from our gardens <br>[ $8 ]
							</li>
							<li class="my-4">Rhubarb and blood orange crumble <br>served
								with clotted cream <br>[ $10 ]
							</li>
						</ul>
					</div>
					<div class="col-md-4">
						<h5>From the sea</h5>
						<ul class="list-unstyled">
							<li class="my-4">Fresh rock oyster &nbsp; <br>with
								homemade tartare sauce <br>[ $12 ]
							</li>
							<li class="my-4">Salt and chilli squid&nbsp; <br>with
								lime mayonnaise <br>[ $15 ]
							</li>
							<li class="my-4">Beetroot salmon gravadlax&nbsp; <br>with
								blinis and chive cream <br>[ $30 ]
							</li>
							<li class="my-4">Claret jelly with Chantilly cream <br>&nbsp;and
								a shortbread petticoat tail <br>[ $12 ]
							</li>
						</ul>
					</div>
					<div class="col-md-4">
						<h5>For the youngest</h5>
						<ul class="list-unstyled">
							<li class="my-4">Milan saffron risotto <br>with mint
								leaves and cherry tomato <br>[ $6 ]
							</li>
							<li class="my-4">Angus hamburger <br>ketchup and
								grilled vegetables <br>[ $12 ]
							</li>
							<li class="my-4">Potato chips <br>proudly grown in our
								fields <br>[ $7 ]
							</li>
							<li class="my-4">Ice cream with orange peel, <br>wild
								berries and daily cream <br>[ $4 ]
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>