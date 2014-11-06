<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home de la aplicacion</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" href='<c:url value="/resources/css/images/favicon.ico" />' />
		<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />' type="text/css" media="all" />
		<script type="text/javascript" src='<c:url value="/resources/js/lib/jquery-1.8.2.js" />'></script>
		<script type="text/javascript" src='<c:url value="/resources/js/lib/jquery.jcarousel.min.js" />'></script>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
		
		<c:choose>
			<c:when test="${empty sessionScope.user}">
				<a href="<c:url value="/login" />">Logueate</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/app/search" />">Ingresar</a>
			</c:otherwise>
		</c:choose>
		
		
			<div class="shell">
				
				<div class="image">
					<img src="<c:url value="/resources/css/images/books.png" />" alt="" />
				</div>
				<div class="details">
					<h3>Special Offers</h3>
					<p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
					<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
					<a href="#" class="read-more-btn">Read More</a>
				</div>
			</div>
		
	<!-- End Slider -->
	<!-- Main -->
	<div id="main" class="shell">
	
		<!-- Content -->
		<div id="content">
			<!-- Products -->
			<div class="products">
				<h3>Featured Products</h3>
				<ul>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image01.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image02.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image03.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image03.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image04.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image06.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image07.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
					<li>
						<div class="product">
							<a href="#" class="info">
								<span class="holder">
									<img src='<c:url value="/resources/css/images/image08.jpg" />' alt="" />
									<span class="book-name">Book Name</span>
									<span class="author">by John Smith</span>
									<span class="description">Maecenas vehicula ante eu enim pharetra<br />scelerisque dignissim <br />sollicitudin nisi</span>
								</span>
							</a>
						</div>
					</li>
				</ul>
			<!-- End Products -->
			</div>
			<div class="cl">&nbsp;</div>
			<!-- Best-sellers -->
<!-- 			<div id="best-sellers"> -->
<!-- 				<h3>Best Sellers</h3> -->
<!-- 				<ul> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best01.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>35<span class="high">00</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best02.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>45<span class="high">00</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best03.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>15<span class="high">00</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best04.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>27<span class="high">99</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best01.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>35<span class="high">00</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best02.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>45<span class="high">00</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best03.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>15<span class="high">00</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 					<li> -->
<!-- 						<div class="product"> -->
<!-- 							<a href="#"> -->
<!-- 								<img src="css/images/image-best04.jpg" alt="" /> -->
<!-- 								<span class="book-name">Book Name </span> -->
<!-- 								<span class="author">by John Smith</span> -->
<!-- 								<span class="price"><span class="low">$</span>27<span class="high">99</span></span> -->
<!-- 							</a> -->
<!-- 						</div> -->
<!-- 					</li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
			<!-- End Best-sellers -->
		</div>
		<!-- End Content -->
		<div class="cl">&nbsp;</div>
	</div>
	<!-- End Main -->
	<!-- Footer -->
	<div id="footer" class="shell">
		<div class="top">
			<div class="cnt">
				<div class="col about">
					<h4>About BestSellers</h4>
					<p>Nulla porttitor pretium mattis. Mauris lorem massa, ultricies non mattis bibendum, semper ut erat. Morbi vulputate placerat ligula. Fusce <br />convallis, nisl a pellentesque viverra, ipsum leo sodales sapien, vitae egestas dolor nisl eu tortor. Etiam ut elit vitae nisl tempor tincidunt. Nunc sed elementum est. Phasellus sodales viverra mauris nec dictum. Fusce a leo libero. Cras accumsan enim nec massa semper eu hendrerit nisl faucibus. Sed lectus ligula, consequat eget bibendum eu, consequat nec nisl. In sed consequat elit. Praesent nec iaculis sapien. <br />Curabitur gravida pretium tincidunt.  </p>
				</div>
				<div class="col store">
					<h4>Store</h4>
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">Special Offers</a></li>
						<li><a href="#">Log In</a></li>
						<li><a href="#">Account</a></li>
						<li><a href="#">Basket</a></li>
						<li><a href="#">Checkout</a></li>
					</ul>
				</div>
				<div class="col" id="newsletter">
					<h4>Newsletter</h4>
					<p>Lorem ipsum dolor sit amet  consectetur. </p>
					<form action="" method="post">
						<input type="text" class="field" value="Your Name" title="Your Name" />
						<input type="text" class="field" value="Email" title="Email" />
						<div class="form-buttons"><input type="submit" value="Submit" class="submit-btn" /></div>
					</form>
				</div>
				<div class="cl">&nbsp;</div>
				<div class="copy">
					<p>&copy; <a href="#">BestSeller.com</a>. Design by <a href="http://css-free-templates.com/">CSS-FREE-TEMPLATES.COM</a></p>
				</div>
			</div>
		</div>
	</div>
	<!-- End Footer -->
		
	</body>
</html>