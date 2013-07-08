<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="<c:url value="/styles/main.css" />" type="text/css">
		<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.js"></script>
	</head>
<body>
	<div id="body">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="content">
			<div id="menu">
				<tiles:insertAttribute name="menu" />
			</div>
			<div id="main">
				<tiles:insertAttribute name="body" />
			</div>
			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</div>
</body>
</html>
