<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href='<c:url value="/resource/bootstrap/css/bootstrap.min.css"></c:url>'>
<title>Welcome</title>
</head>

	<section>
		<div class="container">
			<p>${url}</p>
			<p>${exception}</p>
		</div>

		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span> products
				</a>
			</p>
		</div>
		
	</section>
</html>
