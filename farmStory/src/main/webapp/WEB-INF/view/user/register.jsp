<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/farmStory/js/daumPostcode.js"></script>
<script src="/farmStory/js/validation.js"></script> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 회원가입</title>
    <link rel="stylesheet" href="/farmStory/css/layout.css"/>
    <link rel="stylesheet" href="/farmStory/css/user/register.css"/>
    <style>
	    header {
	        width: 980px;
	        height: 142px;
	    }
    </style>
</head>

<%@ include file="../layout/_header.jsp" %>


<main id="user">
        <section class="register">
            <form action="/farmStory/user/register.do" name="formRegister" id="formRegister" method="post">
                <h2 class="tit">사이트 이용정보 입력</h2>
                <table border="1">

                        <tr>
                            <td>아이디</td>
                            <td>
                                <input type="text" name="uid" placeholder="아이디 입력">
                                <button type="button" id="btnCheckUid">
                                    <img src="/farmStory/images/user/chk_id.gif" alt="중복확인">
                                </button>
                                <span class="uidResult"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td>
                                <input type="password" name="pass1" placeholder="비밀번호 입력">
                                <span class="passResult"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호 확인</td>
                            <td>
                                <input type="password" name="pass2" placeholder="비밀번호 입력 확인">
                            </td>
                        </tr>

                </table>
                
                <h2 class="tit">개인정보 입력</h2>
                <table border="1">
  
                        <tr>
                            <td>이름</td>
                            <td>
                                <input type="text" name="name" placeholder="이름 입력">
                                <span class="nameResult"></span>      
                            </td>
                        </tr>
                        <tr>
                            <td>별명</td>
                            <td>
                                <p class="nickInfo">공백없는 한글, 영문, 숫자 입력</p>
                                <input type="text" name="nick" placeholder="별명 입력">
                                <button type="button" id="btnCheckNick">
                                    <img src="/farmStory/images/user/chk_id.gif" alt="중복확인">
                                </button>
                                <span class="nickResult"></span>
                            </td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>
                                <input type="email" name="email" placeholder="이메일 입력">
                                <button type="button" id="btnSendEmail">
                                    <img src="/farmStory/images/user/chk_auth.gif" alt="인증번호 받기">
                                </button>
                                <span class="emailResult"></span>
                                <div class="auth">
                                    <input type="text" name="auth" placeholder="인증번호 입력">
                                    <button type="button" id="btnAuthEmail">
                                        <img src="/farmStory/images/user/chk_confirm.gif" alt="확인">
                                    </button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>휴대폰</td>
                            <td>
                                <input type="text" name="hp" placeholder="휴대폰 입력">
                                <span class="hpResult"></span>
                            </td>
                        </tr>
                        <tr>
                    <td>주소</td>
                    <td>
                        <input type="text" name="zip" id="zip" readonly placeholder="우편번호"/>
                        <button type="button" onclick="daumPostcode()"><img src="/farmStory/images/chk_post.gif" alt="우편번호찾기"/></button>
                        <input type="text" name="addr1" id="addr1" readonly placeholder="주소 검색"/>
                        <input type="text" name="addr2" id="addr2" placeholder="상세주소 입력"/>
                    </td>
                </tr>
     
                </table>
                <div>
                    <a href="/farmStory/user/login.do" class="btn btnCancel">취소</a>
                    <input type="submit" value="회원가입" class="btn btnRegister">
                </div>
            </form>
        </section>
       </main>

<%@ include file="../layout/_footer.jsp" %>    