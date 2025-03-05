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
                                <td><a href="#">[상세확인]</a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                        
                        
                    </table>
                    <div class="page"  >
                        <p > < [1] [2] [3] [4] [5] ></p>
                    </div>
                </article>
            </section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>
</body>
</html>