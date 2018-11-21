<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/ddmenu.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/ddmenu.js" />"></script>
</head>
<style>
img {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
</style>
<body>
	<a id="ddmenuLink" href="resources/ddmenu-source.html">Menu</a>
	<div class="container" style="margin-top: 20px;">
		<br /> <!-- <img src="resources/icons/apiarist.png" alt="pszczelarz"
			class="center">-->
		<iframe
			src="https://www.meteoblue.com/en/weather/widget/three?geoloc=detect&nocurrent=0&noforecast=0&days=4&tempunit=CELSIUS&windunit=KILOMETER_PER_HOUR&layout=bright"
			frameborder="0" scrolling="NO" allowtransparency="true"
			sandbox="allow-same-origin allow-scripts allow-popups allow-popups-to-escape-sandbox"
			style="width: 460px; height: 592px"></iframe>
		<div>
			<!-- DO NOT REMOVE THIS LINK -->
			<a
				href="https://www.meteoblue.com/en/weather/forecast/week?utm_source=weather_widget&utm_medium=linkus&utm_content=three&utm_campaign=Weather%2BWidget"
				target="_blank">meteoblue</a>
		</div>
	</div>
</body>
</html>