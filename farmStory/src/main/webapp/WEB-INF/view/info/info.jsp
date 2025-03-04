<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/farmStory/js/daumPostcode.js"></script>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/basket.css"/>
    <link rel="stylesheet" href="/farmStory/css/myinfo/info.css"/>
</head>
<script>
	
	//유효성 검사에 사용할 정규표현식
	const reUid   = /^[a-z]+[a-z0-9]{4,19}$/g;
	const rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
	const reName  = /^[가-힣]{2,10}$/ 
	const reNick  = /^[a-zA-Zㄱ-힣0-9][a-zA-Zㄱ-힣0-9]*$/;
	const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	const reHp    = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;

	// 2. 비밀번호 유효성 검사
	document.addEventListener('DOMContentLoaded', function () {
	    const formRegister = document.getElementById('formRegister');
	    const pass1 = formRegister.querySelector('[name="pass1"]');
	    const pass2 = formRegister.querySelector('[name="pass2"]');
	    const passResult = document.querySelector('.passResult');
	    
	    let isPassOk = false; // isPassOk 변수 선언

	    pass2.addEventListener('focusout', function () {
	        const value1 = pass1.value;
	        const value2 = pass2.value;

	        if (value1 === value2) {
	            passResult.innerText = '비밀번호가 일치합니다.';
	            passResult.style.color = 'green';
	            isPassOk = true;
	        } else {
	            passResult.innerText = '비밀번호가 일치하지 않습니다.';
	            passResult.style.color = 'red';
	            isPassOk = false;
	        }
	    });
	});

</script>

<%@ include file="../layout/_header_bg.jsp" %>
<main>
        <section class="left_section">
            <aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/myinfo/myinfo_menu_tit.png" alt="나의정보" >
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                          <a href="/farmStory/myinfo/basket.do">
                              <img src="/farmStory/images/myinfo/myinfo_menu1.png" alt="장바구니">
                          </a>
                      </li>
                      <li>
                        <a href="/farmStory/myinfo/list.do">
                            <img src="/farmStory/images/myinfo/myinfo_menu2.png" alt="주문내역">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/myinfo/info.do">
                            <img src="/farmStory/images/myinfo/myinfo_menu3_ov.png" alt="정보수정">
                        </a>
                      </li>

                  </ul>
              </article>
            </aside>
        </section>

        <section class="right_section">
            <article>
                <div>
                  <div class="sub_nav_tit">
                    <img src="/farmStory/images/myinfo/myinfo_nav_tit3.png" class="sub_nav_tit_cate1_tit2" alt="정보수정">
                  </div>
                  <div>
                    <p class="intro">
                       <img src="/farmStory/images/sub_page_nav_ico.gif" alt="인사말">
                         HOME > 나의정보 > <span class="eco_txt">정보수정&nbsp </span>
                    </p>
                  </div>  
                </div>
                
                
                <div class="content">
                	<div id="user">
	                    <form action="/farmStory/user/register.do" name="formRegister" id="formRegister" method="post">
				            <h2 class="tit">회원정보 설정</h2>
				            <table border="1">
				            <tr>
	                            <td>아이디</td>
	                            <td>
	                                <input type="hidden" name="uid" value="${sessUser.uid}">${sessUser.uid}
	                            </td>
	                        </tr>
	                        <tr>
			                    <td>비밀번호</td>
			                    <td>
			                        <input type="password" name="pass1" placeholder="비밀번호 입력"/>
			                        <span class="passResult"></span>
			                    </td>
			                </tr>
			                <tr>
			                    <td>비밀번호 확인</td>
			                    <td>
			                        <input type="password" name="pass2" placeholder="비밀번호 입력 확인"/>
			                        <button type="button" class="btnUpdatePass">비밀번호 수정</button>
			                        <div class="passChange" style="margin-top:5px;">
			                        	<input type="text" name="auth" placeholder="비밀번호 입력">
			                        	<button type="button" class="btnUpdatePass">비밀번호 변경</button><br>
			                        	<span class="passResult"></span>
			                        </div>
			                    </td>
			                </tr>
				                <tr>
				                    <td>회원가입날짜</td>
				                    <td>2022-01-01 12:45:12</td>
				                </tr>
				            </table>
				
				            <h2 class="tit">개인정보 수정</h2>
				            <table border="1">
				                <tr>
				                    <td>이름</td>
				                    <td>
				                        <input type="text" name="name" value=""/>
				                        <span class="nameResult"></span>                     
				                    </td>
				                </tr>
				                <tr>
				                    <td>별명</td>
				                    <td>
				                        <p class="nickInfo">공백없는 한글, 영문, 숫자 입력</p>
				                        <input type="text" name="nick" placeholder="별명 입력"/>
				                        <button type="button" id="btnNickCheck"><img src="../images/chk_id.gif" alt="중복확인"/></button>
				                        <span class="nickResult"></span>
				                    </td>
				                </tr>
				                <tr>
				                    <td>이메일</td>
				                    <td>
				                        
				                        <input type="email" name="email" placeholder="이메일 입력"/>
				                        <span class="emailResult"></span>
				                        <button type="button" id="btnEmailAuth"><img src="../images/chk_auth.gif" alt="인증번호 받기"/></button>
				                        <div class="auth">
				                            <input type="text" name="auth" placeholder="인증번호 입력"/>
				                            <button type="button" id="btnEmailConfirm"><img src="../images/chk_confirm.gif" alt="확인"/></button>
				                        </div>
				                    </td>
				                </tr>
				                <tr>
				                    <td>휴대폰</td>
				                    <td>
				                        <input type="text" name="hp" placeholder="휴대폰 입력"/>
				                        <span class="hpResult"></span>
				                    </td>
				                </tr>
				                <tr>
				                    <td>주소</td>
				                    <td>
				                        <input type="text" name="zip" id="zip" readonly="readonly" placeholder="우편번호"/>
				                        <button type="button"><img src="../images/chk_post.gif" alt="우편번호찾기"/></button>
				                        <input type="text" name="addr1" id="addr1" placeholder="주소 검색"/>
				                        <input type="text" name="addr2" id="addr2" placeholder="상세주소 입력"/>
				                    </td>
				                </tr>
				                <tr>
				                    <td>회원탈퇴</td>
				                    <td>
				                        <button type="button" class="btnWithdraw">탈퇴하기</button>
				                    </td>
				                </tr>
				            </table>        
				            <div style="margin-bottom:10px;">
				                <a href="/jboard/article/list.do" class="btn btnCancel">취소</a>
				                <input type="submit" value="회원수정" class="btn btnRegister"/>
				            </div>        
				        </form>
                	</div>
               	</div>

            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       