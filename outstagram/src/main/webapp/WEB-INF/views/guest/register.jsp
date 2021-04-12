<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

 <div class="layer">
	<img src="/images/insta_register.JPG">
</div> 

<div>
	<form method="post" modelAttribute="userRegistrationModel" autocomplete="off"> <!-- 자동으로 완성해주는 기능 없애기 off -->
		<div class="form-group">
			<input path="phone" name="phone" class="form-control w300" placeholder="휴대폰 번호" />
			<errors path="phone" class="error" />
		</div>
		<div class="form-group">
			<input path="name" name="name" class="form-control w300" placeholder="성명" />
			<errors path="name" class="error" />
		</div>
		<div class="form-group"> 
			<input path="userid" name="userid" class="form-control w300" placeholder="사용자 이름" />
			<errors path="userid" class="error" />
		</div>
		<div class="form-group">
			<input path="passwd1" name=""passwd1""  class="form-control w300" placeholder="비밀번호" />
			<errors path="passwd1" class="error" />
		</div>
		<button type="submit" onclick="return confirm('회원가입 하시겠습니까?')" class="btn">가입</button>
	</form>
	<div>
		<a href="../login">로그인</a> <!-- 이미 계정이 있는데 가입하기를 잘못 누른경우 로그인 url로 이동가능 --> 
	</div>
</div>

</body>
</html>