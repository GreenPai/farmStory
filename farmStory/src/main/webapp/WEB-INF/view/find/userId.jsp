<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="../css/find/userId.css"/>
</head>
<%@ include file="../layout/_header.jsp" %>
<script>
	
	document.addEventListener('DOMContentLoaded', function() {

		// 5. 이메일 유효성 검사 (중복/인증처리 포함)
		const btnSendEmail = document.getElementById('btnSendEmail');
		const emailResult = document.querySelector('.emailResult'); 
		const codeResult = document.querySelector('.codeResult'); 
		const btnAuthCode = document.getElementById('btnAuthCode');
		
		let preventDoubleClick = false;
		let nextBtnClick = false;
		let code = "";
		
		btnSendEmail.onclick = async function(event){
			const email = formRegister.email.value;
			const name = formRegister.name.value;
			
			if(preventDoubleClick){
				return;
			}
			
			preventDoubleClick = true;
			// fetch 요청
			// response 서버의 응답, 실제 데이터가 아니라 응답 객체
			const response = await fetch('/farmStory/find/check/userid.do?name='+name+'&email='+email);
			const data = await response.json();
			code = data.code;
			
			if(data.uid != "인증실패") {
		        emailResult.innerText = ' 이메일로 인증번호를 발송했습니다.';
		        emailResult.style.color = 'green';
		        auth.style.display = 'block'; // 인증번호 입력란 보이기
		        preventDoubleClick = false;
			} else {		        
		        emailResult.innerText = ' 이메일이 일치하지 않습니다.';
		        emailResult.style.color = 'red';
		    }
			
		}
		
		// 인증 성공 
		btnAuthCode.onclick = async function(){

			event.preventDefault();
			const authCode = formRegister.authCode.value;			
					
			
			if(code === authCode) {
				codeResult.innerText = ' 인증에 성공하셨습니다.';
				codeResult.style.color = 'green';
				nextBtnClick = true;
			}else{
				codeResult.innerText = ' 인증에 실패하셨습니다.';
				codeResult.style.color = 'red';
			} 			
		}
		
		next.onclick = function(event) {
			event.preventDefault();
			if(nextBtnClick == true) {
				location.href = "./resultUserId.do";	
			}else{
				alert("인증하세요");
				return;
			}
		}
		
		
	});
	
</script>
        <main>
            <section class="id_find">             
                <form action="#" name="formRegister" method="POST">
                    <h2>아이디 찾기</h2>
                    <table>
                        <tbody>
                            <tr>
                                <td>이름</td>
                                <td><input type="text" name="name" placeholder="이름 입력"></td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>
                                    <div>
                                        <input type="email" name="email" placeholder="이메일 입력" required/>
                                        <button id="btnSendEmail">인증번호 받기</button><span class="emailResult"></span>
                                    </div>
                                    <div>
                                        <input type="text" name="authCode" id="authCode" placeholder="인증번호 입력" required>
                                        <button id="btnAuthCode">확인</button><span class="codeResult"></span>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <p>회원가입시 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>
                    인증번호를 입력 후 확인 버튼을 누르세요.
                </p>
                <div>
                    <a href="/farmStory/user/login.do">취소</a>
                    <a href="/farmStory/find/resultUserId.do" id="next">다음</a>
                </div>
            </section>
        </main>
        
<%@ include file="../layout/_footer.jsp" %>    