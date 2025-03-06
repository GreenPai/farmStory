<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
<link rel="stylesheet" href="/farmStory/css/find/changePassword.css" />
</head>
<%@ include file="../layout/_header.jsp" %>
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
					<a href="/farmStory/find/password.do">취소</a>
					<a href="javascript:void(0);" onclick="submitForm()" id="next">다음</a>
				</div>
			</section>
		</main>
<%@ include file="../layout/_footer.jsp" %>    