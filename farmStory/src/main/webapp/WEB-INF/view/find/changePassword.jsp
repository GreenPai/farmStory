<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="/farmStory/css/find/changePassword.css" />
</head>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		
	let pass1 = document.getElementsByName("pass1")[0];
	let pass2 = document.getElementsByName("pass2")[0];
	let next = document.getElementById("next");
	let formRegister = document.getElementsByName("formRegister")[0];
	
	next.onclick = function() {
		if (pass1.value !== pass2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}else if (pass1.value === "" || pass2.value === "") {
			alert("비밀번호를 입력해 주세요.");
			return false;
		}
		
		formRegister.submit();
		//alert("비밀번호가 변경되었습니다.");
		//location.href = "/farmStory/user/login.do";
	}
	
	/*
	const passResult = document.getElementsByClassName('passResult')[0];
	
	let nextBtnClick = false;
	
	next.onclick = function(event) {
		event.preventDefault();
		if(nextBtnClick == true) {
			location.href = "./resultUserId.do";	
		}else{
			alert("변경할 비밀번호를 입력하세요.");
			return;
		}
		
		if(result > 0) {
			System.out.println("<script>alert('비밀번호가 성공적으로 변경되었습니다!');"
					+ "location.href='./login.do'");
		}else {
			System.out.println("<script>alert('비밀번호 변경 실패. 다시 시도해주세요.');"
					+ "location.href='./password.do'");
		}

	}
	formRegister.pass2.addEventListener('focusout', function(){
		
		const value1 = formRegister.pass1.value;
		const value2 = formRegister.pass2.value;
		
		if(!value1.match(rePass)){
			passResult.innerText = '비밀번호는 숫자, 소문자, 대문자, 특수문자 조합 8자리';
			passResult.style.color = 'red';
			isPassOk = false;
			return;
		}
		
		if(value1 === value2){
			passResult.innerText = '사용 가능한 비밀번호 입니다.';
			passResult.style.color = 'green';
			isPassOk = true;
		}else{
			passResult.innerText = '비밀번호가 일치하지 않습니다.';
			passResult.style.color = 'red';
			isPassOk = false;
		}
	});
	// 최종 폼 전송 이벤트
	formRegister.onsubmit = function(e){
		
		// 2) 비밀번호 유효성 검사 결과
		if(!isPassOk){
			return false;
		}
	};
	
	*/
	});
</script>

<body>
	<div id="wrapper">
		<header>
			<div>
				<div class="top">
					<p>
						<a href="#">HOME |</a> <a href="#">로그인 |</a> <a href="#">회원가입
							|</a> <a href="#">나의정보 |</a> <a href="#">로그아웃 |</a> <a href="#">관리자
							|</a> <a href="#">고객센터</a>
					</p>
				</div>
			</div>

			<div>
				<article>
					<a href="#" class="logo"> <img src="/farmStory/images/logo.png"
						alt="팜스토리 로고">
					</a> <a href="#" class="freeShipping"> <img
						src="/farmStory/images/head_txt_img.png" alt="팜스토리 로고">
					</a>
				</article>
			</div>

			<div>
				<ul>
					<li><a href="#"> <img
							src="/farmStory/images/head_menu_line.png" alt="라인"> <img
							src="/farmStory/images/head_menu1.png" alt="팜스토리소개">
					</a></li>
					<li><a href="#"> <img
							src="/farmStory/images/head_menu_badge.png" alt="30%"
							class="head_badge"> <img
							src="/farmStory/images/head_menu_line.png" alt="라인"> <img
							src="/farmStory/images/head_menu2.png" alt="장보기">
					</a></li>
					<li><a href="#"> <img
							src="/farmStory/images/head_menu_line.png" alt="라인"> <img
							src="/farmStory/images/head_menu3.png" alt="농작물이야기">
					</a></li>
					<li><a href="#"> <img
							src="/farmStory/images/head_menu_line.png" alt="라인"> <img
							src="/farmStory/images/head_menu4.png" alt="이벤트">
					</a></li>
					<li><a href="#"> <img
							src="/farmStory/images/head_menu_line.png" alt="라인"> <img
							src="/farmStory/images/head_menu5.png" alt="커뮤니티">
					</a></li>
				</ul>
			</div>
		</header>
		<main>
			<section>
				<form action="/farmStory/find/changePassword.do" method="post" name="formRegister">
					<h2>비밀번호 변경</h2>
					<table>
						<tbody>
							<tr>
								<td>아이디</td>
								<td>${dto.uid}</td>
							</tr>
							<!-- uid를 서버로 전송하기 위한 hidden 필드 추가 -->
							<input type="hidden" name="uid" value="${dto.uid}" />
							<tr>
								<td>새 비밀번호</td>
								<td><input type="pass" name="pass1" placeholder="새 비밀번호 입력">
								<span class="passResult"></span>
								</td>
							</tr>
							<tr>
								<td>새 비밀번호 확인</td>
								<td><input type="pass" name="pass2" placeholder="새 비밀번호 입력">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<p>
					비밀번호를 변경해 주세요. <br> 영문, 숫자, 특수문자를 사용하여 8자 이상 입력해 주세요.
				</p>
				<div>
					<a href="#">취소</a>
					<a href="javascript:void(0);" onclick="submitForm()" id="next">다음</a>
				</div>
			</section>
		</main>
		<footer>
			<div>
				<div>
					<img src="/farmStory/images/footer_logo.png" alt="팜스토리 로고">
					<div>
						<p>
							(주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-부산진구-123호 /
							벤처기업확인 서울지방중소기업청 제 012345678-9-01234호<br> 등록번호 팜스토리01234
							(2013.04.01) / 발행인 : 홍길동<br> 대표 : 홍길동 / 이메일 :
							honggildong@gmail.com / 전화 : 01) 234-5678 / 부산광역시 부산진구 부전동 123
						</p>
						<p>copyrightⓒ 홍길동 All rights reserved.</p>
						<p>farmstory ver1.0.1</p>
					</div>
				</div>
			</div>
		</footer>
</body>
</html>