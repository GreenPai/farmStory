<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 세션에서 사용자 정보 가져오기
    Object sessUser = session.getAttribute("sessUser");
%>
<body>
<div id="wrapper">
<header>
      <div id="link">
        <div>
          <div id="home">
            <a href="/farmStory/index.do">HOME |</a>
            
            <% if (sessUser == null) { // 로그인하지 않은 경우 %>
              <a href="/farmStory/user/login.do">로그인 |</a>
              <a href="/farmStory/user/terms.do">회원가입 |</a>
            <% } else { // 로그인한 경우 %>
              <a href="/farmStory/user/logout.do">로그아웃 |</a>
              <a href="/farmStory/myinfo/basket.do">나의정보 |</a>
            <% } %>

            <a href="/farmStory/admin/main.do">관리자 |</a>
            <a href="/farmStory/article/list.do?cate=qna1">고객센터</a>
          </div>
        </div>

        <div>
          <article>
            <a href="/farmStory/index.do" class="logo">
              <img src="/farmStory/images/logo.png" alt="팜스토리" />
              
            </a>

            <img src="/farmStory/images/head_txt_img.png" class="head_txt_img"   alt="3만원이상 무료배송 팜카드 10%적립" />

          </article>
        </div>
      </div>

      <div id="list">
        <nav>
          <ul>
            <li><a href="/farmStory/intro.do"><img src="/farmStory/images/head_menu1.png" alt="팜스토리소개"></a></li>
            <li><a href="/farmStory/basket/list.do"><img src="/farmStory/images/head_menu2.png" alt="장보기"></a></li>
            <li><a href="/farmStory/article/list.do?cate=grow"><img src="/farmStory/images/head_menu3.png" alt="농작물이야기"></a></li>
            <li><a href="/farmStory/event.do"><img src="/farmStory/images/head_menu4.png" alt="이벤트"></a></li>
            <li><a href="/farmStory/article/list.do?cate=notice"><img src="/farmStory/images/head_menu5.png" alt="커뮤니티"></a></li>
          </ul>
        </nav>
      </div>

      <div class="background">
            <img src="/farmStory/images/sub_top_tit3.png" alt="EVENT" class="event">
      </div>
    </header>