<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<header>
    <h3>
        <a href="/jboard" class="title">Board Project</a>
    </h3>
    <p>
        <a href="/jboard/user/info.do" class="info">${sessionScope.sessUser.nick}</a>님 반갑습니다.
        <a href="/jboard/user/logout.do">[로그아웃]</a>
    </p>
</header>