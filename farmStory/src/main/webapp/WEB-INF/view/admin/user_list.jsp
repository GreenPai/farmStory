<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 메인페이지</title>
	<link rel="stylesheet" href="/farmStory/css/admin/layout/layout.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/user_list.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/main.css"/>
	<style>
		main {
            width: 980px;
            height: 658px;
            margin: 0px auto;
        }
	</style>
</head>
<script>

	    // 팝업창을 열어서 사용자 상세정보를 표시하는 함수
	    function openUserDetailPopup(uid) {
	        // 사용자의 상세 정보를 가져오는 URL을 설정 (예시: userDetail.jsp?uid=uid)
	        var url = "/farmStory/admin/detail.do?uid=" + uid;
	        // 팝업 창 옵션 설정
	        var popupOptions = "width=600,height=700,scrollbars=yes,resizable=yes";
	
	        // 팝업 창 열기
	        window.open(url, "UserDetailPopup", popupOptions);
	    };

</script>
<%@ include file="../admin/layout/_header.jsp" %>
<main>
<%@ include file="../admin/layout/_aside.jsp" %>
<section class="right_section">
    <p class="title">회원목록</p>

    <article>
        <p class="m-10">회원목록</p>
        <table class="user_list">
            <thead>
                <tr>
                    <th><input type="checkbox"></th>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>별명</th>
                    <th>이메일</th>
                    <th>휴대폰</th>
                    <th>등급</th>
                    <th>가입일</th>
                    <th>확인</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>${user.uid}</td>
                        <td>${user.name}</td>
                        <td>${user.nick}</td>
                        <td>${user.email}</td>
                        <td>${user.hp}</td>
                        <td>${user.userLevel}</td>
                        <td>${user.regDate}</td>
                        <td><a href="#" onclick="openUserDetailPopup('${user.uid}')">[상세확인]</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </article>
    <div class="page">
                	<c:if test="${pageGroupDTO.start>1}">
                    <a href="/farmStory/admin/user/list.do?pg=${pageGroupDTO.start -1}" class="prev">이전</a>
                    </c:if>
                    <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end }">
                    <a href="/farmStory/admin/user/list.do?pg=${num}" class="num ${currentPage==num ? 'current' : '' }">[${num}] &nbsp;</a>
                    </c:forEach>
                    <c:if test="${pageGroupDTO.end<lastPageNum}">
                    <a href="/farmStory/admin/user/list.do?pg=${pageGroupDTO.end + 1}" class="next">다음</a>
                    </c:if>
                </div>
</section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>

</body>
</html>
