<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<div>
	
	<form method="post" action="login_processing"> <!-- action에 있는 링크는 securityconfig에 보면 있다  --> 
		<div class="form-group">
			<input type="text" name="loginId" placeholder="아이디" class="form-control w300" />
		</div>
		<div class="form-group">
			<input type="password" name="passwd" placeholder="비밀번호" class="form-control w300" />
		</div>
		<div>
			<input type="submit" class="btn" >로그인</button>
		</div>
	</form>
	<div>
		<a href="/guest/register" class="btn btn-dark">가입하기</a>
	</div>
	<c:if test="${ param.error != null }"> 
		<div class="mt5">로그인 실패</div>
	</c:if>

</div>
<div class="layer">
	<img src="/images/main_insta_login.JPG" class="login_img">
	
	
		<span>
			<a href="/" style="color: black; text-decoration: none;">Outstagram</a>
		</span>
	
</div>
		
		

</body>
</html>