<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/pamStory/css/layout.css"/>
    <link rel="stylesheet" href="/pamStory/css/user/login.css"/>
    
</head>

<%@ include file="../basic/layout/_header.jsp" %>
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
          <div>
            <form action="/pamStory/user/login.do" method="post">
              <table border="0">
                <tbody>
                  <tr>
                    <td>
                      <img src="/pamStory/images/user/login_ico_id.png" alt="아이디">
                    </td>
                    <td>
                      <input type="text" name="uid" placeholder="아이디 입력">
                    </td>
                  </tr>
  
                  <tr>
                    <td>
                      <img src="/pamStory/images/user/login_ico_pw.png" alt="비밀번호">
                    </td>
                    <td>
                      <input type="password" name="pass" placeholder="비밀번호 입력">
                    </td>
                  </tr>
  
                </tbody>
              </table>
              <input type="submit" value="로그인" class="btnLogin">
              <img src="/pamStory/images/user/login_favicon.png" alt="Favicon Image" class="favicon" usemap="#faviconmap">
              <map name="faviconmap">
                <area shape="rect" coords="0,0,32,32" href="http://naver.com" alt="Naver">
                <area shape="rect" coords="34,0,66,32" href="http://kakao.com" alt="Kakao">
                <area shape="rect" coords="68,0,100,32" href="http://google.com" alt="Google">
              </map>
            </form>
          </div>
          <div>
            <h3>회원 로그인 안내</h3>
            <p>아직 회원이 아니시면 회원으로 가입하세요.</p>
            <div style="text-align: right;">
              <a href="/pamStory/find/userId.do">아이디 |</a>
              <a href="/pamStory/find/password.do">비밀번호찾기 |</a>
              <a href="/pamStory/user/terms.do">회원가입</a>
            </div>
          </div>
        </section>
      </main>
<%@ include file="../layout/_footer.jsp" %>       