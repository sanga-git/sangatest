<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="contents">
		<div class="nav">
			<span class="title"> 
				<a href="/main/user/${user.id}" class="title_ft">${user.userId}</a>
			</span>
		</div>

		<div class="profile">
			<div class="title_image">
				<c:choose>
					<c:when test="${user.profile_photo == null}">
						<img src="/images/noimage.png" class="profile_image">
					</c:when>
					<c:otherwise>
						<img src="/images/profile/${user.profile_photo}" class="profile_image">
					</c:otherwise>
				</c:choose>
			</div>

			<div class="txt">
				<span>0</span><br> <!-- 아직 만들지 않아서 0으로 셋팅 -->
				<span>게시물</span>
			</div>

			<div class="txt">
				<span>0</span><br> <!-- 아직 만들지 않아서 0으로 셋팅 -->
				<span>팔로워</span>
			</div>

			<div class="txt">
				<span>0</span><br> <!-- 아직 만들지 않아서 0으로 셋팅 -->
				<span>팔로잉</span>
			</div>
		</div>

		<div class="_info">
			<span>${user.introduce}</span><br /> 
			<span>${user.website}</span>
		</div>

		<div class="fix">
			<a href="update/${user.id}" class="btn btn-default">프로필 수정</a>
		</div>
	</div>
	<div id="footer">
		<%@ include file="../include/bottom.jsp"%>
	</div>
</body>
</html>