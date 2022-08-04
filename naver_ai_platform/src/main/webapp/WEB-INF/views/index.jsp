<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
	</head>
	<body>
		<h3>Naver AI Platform 사용</h3>
		
		<a href="<c:url value='/celFaceRecgForm'/>">유명인 언굴 인식</a><br><br>
		<a href="<c:url value='/faceRecogForm'/>">얼굴 감지</a><br><br>
		<a href="<c:url value='/poseEstimateForm'/>">포즈 인식</a><br><br>
		<a href="<c:url value='/objectDetectForm'/>">객체 탐지</a><br><br>
	</body>
</html>
