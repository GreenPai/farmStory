<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/user/login.css"/>

</head>

<%@ include file="../layout/_header.jsp" %>
<script>
	const result = ${result};

	if(result == 100){
		alert('로그인 실패 했습니다.\n아이디, 비번을 다시 확인하세요.');
	}else if(result == 101){
		alert('정상적으로 로그아웃 되었습니다.');
	}
</script>

<main id="user">
            <section class="login">
                <form action="/farmStory/user/login.do" method="post"	>
                    <table>
                        <tbody>
                            <tr>
                                <td><img src="/farmStory/images/user/login_ico_id.png" alt="아이디"></td>
                                <td><input type="text" name="uid" placeholder="아이디 입력"></td>
                            </tr>
                            <tr>
                                <td><img src="/farmStory/images/user/login_ico_pw.png" alt="비밀번호"></td>
                                <td>
                                    <input type="password" name="pass" placeholder="비밀번호 입력"></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="submit" style="border-color: #bbbbbb;" value="로그인" class="btnLogin">
                </form>
                <div class="social_login">
                    <a href="http://naver.com" target="blank"><img src="/farmStory/images/user/naver_login.PNG" alt="네이버 로그인"></a>
                    <a href="http://kakao.com" target="blank"><img src="/farmStory/images/user/kakao_login.PNG" alt="카카오 로그인"></a>
                    <a href="http://google.com" target="blank"><img src="/farmStory/images/user/google_login.PNG" alt="구글 로그인"></a>
                </div>
                <div>
                    <h3>회원 로그인 안내</h3>
                    <p>아직 회원이 아니시면 회원으로 가입하세요.</p>
                    <div style="text-align: right;">
                        <a href="/farmStory/find/userId.do">아이디 | </a>
                        <a href="/farmStory/find/password.do">비밀번호찾기 | </a>
                        <a href="/farmStory/user/terms.do">회원가입</a>
                    </div>
                </div>
            </section>
        </main>
<%@ include file="../layout/_footer.jsp" %>       