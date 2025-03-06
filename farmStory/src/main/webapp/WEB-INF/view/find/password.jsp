<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" href="/farmStory/css/find/password.css"/>
</head>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		// 5. 이메일 유효성 검사 (중복/인증처리 포함)
		const btnSendEmail = document.getElementById('btnSendEmail');
		const emailResult = document.querySelector('.emailResult'); 
		const codeResult = document.querySelector('.codeResult'); 
		// const emailResult = document.querySelector('.emailResult');
		// const auth = document.querySelector('.auth');
		// let preventDoubleClick = false;
		const btnAuthCode = document.getElementById('btnAuthCode');
		
		let preventDoubleClick = false;
		let nextBtnClick = false;
		let code = "";
		
		btnSendEmail.onclick = async function(event){
			event.preventDefault();
			const uid = formRegister.uid.value;
			const email = formRegister.email.value;
			
			if(preventDoubleClick){
				return;
			}
			
			preventDoubleClick = true;
			// fetch 요청
			// response 서버의 응답, 실제 데이터가 아니라 응답 객체
			const response = await fetch('/farmStory/find/check/password.do?uid='+uid+'&email='+email);
			const data = await response.json();
			code = data.code;
			
			if(data.uid != "인증실패") {
		        emailResult.innerText = ' 이메일로 인증번호를 발송했습니다.';
		        emailResult.style.color = 'green';
		        //auth.style.display = 'block'; // 인증번호 입력란 보이기
		        preventDoubleClick = false;
			} else {		        
		        emailResult.innerText = ' 이메일이 일치하지 않습니다.';
		        emailResult.style.color = 'red';
		    }
			
		}
		
		// 인증 성공 
		btnAuthCode.onclick = async function(event){

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
				location.href = "./changePassword.do";	
			}else{
				alert("인증하세요");
				return;
			}
		}
	});
</script>
<body>
    <div id="wrapper">
        <header>
            <div>
                <div class="top">
                    <p>
                        <a href="#">HOME |</a>
                        <a href="#">로그인 |</a>
                        <a href="#">회원가입 |</a>
                        <a href="#">나의정보 |</a>
                        <a href="#">로그아웃 |</a>
                        <a href="#">관리자 |</a>
                        <a href="#">고객센터</a>
                    </p>
                </div>
            </div>
            
            <div>
                <article>
                    <a href="#" class="logo">
                        <img src="/farmStory/images/logo.png" alt="팜스토리 로고">
                    </a>
                    <a href="#" class="freeShipping">
                        <img src="/farmStory/images/head_txt_img.png" alt="팜스토리 로고">
                    </a>
                </article>
            </div>

            <div>
                <ul>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu1.png" alt="팜스토리소개">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_badge.png" alt="30%" class="head_badge">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu2.png" alt="장보기">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu3.png" alt="농작물이야기">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu4.png" alt="이벤트">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu5.png" alt="커뮤니티">
                        </a>
                    </li>
                </ul>
            </div>
        </header>
        <main>
            <section class="id_find">             
                <form action="#" name="formRegister">
                    <h2>비밀번호 찾기</h2>
                    <table>
                        <tbody>
                            <tr>
                                <td>아이디</td>
                                <td><input type="text" name="uid" placeholder="아이디 입력"></td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>
                                    <div>
                                        <input type="email" name="email" placeholder="이메일 입력"/>
                                        <button id="btnSendEmail">인증번호 받기</button><span class="emailResult"></span>
                                    </div>
                                    <div>
                                        <input type="text" name=authCode id="authCode" placeholder="인증번호 입력">
                                        <button id="btnAuthCode">확인</button><span class="codeResult"></span>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <p>
                    비밀번호를 찾고자 하는 아이디와 이메일을 입력해 주세요. <br>
                    회원가입시 입력한 아이디와 이메일 주소가 같아야, 인증번호를 받을 수 있습니다. <br>
                    인증번호를 입력 후 확인 버튼을 누르세요.
                </p>
                <div>
                    <a href="#">취소</a>
                    <a href="#" id="next">다음</a>
                </div>
            </section>
        </main>
        <footer>
            <div>
                <div>
                    <img src="/farmStory/images/footer_logo.png" alt="팜스토리 로고">
                    <div>
                        <p>
                            (주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-부산진구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호<br>
                            등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동<br>
                            대표 : 홍길동 / 이메일 : honggildong@gmail.com / 전화 : 01) 234-5678 / 부산광역시 부산진구 부전동 123
                        </p>
                        <p>
                            copyrightⓒ 홍길동 All rights reserved.
                        </p>
                        <p>
                            farmstory ver1.0.1
                        </p>
                    </div>
                </div>
            </div>
        </footer>
</body>
</html>