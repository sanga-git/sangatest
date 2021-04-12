<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<title>Insert title here</title>
</head>
<body>

<%-- <sec:authentication property=" " var="currentid" />
 --%>

<c:forEach items="${user}" var="userList"> 
	
 </c:forEach>
<a href="/main">
	<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
</a>
<a href=""> <!-- 아직 링크부분을 정하지 않아서 비워두었다 -->
	<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
</a>
<a href=""> <!-- 아직 링크부분을 정하지 않아서 비워두었다 -->
	<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
</a>
<a href=""> <!-- 아직 링크부분을 정하지 않아서 비워두었다 -->
	<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
</a>
<a href="/main/user/${userList.userId}"> <!-- 현재 로그인된 유저의 page로 갈 링크 -->
	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
</a>
여기는 푸터입니다
	<h2>유저 아이디:"${userList.userId}"</h2>
 	
 		<h2>유저 아이디:"${name}"</h2>
        <input type="text" name="${userList.userId}">


</body>
</html>