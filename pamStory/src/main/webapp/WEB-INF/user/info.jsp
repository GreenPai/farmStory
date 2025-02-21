<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>user</title>
    <link rel="stylesheet" href="/pamStory/css/layout.css"/>
</head>
<body>
<%@ include file="../layout/_header.jsp" %>
<main id="user">
    <section class="info">
        <form action="#" method="post">
            <h2 class="tit">회원정보 설정</h2>
            <table border="1">
                <tr>
                    <td>아이디</td>
                    <td>abc</td>
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
            <div>
                <a href="../article/list.html" class="btn btnCancel">취소</a>
                <input type="submit" value="회원수정" class="btn btnRegister"/>
            </div>        
        </form>
    </section>
</main>
<%@ include file="../layout/_footer.jsp" %>    